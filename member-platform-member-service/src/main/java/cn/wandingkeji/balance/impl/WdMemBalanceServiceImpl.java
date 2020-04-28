package cn.wandingkeji.balance.impl;

import cn.wandingkeji.balance.IWdMemBalTransService;
import cn.wandingkeji.balance.IWdMemBalanceService;
import cn.wandingkeji.bonus.service.IWdMemBonTransService;
import cn.wandingkeji.bonus.service.IWdMemBonusService;
import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.comm.enums.WriteOff;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import cn.wandingkeji.common.constant.Constant;
import cn.wandingkeji.coupon.api.WdBindCodeApi;
import cn.wandingkeji.coupon.entity.WdBindCode;
import cn.wandingkeji.member.entity.WdMemBalTrans;
import cn.wandingkeji.member.entity.WdMemBalance;
import cn.wandingkeji.member.entity.WdMember;
import cn.wandingkeji.member.mapper.WdMemBalanceMapper;
import cn.wandingkeji.member.service.IWdMemberService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service("wdMemBalanceService")
public class WdMemBalanceServiceImpl implements IWdMemBalanceService {
	
	private static final Logger log = LoggerFactory.getLogger(WdMemBalanceServiceImpl.class);
	@Autowired
	private WdMemBalanceMapper wdMemBalanceMapper;
	@Autowired
	private IWdMemBalTransService wdMemBalTransService;
	@Autowired
	private IWdMemBonusService wdMemBonusService;
	@Autowired
	private IWdMemBonTransService wdMemBonTransService;

	@Autowired
	private IWdMemberService wdMemberService;

	@Autowired
	private WdBindCodeApi wdBindCodeApi;
	
	/**
	 * @param member_id 会员id
	 * @param bonus 积分
	 * @param isTure 
	 * @param balance 金额
	 * @param requestMap
	 * @return returnMap
	 * <br>支付完成功后收到通知更新余额积分变动明细,并且更新余额 积分
	 * <br>1.更新平台订单
	 * <br>2.更新余额变动明细,账户余额
	 * <br>3.更新余额变动明细,账户余额(先查询是否有积分变动,没有不用此步骤)
	 */
	/*public Map<String,Object> updateMemBalanceAndBonu(WdMember member, MemOrderRecord memOrderRecord){
		Map<String, Object> returnMap = new HashMap<>();
		log.info("***进入updateMemBalanceAndBonus()方法***");
		try {
			if(ScenceEnum.SCZ.getScence().equals(memOrderRecord.getScence()) || ScenceEnum.SXF.getScence().equals(memOrderRecord.getScence()) ) {
				//2.更新余额变动明细,账户余额
				boolean isBanlance = updateBalanceAndTrans2(memOrderRecord.getMemId(), memOrderRecord.getAmount(), memOrderRecord.getOrder_id(), memOrderRecord.getScence());
				if (!isBanlance) {
					log.info("***更新余额失败***");
					returnMap.put("subCode", "100000");
					return returnMap;
				}
			}
			//TODO 3.查询充值规则判断是否送积分
			BigDecimal bouns = CommUtils.getBouns(memOrderRecord.getAmount(), memOrderRecord.getScence());
			//4.更新积分变动明细,账户积分(先查询是否有积分变动,没有不用此步骤)
			//积分不等于0,则有积分变动
			if (bouns.compareTo(BigDecimal.ZERO) != 0) {
				log.info("***更新积分方法***");
				boolean isSuccess = wdMemBonusService.updateBonusAndTrans(memOrderRecord.getMemId(),  memOrderRecord.getBonus(), true, null);
				if (isSuccess) {
					log.info("***更新本地积分成功***");
					//TODO 开始调用更新微信积分方法
					//wdMemberService.updateWX(bouns);
					returnMap.put("subCode", "000000");
				} else {
					log.info("***更新积分失败***");
					returnMap.put("subCode", "100000");
				}
			} 
			
			
		} catch (Exception e) {
			log.info("***会员充值消费异常***");
			returnMap.put("subCode", "100000");
			log.error(ExceptionUtils.getStackTrace(e));
		}
		return  returnMap;
	}*/
	
	/**
	 * 充值消费(创建记录)
	 * 	创建订单(不体现)
	 * 2.创建余额变动明细
	 * 3.查询充值消费规则,是否有几分变动
	 *  3.1如有积分变动,调取积分相应的业务
	 * 
	 */
	@Override
	public Map<String,Object> insertMemCardRechargeRecord(String rule,BigDecimal balance,WdMember wdmember,Map<String, Object> requestMap) {
		log.info("充值业务入参(insertMemCardRechargeRecord):===="+requestMap);
		Map<String, Object> returnMap = new HashMap<>();
		//接受参数
		try {
			//TODO 1.创建订单
			
			//2.创建余额变动明细,并且存入相应的规则(如充值送积分,充值送卡,券等......)
			/*Map<String, Object> insertMap = wdMemBalTransService.insertParam(balance,wdmember,requestMap);
			if("000000".equals(insertMap.get("subCode"))) {
				//TODO 3.查询充值消费规则
				//4.如有积分变动,调取添加积分变动明细service
				if (true) {
					wdMemBonTransService.insertTrans(rule, balance,wdmember,requestMap);
				} 
				
			}else {
				returnMap.put("subCode", "100000");
			}*/
		} catch (Exception e) {
			returnMap.put("subCode", "100000");
			log.error(ExceptionUtils.getStackTrace(e));
		}
		return returnMap;
	}
	
	/**
	 * 更新会员余额变动,余额明细方法
	 * 判断支付是否成功
	 * 1成功
	 * 	1.1更新余额明细(状态为成功)
	 * 	1.2更新账户余额
	 * 2失败
	 * 	2.1更新余额明细(状态为失败)
	 */
	@Override
	public Map<String,Object> updateBalanceAndTrans(Map<String,Object> requestMap){
		Map<String,Object> returnMap = new HashMap<>();
		String balance = (String)requestMap.get("balance");
		
		WdMemBalTrans selectByCondtion = wdMemBalTransService.selectByCondtion(requestMap);
		BigDecimal bigDecimal = new BigDecimal(balance);
		//更新余额变动明细记录 成功:更新余额,失败直接返回
		WdMemBalTrans wdMemBalTrans = new WdMemBalTrans();
		wdMemBalTrans.setId(selectByCondtion.getId());
		//交易金额
		wdMemBalTrans.setAmount(bigDecimal);
		//当前余额
		wdMemBalTrans.setAccount_balance(bigDecimal);
		int insertSuccess = wdMemBalTransService.updateByPrimaryKey(wdMemBalTrans);
		if(1==insertSuccess) {
			WdMemBalance wdMemBalance = new WdMemBalance();
			//余额更新成功后,
			//可用金额  计算方式待定
			wdMemBalance.setActual_balance(bigDecimal);
			int updateSuceess= updateByBalanceId(wdMemBalance);
			if(updateSuceess==1) {
				
				returnMap.put("subCode", "000000");
			}else {
				returnMap.put("subCode", "100000");
			}
		}else {
			returnMap.put("subCode", "100000");
		}

		return returnMap;
	}
	@Override
	public boolean updateBalanceAndTrans2(int mem_id,BigDecimal balance,String orderId,String sign){
		boolean isSuccess = false;
		int insertSuccess = 0;
		BigDecimal actual_balance = new  BigDecimal("0.00");
		//接受参数
		try {
			Map<String,Object> conditionMap = new HashMap<>();
			conditionMap.put("member_id", mem_id);
			WdMemBalance memBalance = selectByCondition(conditionMap);
			if(memBalance == null) {
				log.info("***余额账户为空***");
				return isSuccess;
			}
			WdMemBalTrans memBalTrans = wdMemBalTransService.selectByCondtion(conditionMap);
			//更新余额变动明细记录 成功:更新余额,失败直接返回
			WdMemBalTrans wdMemBalTrans = new WdMemBalTrans();
			//交易金额
			wdMemBalTrans.setAmount(balance);
			//订单号
			wdMemBalTrans.setOrder_id(orderId);
			//当前余额
			if(WriteOff.SIGN1.getSta().equals(sign)) {
				actual_balance = memBalance.getActual_balance().subtract(balance);
			}else if(WriteOff.SIGN2.getSta().equals(sign)){
				actual_balance = memBalance.getActual_balance().add(balance);
			}
			wdMemBalTrans.setAccount_balance(actual_balance);
			if(memBalTrans!=null) {
				log.info("余额明细不为空---更新");
				wdMemBalTrans.setId(memBalTrans.getId());
				insertSuccess = wdMemBalTransService.updateByPrimaryKey(wdMemBalTrans);
			}else {
				log.info("余额明细为空---添加");
				//会员消费 添加
				wdMemBalTrans.setCreat_stamp(new Timestamp(System.currentTimeMillis()));
				insertSuccess = wdMemBalTransService.insert(wdMemBalTrans);
			}
			if (1 == insertSuccess) {
				WdMemBalance wdMemBalance = new WdMemBalance();
				//余额更新成功后,
				//可用金额  计算方式待定
				wdMemBalance.setActual_balance(actual_balance);
				wdMemBalance.setId(memBalance.getId());
				int updateSuceess = updateByBalanceId(wdMemBalance);
				if (updateSuceess == 1) {
					isSuccess = true;
				}
			} 
		} catch (Exception e) {
			log.info("更新余额和明细异常");
			log.info(ExceptionUtils.getStackTrace(e));
		}
		return isSuccess;
	}

	/**
	 *
	 * @param mem_id
	 * @param orderId
	 * @param scence
	 * @param status
	 * @return
	 */
	@Override
	public Map<String, Object>  updateBalanceAndTrans3(int mem_id,String orderId,String scence,String status){
		Map<String, Object> returnMap = new HashMap<>();
		int insertSuccess = 0;
		//接受参数
		try {
			Map<String,Object> conditionMap = new HashMap<>();
			conditionMap.put("member_id", mem_id);
			conditionMap.put("order_id", orderId);
			WdMemBalance memBalance = selectByMemId(String.valueOf(mem_id));
			if(memBalance == null) {
				log.info("***余额账户为空***");
			}
			WdMemBalTrans memBalTrans = wdMemBalTransService.selectByCondtion(conditionMap);
			//更新余额变动明细记录 成功:更新余额,失败直接返回
			WdMemBalTrans wdMemBalTrans = new WdMemBalTrans();
			//当前余额
			if(memBalTrans!=null) {
				log.info("***WdMemBalTrans="+ memBalTrans.toString());
				log.info("余额明细不为空---更新");
				wdMemBalTrans.setId(memBalTrans.getId());
				wdMemBalTrans.setStatus(status);
				insertSuccess = wdMemBalTransService.updateByPrimaryKey(wdMemBalTrans);
				log.info("insertSuccess=="+insertSuccess);
			}else {
				log.info("余额明细为空---不存在此种情况");
				//会员消费 添加
				wdMemBalTrans.setCreat_stamp(new Timestamp(System.currentTimeMillis()));
				insertSuccess = wdMemBalTransService.insert(wdMemBalTrans);
			}
			if( WriteOff.STA1.getSta().equals(status)) {
				returnMap.put("subCode", "000000");
				log.info("***更新明细完成*支付状态为失败,不需要更新余额账户**");
				return returnMap;
			}
			if (1 == insertSuccess) {
				WdMemBalance wdMemBalance = new WdMemBalance();
				//余额更新成功后,
				//可用金额  计算方式待定
				log.info("可用余额="+memBalTrans.getAccount_balance());
				wdMemBalance.setActual_balance(memBalTrans.getAccount_balance());
				wdMemBalance.setId(memBalance.getId());
				updateByBalanceId(wdMemBalance);
			} 
			returnMap.put("subCode", "000000");
			log.info("***更新余额和明细完成***");
			
		} catch (Exception e) {
			returnMap.put("subCode", "100000");
			log.info("更新余额和明细异常");
			log.info(ExceptionUtils.getStackTrace(e));
		}
		return returnMap;
	}
	
	@Override
	public WdMemBalance selectByBalanceId(int id) {
		return wdMemBalanceMapper.selectByBalanceId(id);
	}

	@Override
	public WdMemBalance selectByCondition(Map<String, Object> condition) {
		return wdMemBalanceMapper.selectByCondition(condition);
	}
	@Override
	public WdMemBalance selectByMemId(String member_id) {
		return wdMemBalanceMapper.selectByMemId(member_id);
	}

	@Override
	public int insert(WdMemBalance wdMemBalance) {
		return wdMemBalanceMapper.insert(wdMemBalance);
	}

	@Override
	public int updateByBalanceId(WdMemBalance wdMemBalance) {
		return wdMemBalanceMapper.updateByBalanceId(wdMemBalance);
	}

	@Override
	public int deleteByBalanceId(int id) {
		return wdMemBalanceMapper.deleteByBalanceId(id);
	}

	@Override
	public int insertWdMemBalance(WdMember updateWdMember, GetUserInfoRes getUserInfoRes, WdMemCard memCard,
								  String cardId, String code) {
		Map<String,Object> map=new HashMap<>();
		Map<String,Object> condition=new HashMap<>();
		condition.put("card_id",cardId);
		condition.put("user_code_id",code);
		WdMemBalance conditionMemBalance = selectByCondition(condition);
		if(conditionMemBalance!=null) {
			log.info("已激活");
			return 1;
		}
		map.put("memberId", String.valueOf(updateWdMember.getId()));
		map.put("getUserInfoRes", getUserInfoRes);
		Timestamp time=new Timestamp(new Date().getTime());
		map.put("time", time);
		map.put("code", code);
		map.put("card_id", cardId);
		map.put("userName", updateWdMember.getName());
		map.put("mid", memCard.getMid());
		String levelId = updateWdMember.getLevel();
		if(StringUtils.isNotEmpty(levelId)){
			map.put("levelId", levelId);
		}
		log.info("创建余额账户start");
		int success=insertAfterCreatMem(map);
		log.info("拉取会员信息，添加余额账户信息="+success);
		return success;
	}

	public int insertAfterCreatMem(Map<String, Object> map) {
		log.debug("创建账户入参==========="+map.toString());
		WdMemBalance memAccount=new WdMemBalance();
		 String memberId= (String) map.get("memberId");
		 String code=(String) map.get("code");
		 String card_id=(String) map.get("card_id");
		 String userName=(String) map.get("userName");
		 String levelId=(String) map.get("levelId");
		 int mid=(int)map.get("mid");
		 Timestamp  time=(Timestamp)map.get("time");
		 GetUserInfoRes getUserInfoRes=(GetUserInfoRes)map.get("getUserInfoRes");
		  memAccount.setMember_id(memberId);//会员主键
		  memAccount.setUser_code_id(code);
		  memAccount.setCard_id(card_id);
		  memAccount.setStatus("1");
		  if(StringUtils.isNotEmpty(userName)){
		  memAccount.setAccount_name(userName);
		  }else{
			  try {
				memAccount.setAccount_name(URLEncoder.encode(getUserInfoRes.getNickname(), Constant.DEFAULT_CHARSET));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		  }
		  memAccount.setAccount_num(getUserInfoRes.getMembership_number());
		  memAccount.setUom("RMB");
		  memAccount.setOrg(String.valueOf(mid));
		  memAccount.setOwner_id(getUserInfoRes.getOpenid());
		  memAccount.setFrom_date(time);
		//  memAccount.setLevel(level);
		  BigDecimal balance = getUserInfoRes.getBalance();
		  if(balance==null){
			  balance = BigDecimal.ZERO;
		  }
		  memAccount.setActual_balance(balance);
		  memAccount.setAvailable_balance(balance);
		  String bouns= getUserInfoRes.getBonus();
		  if(StringUtils.isNotEmpty(bouns)){
			  memAccount.setAccount_bouns(new BigDecimal(bouns));
		  }else{
			  memAccount.setAccount_bouns(BigDecimal.ZERO);
		  }
		  if(StringUtils.isNotEmpty(levelId)){
			  memAccount.setLevel(levelId);
		  }
		  memAccount.setCum_trans_amt(BigDecimal.ZERO);
		  memAccount.setCreat_date(new Timestamp(new Date().getTime()));
		  
		  log.debug("创建账户==="+memAccount.toString());
		  int insertmemAcc=  wdMemBalanceMapper.insert(memAccount);
		  
		  log.debug("成功添加到账户"+insertmemAcc);
		  //TODO 根据有无积分判断是否添加到明细表里一条数据
		  if(StringUtils.isNotEmpty(bouns)){
			  BigDecimal amount =new BigDecimal(0.00);
			  Map<String,Object> insertMap = new HashMap<>();
			  insertMap.put("discount",BigDecimal.ZERO);
			  //insertAccountTrans(null, TransType.OUT, PayChannel.VIP, "1",memAccount, new BigDecimal(bouns),Reason.first,amount,null,null,insertMap);
		  }
		return insertmemAcc;
	}


	@Override
	public Map<String, Object> payment(String mdCode, String memId,BigDecimal price,Map<String, Object> memDonate) {
		Map<String,Object> map = new HashMap<>();
		try{
			//根据二维码校验信息（二维码时效性，用户身份）
			WdBindCode wdb = wdBindCodeApi.getByMdCode(mdCode);
			if(wdb ==null){
				map.put("status","100000");
				map.put("data","条码或二维码失效已删除！");
			}
			//判断时效性
			int efftivTime = wdb.getEffectiveTime();
			Long ts = wdb.getGmt_create().getTime();
			long time2 = System.currentTimeMillis();
			if((time2 -(ts+(long)efftivTime))>0){
				log.info("二维码失效，请重新刷新！");
				//删除原有失效二维码
				wdBindCodeApi.delByMdCode(mdCode);
				map.put("status","100000");
				map.put("data","二维码失效，请重新刷新！");
			}else {
				//判断二维码使用状态 1:未使用 2：已使用
				if ("1".equals(wdb.getStatus())) {
					//付费扣款
					//检查余额，扣款
					// 1.验证余额是否充足
					Map<String,Object> con = new HashMap<>();
					con.put("member_id", memId);
					WdMemBalance wdMembalance = selectByMemId(String.valueOf(memId));
					// 获取到余额账户中的可用余额 (元)乘100 变为分 和 totalFee 比较
					BigDecimal memBalanceFee = wdMembalance.getActual_balance().multiply(new BigDecimal(100));

					if(null !=memDonate ) {
						Double mapney = memDonate.get("donate_amount") == null?0:Double.parseDouble(memDonate.get("donate_amount").toString());
						BigDecimal hisdonate = BigDecimal.valueOf(mapney)
								.multiply(new BigDecimal(100));

						if (hisdonate.compareTo(new BigDecimal(0)) == 1) {
							log.info("账户赠送余额（单位分）：" + hisdonate);
							memBalanceFee=memBalanceFee.add(hisdonate);
						}
					}

					log.info("账户余额（单位分）：" + memBalanceFee);
					log.info("商品价格（单位分）" + price);
					if (memBalanceFee.compareTo(price) == -1) {
						map.put("status", "100000");
						map.put("data", "余额不足");
						return map;
					}
					//付款
					wdMembalance.setActual_balance(wdMembalance.getActual_balance().subtract(price));
					int aa = updateByBalanceId(wdMembalance);
					if(aa>0){
						map.put("status", "000000");
						map.put("data", "会员付款成功！");
					}
					//修改二维码状态
					wdb.setStatus("2");
					wdBindCodeApi.putById(wdb);
				}
			}
		}catch(Exception e){
			log.info("会员支付异常！请重试！");
			map.put("status", "100000");
			map.put("data", "会员支付异常！请重试！！");
		}
		return map;
	}
	
}
