package cn.wandingkeji.service.coupon.impl;

import cn.wandingkeji.card.entity.MerAndWxcard;
import cn.wandingkeji.card.entity.WdReceiveCard;
import cn.wandingkeji.comm.enums.FrequencyCardEnum;
import cn.wandingkeji.comm.enums.WriteOff;
import cn.wandingkeji.common.enums.ErrorCode;
import cn.wandingkeji.coupon.entity.WdFrequencyCard;
import cn.wandingkeji.coupon.entity.WdFrequencyTrans;
import cn.wandingkeji.coupon.entity.WdReceiveFrequency;
import cn.wandingkeji.member.api.WdMemberApi;
import cn.wandingkeji.member.entity.WdMember;
import cn.wandingkeji.service.card.IMerAndWxcardService;
import cn.wandingkeji.service.card.IReceiveCardService;
import cn.wandingkeji.service.coupon.IReceiveFrequencyCardService;
import cn.wandingkeji.service.coupon.IReceivefrequencyService;
import cn.wandingkeji.service.coupon.IWdFrequencyCardService;
import cn.wandingkeji.service.coupon.IWdFrequencyTransService;
import cn.wandingkeji.session.api.WxSessionApi;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 领取(或者核销)计次卡业务处理
 * @author jing_huan
 * @date 2019年5月20日
 *
 */
//@Transactional(rollbackFor = Exception.class)
@Service("receiveFrequencyCardService")
public class ReceiveFrequencyCardServiceImpl implements IReceiveFrequencyCardService {
	private static final Logger log = LoggerFactory.getLogger(ReceiveFrequencyCardServiceImpl.class);
	@Autowired
	private IWdFrequencyCardService wdFrequencyCardService;
	@Autowired
	private IReceivefrequencyService receivefrequencyService;
	@Autowired
	private IWdFrequencyTransService wdFrequencyTransService;
	@Autowired
	private WdMemberApi wdMemberApi;
	@Autowired
	private WxSessionApi wxSessionApi;
	@Autowired
	private IReceiveCardService receiveCardService;
	@Autowired
	private IMerAndWxcardService merAndWxcardService;
	/**
	 * 领取计次卡步骤  小程序<br>
	 * 1.接受参数<br>
	 * 2.查询计次卡表,获取到该次卡的名称<br>
	 * 	为空:提示该计次卡不存在<br>
	 * 3.查询领取次卡表<br>
	 * 		为空:组装参数,插入一条记录
	 * <br>
	 * 注意: openid的获取(如何与人进行绑定)
	 * 		code生成规则未定义
	 * 		计次卡使用规则未定义
	 * 
	 */
	@Override
	public Map<String, Object> ReceiveFrequencyCard(String cardId,String code,Map<String, Object> param) {
		log.info("领取计次卡入参(ReceiveFrequencyCard)入参:===="+param);
		Map<String, Object> returnMap = new HashMap<>();
		//openid 如何获取?????  
		String openidType = (String)param.get("openidType");				
		String openid = (String)param.get("openid");				
		int mid = (int)param.get("mid");
		Object mem_id = param.get("mem_id");
		log.info("领取计次卡mem_id is ： {}", mem_id);
		MerAndWxcard wxcard = merAndWxcardService.selectByMid(mid);
		if (mem_id == null || StringUtils.equals("0", (String)mem_id)) {
			if (StringUtils.equals("MP", openidType)) {
				Map<String, Object> whereCondition = new HashMap<String, Object>();
				whereCondition.put("openid", openid);
				whereCondition.put("mid", mid);
				whereCondition.put("card_id", wxcard.getWx_card_id());
				WdMember wdMember = wdMemberApi.getMemberByMidAndCondition(whereCondition);
				mem_id = wdMember.getId();
				log.info("计次卡领取 公众号获取 mem_id is ： {}", mem_id);
			} else {
				Map<String,Object> condition = new HashMap<>();
				condition.put("openid", openid);
				Map<String, Object> wxSession = wxSessionApi.findWxSessionByMiniOpenId(condition);
				WdReceiveCard wdReceiveCard = receiveCardService.getOnlyByUnionidAndAppid((String)wxSession.get("reserve1"), (String)wxSession.get("appid"));
				String openId = wdReceiveCard.getUser_openid();
				WdMember wdMember = wdMemberApi.findMemIdByOpenId(openId);
				mem_id = wdMember.getId();
				log.info("计次卡领取 小程序获取 mem_id is ： {}", mem_id);
			}
		}

		try {
			WdFrequencyCard wfc = wdFrequencyCardService.selectByCardId(cardId);
			if(wfc!=null) {
				//卡的初始次数
				int can_use_total = wfc.getInitialTotal();				
				WdReceiveFrequency wdReceiveFrequency =new WdReceiveFrequency();
				//不为空,先添加核销记录
				WdFrequencyTrans wdFreTrans =new WdFrequencyTrans();
				wdFreTrans.setCard_id(cardId);
				wdFreTrans.setOpenid(openid);
				// 1为未核销 2.已核销 核销记录是直接创建,因此状态都为2 
				wdFreTrans.setStatus("2");
				wdFreTrans.setTran_type(FrequencyCardEnum.Add.getType());
				wdFreTrans.setUse_total(can_use_total);
				wdFreTrans.setCreat_time(new Timestamp(System.currentTimeMillis()));
				wdFreTrans.setUse_time((new Timestamp(System.currentTimeMillis())));
				//添加次卡变动记录
				wdFreTrans.setSurplus_total(can_use_total);
				wdFreTrans.setCode(code);
				int insert = wdFrequencyTransService.insert(wdFreTrans);
				if(0==insert) {
					returnMap.put("subCode","100000");
					returnMap.put("subMsg","添加领取次卡变动记录失败");
					return returnMap;
				}
				//组装领取计次卡参数并添加领取次卡账户
				wdReceiveFrequency.setCard_id(cardId);
				wdReceiveFrequency.setCode(code);
				wdReceiveFrequency.setOpenid(openid);
				wdReceiveFrequency.setOpenid_type(openidType);
				wdReceiveFrequency.setCard_name(wfc.getCoupon_name());
				wdReceiveFrequency.setMem_id((Integer) mem_id);
				wdReceiveFrequency.setCan_use_total(can_use_total);
				wdReceiveFrequency.setSurplus_total(can_use_total);
				wdReceiveFrequency.setMid(mid);
				wdReceiveFrequency.setStatus(WriteOff.COU1.getSta());
				wdReceiveFrequency.setCreat_time(new Timestamp(System.currentTimeMillis()));
				insert = receivefrequencyService.insert(wdReceiveFrequency);
				if(1==insert) {
					returnMap.put("subCode","000000");
					returnMap.put("subMsg","领取次卡成功!");	
					returnMap.put("couponName",wfc.getCoupon_name());
				}else {
					returnMap.put("subCode","100000");
					returnMap.put("subMsg","添加领取次卡账户失败");	
					return returnMap;
				}
			}else {
				//该次卡种类不存在
				returnMap.put("subCode","100000");
				returnMap.put("subMsg","该次卡不存在");
			}
		} catch (Exception e) {
			log.error("====领取计次卡异常====");
			log.error(ExceptionUtils.getStackTrace(e));
		}
		log.info("领取计次卡出参(ReceiveFrequencyCard):===="+returnMap);
		return returnMap;
	}
	/**
	 * 计次卡核销步骤(小程序)
	 * 1.接收参数
	 * 	2 判断该次卡是否可以核销
	 *  2.1根据次卡规则表,
	 *  	判断该计次卡
	 *  是否存在(如果存在,同时获取该次卡使用规则) 
	 *  	同时查询该次卡领取的状态如果存在查询领取次卡表
	 * 	2.2  该次卡要核销是否符合次卡使用规则
	 * 	2.3  该次卡要核销的数量是否大于剩余使用次数
	 *  2.4 所有条件满足,
	 *  	核销表中添加一条记录 ,
	 *  	 领取表中更新剩余次数 。
	 * 	
	 */
	@Override
	public Map<String, Object> WriteOffFrequencyCard(String cardId,String code,Map<String, Object> param) {
		log.info("核销计次卡入参(WriteOffFrequencyCard):===="+param);
		Map<String, Object> returnMap = new HashMap<>();
		String openid = (String)param.get("openid");	
		int writeOffTotal = (int)param.get("writeOffTotal");	
		try {
			WdFrequencyCard wfc = wdFrequencyCardService.selectByCardId(cardId);
			WdReceiveFrequency wrf = receivefrequencyService.selectByCardIdCode(cardId,code,openid);
			String status = wrf.getStatus();
			if (wfc != null &&  WriteOff.COU1.getSta().equals(status) ) {
				//TODO 根据计次卡使用规则来判断是否可以核销
				boolean queryUseRule = queryUseRule(wfc.getRole());
				if(!queryUseRule) {
					returnMap.put("status",ErrorCode.DEFAULT_ERROR.getErrorCode());
					returnMap.put("msg","不符合核销规则");
					return returnMap;
				}
				Map<String, Object> insertransMap = insertrans(writeOffTotal, wfc, wrf);
				if(ErrorCode.DEFAULT_ERROR.getErrorCode()==(int)insertransMap.get("status")) {
					returnMap.put("status",ErrorCode.DEFAULT_ERROR.getErrorCode());
					returnMap.put("msg","可核销次数不足");
					return returnMap;
				}
				returnMap.put("status",ErrorCode.SUCCESS.getErrorCode());
				returnMap.put("msg","核销成功");
			} else {
				returnMap.put("status",ErrorCode.DEFAULT_ERROR.getErrorCode());
				returnMap.put("msg","不可核销");
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.info("核销计次卡出参(WriteOffFrequencyCard):===="+returnMap);
		return returnMap;
	}
	
	/**
	 * 计次卡核销原子服务
	 * @return
	 */
	public Map<String,Object> insertrans(int writeOffTotal,WdFrequencyCard wfc,WdReceiveFrequency wrf ){
		Map<String, Object> returnMap = new HashMap<>();
		//根据领取计次卡表中剩余次数判断是否可以核销
		try {
			int surplus_total = wrf.getSurplus_total();
			wrf.getStatus();
			WdFrequencyTrans wft = new WdFrequencyTrans();
			WdReceiveFrequency wrfUpdate = new WdReceiveFrequency();
			wrfUpdate.setId(wrf.getId());
			if(writeOffTotal <= surplus_total) {
				//条件满足,可以核销  1.核销表中添加一条记录 2. 领取表中更新剩余次数
				wft.setCard_id(wfc.getCard_id());
				wft.setCode(wrf.getCode());
				wft.setOpenid(wrf.getOpenid());
				wft.setSurplus_total(writeOffTotal);
				int  writeOffTotal2 = surplus_total - writeOffTotal;
				wrfUpdate.setSurplus_total(writeOffTotal2);
			}else {
				returnMap.put("status",ErrorCode.DEFAULT_ERROR.getErrorCode());
				returnMap.put("msg","可核销次数不足");
				return returnMap;
			}
			//如果相等,核销的是最后一次季卡使用次数,状态修改为已核销
			if(writeOffTotal == surplus_total) {
				wft.setStatus(WriteOff.COU2.getSta());
			}
			wdFrequencyTransService.insert(wft);
			receivefrequencyService.updateById(wrfUpdate);
			returnMap.put("status", ErrorCode.SUCCESS.getErrorCode());
			returnMap.put("msg", "核销成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return returnMap;
	}
	/**
	 * 计次卡使用规则判断的原子方法
	 * @return
	 */
	public boolean queryUseRule(String rule) {
		
		return true;
	}
	/**
	 * 存储计次卡规则
	 * @return
	 */
	public static String storageUseRule() {
		Map<String,Object> map = new HashMap<>();
		map.put("startDate", "2019-05-20");
		map.put("endDate", "2019-05-21");
		map.put("amStartTime", "17");
		map.put("amEndTime", "22");
		List<String> ruleList = new ArrayList<>();
		ruleList.add("1");
		ruleList.add("3");
		map.put("weekUseTime", ruleList);
		// 时间段 周一到周五
		// 时间段 下午场  上午场
		return map.toString();
	}
	public static void main(String[] args) {
		System.out.println("====="+storageUseRule().length());
	}
}
