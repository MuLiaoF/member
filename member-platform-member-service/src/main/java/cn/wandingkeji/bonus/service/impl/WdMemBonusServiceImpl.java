package cn.wandingkeji.bonus.service.impl;

import cn.wandingkeji.bonus.service.IWdMemBonTransService;
import cn.wandingkeji.bonus.service.IWdMemBonusService;
import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.comm.enums.NumSuc;
import cn.wandingkeji.comm.enums.WriteOff;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoRes;
import cn.wandingkeji.common.constant.Constant;
import cn.wandingkeji.member.entity.WdMemBonTrans;
import cn.wandingkeji.member.entity.WdMemBonus;
import cn.wandingkeji.member.entity.WdMember;
import cn.wandingkeji.member.mapper.WdMemBonusMapper;
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

/**
 * 会员积分业务实现类
 * @author jing_huan
 *
 */
@Service("wdMemBranchService")
public class WdMemBonusServiceImpl implements IWdMemBonusService {
	private static final Logger log = LoggerFactory.getLogger(WdMemBonusServiceImpl.class);
	@Autowired
	private WdMemBonusMapper wdMemBonusMapper;

	@Autowired
	private IWdMemBonTransService wdMemBonTransService;
	
	/**
	 * 更新积分以及添加积分变动明细记录
	 * 
	 * 1.更新积分变动明细记录
	 * 2.更新积分
	 * @param requestMap
	 * @return
	 */
	@Override
	public boolean updateBonusAndTrans(int mem_id,BigDecimal bonus,boolean isTure,Map<String,Object> requestMap){
		log.info("更新积分以及更新积分变动明细入参"+requestMap);
		boolean isSuccess = false ;
		int updateSuccess = 0;
		BigDecimal actual_balance = new  BigDecimal("0.00");
		//接受参数
		String orderId = (String)requestMap.get("order_id");
		String sign = (String)requestMap.get("sign");
		//TODO 接受参数
		try {
			//1.先查询积分以及积分变动明细实体
			Map<String,Object> conditionMap = new HashMap<>();
			conditionMap.put("member_id", mem_id);
			WdMemBonus conditionWdMemBonus = selectByCondition(conditionMap);
			if(conditionWdMemBonus  == null) {
				log.info("***积分账户为空***理论上不存在这种情况");
				return isSuccess;
			}
			WdMemBonTrans selectByCondition = wdMemBonTransService.selectByCondition(conditionMap);
		
			WdMemBonTrans wdMemBonTrans = new WdMemBonTrans();
			//"1" 为支付成功
			wdMemBonTrans.setStatus(WriteOff.COU1.getSta());
			wdMemBonTrans.setBouns(bonus);
			if(WriteOff.SIGN1.getSta().equals(sign)) {
				actual_balance = conditionWdMemBonus.getAccount_bouns().subtract(bonus);
			}else if(WriteOff.SIGN2.getSta().equals(sign)){
				actual_balance = conditionWdMemBonus.getAccount_bouns().add(bonus);
			}
			if(selectByCondition != null) {
				log.info("积分明细不为空---更新");
				wdMemBonTrans.setId(selectByCondition.getId());
				updateSuccess = wdMemBonTransService.updateByPrimaryKey(wdMemBonTrans);
			}else {
				log.info("积分明细为空---添加");
				wdMemBonTrans.setCreat_stamp(new Timestamp(System.currentTimeMillis()));
				updateSuccess =wdMemBonTransService.insert(wdMemBonTrans);
			}
			if (NumSuc.SUCEESS.getSta() == updateSuccess) {
				WdMemBonus wdMemBranch = new WdMemBonus();
				wdMemBranch.setAccount_bouns(wdMemBonTrans.getAccount_bouns());
				wdMemBranch.setId(conditionWdMemBonus.getId());
				updateById(wdMemBranch);
				isSuccess = true ;
				log.info("更新积分成功");
			} 
		} catch (Exception e) {
			log.info("更新积分异常");
			log.error(ExceptionUtils.getStackTrace(e));
			
		}
		log.info("更新积分以及更新积分变动明细出参"+isSuccess);
		return isSuccess;
	}
	
	
	@Override
	public WdMemBonus selectById(int id) {
		// TODO Auto-generated method stub
		return wdMemBonusMapper.selectById(id);
	}

	@Override
	public WdMemBonus selectByCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return wdMemBonusMapper.selectByCondition(condition);
	}

	@Override
	public int insert(WdMemBonus wdMemBrancht) {
		// TODO Auto-generated method stub
		return wdMemBonusMapper.insert(wdMemBrancht);
	}

	@Override
	public int updateById(WdMemBonus wdMemBranch) {
		// TODO Auto-generated method stub
		return wdMemBonusMapper.updateById(wdMemBranch);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return wdMemBonusMapper.deleteById(id);
	}
	@Override
	public int insertWdMemBonus(WdMember updateWdMember, GetUserInfoRes getUserInfoRes, WdMemCard memCard,
								String cardId, String code) {
		Map<String,Object> map=new HashMap<>();
		Map<String,Object> condition=new HashMap<>();
		condition.put("card_id",cardId);
		condition.put("user_code_id",code);
		WdMemBonus conditionMemBonus = selectByCondition(condition);
		if(conditionMemBonus!=null) {
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
		log.info("创建积分账户start");
		int success=insertAfterCreatMem(map);
		log.info("拉取会员信息，添加积分账户信息="+success);
		return success;
	}
	public int insertAfterCreatMem(Map<String, Object> map) {
		log.debug("创建积分账户入参==========="+map.toString());
		WdMemBonus memBonus=new WdMemBonus();
		 String memberId= (String) map.get("memberId");
		 String code=(String) map.get("code");
		 String card_id=(String) map.get("card_id");
		 String userName=(String) map.get("userName");
		 String levelId=(String) map.get("levelId");
		 int mid=(int)map.get("mid");
		 Timestamp  time=(Timestamp)map.get("time");
		 GetUserInfoRes getUserInfoRes=(GetUserInfoRes)map.get("getUserInfoRes");
		  memBonus.setMember_id(memberId);//会员主键
		  memBonus.setUser_code_id(code);
		  memBonus.setCard_id(card_id);
		  memBonus.setStatus("1");
		  if(StringUtils.isNotEmpty(userName)){
		  memBonus.setAccount_name(userName);
		  }else{
			  try {
				memBonus.setAccount_name(URLEncoder.encode(getUserInfoRes.getNickname(), Constant.DEFAULT_CHARSET));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		  }
		  memBonus.setAccount_num(getUserInfoRes.getMembership_number());
		  memBonus.setUom("RMB");
		  memBonus.setOrg(String.valueOf(mid));
		  memBonus.setOwner_id(getUserInfoRes.getOpenid());
		  memBonus.setFrom_date(time);
		//  memBonus.setLevel(level);
		  BigDecimal balance = getUserInfoRes.getBalance();
		  if(balance==null){
			  balance = BigDecimal.ZERO;
		  }
		  memBonus.setActual_balance(balance);
		  memBonus.setAvailable_balance(balance);
		  String bouns= getUserInfoRes.getBonus();
		  if(StringUtils.isNotEmpty(bouns)){
			  memBonus.setAccount_bouns(new BigDecimal(bouns));
		  }else{
			  memBonus.setAccount_bouns(BigDecimal.ZERO);
		  }
		  if(StringUtils.isNotEmpty(levelId)){
			  memBonus.setLevel(levelId);
		  }
		  memBonus.setCum_trans_amt(BigDecimal.ZERO);
		  memBonus.setCreat_date(new Timestamp(new Date().getTime()));
		  
		  log.debug("创建积分账户==="+memBonus.toString());
		  int insertmemAcc=  wdMemBonusMapper.insert(memBonus);
		  
		  log.debug("成功添加到积分账户"+insertmemAcc);
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
	public WdMemBonus selectByMemId(int memId) {
		// TODO Auto-generated method stub
		return wdMemBonusMapper.selectByMemId(memId);
	}
}
