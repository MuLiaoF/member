package cn.wandingkeji.service.card.impl;

import cn.wandingkeji.card.entity.WdMemCard;
import cn.wandingkeji.card.entity.WdReceiveCardRule;
import cn.wandingkeji.comm.enums.AccessTokenType;
import cn.wandingkeji.comm.enums.ChannelTypeEnum;
import cn.wandingkeji.comm.enums.ProductTypeEnum;
import cn.wandingkeji.comm.utils.CodeRoleUtil;
import cn.wandingkeji.comm.utils.Sha1Util;
import cn.wandingkeji.coupon.entity.WdPlatformCoupon;
import cn.wandingkeji.service.card.IGrantCardCouponService;
import cn.wandingkeji.service.card.IWdMemCardService;
import cn.wandingkeji.service.card.IWdReceiveCardRuleService;
import cn.wandingkeji.service.coupon.IReceiveFrequencyCardService;
import cn.wandingkeji.service.coupon.IWdPlatformCouponService;
import cn.wandingkeji.token.api.MerTokenApi;
import cn.wandingkeji.token.entity.MerToken;
import com.alibaba.fastjson.JSON;
import com.member.weixin.api.mp.protocol.receive.CardExt;
import com.member.weixin.api.mp.protocol.receive.MiniAddCard;
import com.weupay.pay.api.protocol.AccessTokenRes;
import com.weupay.pay.api.service.GetTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 投放卡券的业务处理
 * @author Administrator
 * @date 2019年5月17日
 *
 */
@Slf4j
@Service("grantCardCouponService")
public class GrantCardCouponServiceImpl implements IGrantCardCouponService {
	
//	private static final Logger log = LoggerFactory.getLogger(ActiveGetInfoService.class);

	@Autowired
	private IWdPlatformCouponService wdPlatformCouponService;

	@Autowired
	private IReceiveFrequencyCardService receiveFrequencyCardService;
	@Autowired
	private IWdMemCardService wdMemCardService;
	@Autowired
	private IWdReceiveCardRuleService wdReceiveCardRuleService;
	
	@Autowired
	private MerTokenApi merTokenService;

	@Override
	public Map<String, Object> getJsSdkConfig(String url,String jsapiToken,String appid,Map<String, Object> param) {
		
		//jsapi_ticket和url
		//获取jsapi_ticket获取地址：https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi
		//初始化页面添加卡券的参数js-sdk config:appId/timestamp/nonceStr/signature/
		Map<String,Object> configMap = new HashMap<String,Object>();
		configMap.put("timestamp", Sha1Util.getTimeStamp());
		configMap.put("noncestr", Sha1Util.getNonceStr());
		configMap.put("jsapi_ticket", jsapiToken);// 调试从页面获取，后续要从后端缓存中获取
		configMap.put("url", url);
		String configSign = Sha1Util.getSHA1Sign(configMap);
		configMap.put("configSign", configSign);
		configMap.put("appId",appid);
		
		return configMap;
	}


	@Override
	public List<MiniAddCard> getAddCardListConfig(List<String> cardIdList, String apiToken, String outerStr) {
		List<MiniAddCard> addCardList = new ArrayList<MiniAddCard>();
		try {
			for(String cardId:cardIdList) {
				
				
				Map<String,Object> cardMap = new HashMap<>();
				String timeStamp = 	Sha1Util.getTimeStamp();
				String nonceStr = Sha1Util.getNonceStr();
				cardMap.put("timestamp", timeStamp);
				cardMap.put("nonceStr", nonceStr);
				cardMap.put("api_ticket",apiToken);// 调试从页面获取，后续要从后端缓存中获取
				cardMap.put("card_id",cardId);
				String cardSign = Sha1Util.getCardSHA1Sign(cardMap);
				
				MiniAddCard addCard = new MiniAddCard();
				addCard.setCardId(cardId);
				CardExt cardExt = new CardExt();
				cardExt.setTimestamp(timeStamp);
				cardExt.setNonce_str(nonceStr);
				cardExt.setOuter_str(outerStr);
				cardExt.setSignature(cardSign);
				String cardExtStr = JSON.toJSONString(cardExt);
				addCard.setCardExt(cardExtStr);
				addCardList.add(addCard);
			}
		}catch(Exception e) {
			log.error("getAddCardListConfig异常啦");
			log.error(ExceptionUtils.getStackTrace(e));
		}
		return addCardList;
	}   

	/*
	 * 初始化领卡参数
	 */
   @Override
   public Map<String,Object> initReceiveConfig(List<String> cardIdList,int mid,String outerStr,String tokenUrl){
	   Map<String,Object> returnMap = new HashMap<>();
	   try {
		   log.debug("初始化领卡参数");
		   //查询商户，取公众号token
		   //1.获取token
		   int tokenType = AccessTokenType.TYPE_42.getType();
		   log.info("mid="+mid+",tokenType="+tokenType);
		   MerToken merToken = merTokenService.getByMidAndType(mid, String.valueOf(tokenType));
		   if(merToken==null) {
			   log.info("merToken对象为空");
			   return null;
		   }
		   String getTokenUrl = String.format(tokenUrl, merToken.getToken_id());
		   GetTokenService getTokenService = new GetTokenService();
		   AccessTokenRes accessTokenRes = getTokenService.request(getTokenUrl);
		   String apiToken = accessTokenRes.getAccessToken();//"IpK_1T69hDhZkLQTlwsAX_Fe-_4xWt_bBqc3Ky0dA4edPqgSBh2gOrUbNTUEyTxYbXCzKfTizmh0ahGsGCtgJg";
		   
		   //2.组装领卡参数
		   List<MiniAddCard> addCardListConfig = getAddCardListConfig(cardIdList, apiToken, outerStr);
		   //3.返回结果
		   returnMap.put("addCardListConfig", addCardListConfig);
		   
	   }catch(Exception e) {
		   log.error("initReceiveConfig异常啦"); 
		   log.error(ExceptionUtils.getStackTrace(e));
	   }
	   return returnMap;
   }
   
   @Override
   public Map<String, Object> receiveCardAfterPayment(String wdCardId,String outerStr,String getTokenUrl, Map<String, Object> param) {
	   //卡劵类型（领卡还是领劵）
	   String cardType = (String) param.get("cardType");
	   Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			
			log.info("套餐购买传入cardType="+cardType+"传入wdCardId="+wdCardId);
			
			if(ProductTypeEnum.TICKET.getProCode().equals(cardType)) {
				log.info("购买的是券");
				returnMap = addCouponAfterPayment(wdCardId, outerStr, getTokenUrl,param);
			}else if(ProductTypeEnum.RC.getProCode().equals(cardType)) {
				//购买的是付费卡
				returnMap = addCardListAfterPayment(wdCardId, outerStr, getTokenUrl,param);
			}else if(ProductTypeEnum.FC.getProCode().equals(cardType)) {
				//购买的是免费卡
				returnMap = addWxCardList(wdCardId, outerStr, getTokenUrl);
			}else {
				returnMap.put("status", 300);
				returnMap.put("message", "暂不支持该商品的购买类型");
				return returnMap;
			}
			
		}catch(Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
		}
		
		return returnMap;
	}
   /*
    * 组装领取会员卡接口
    * add by ws
    */
   @Override
   public Map<String,Object> addWxCardList(String wxCardId,String outerStr,String getTokenUrl){
	   Map<String,Object> returnMap = new HashMap<>();
	   try {
		   //TODO 查询会员卡
		   WdMemCard memCard = wdMemCardService.selectByWxCardId(wxCardId);
		   if(memCard==null) {
			   returnMap.put("status", 300);
			   returnMap.put("message", "未查到会员卡信息");
			   return returnMap;
		   }
		   int mid = memCard.getMid();
		   List<String> cardList = new ArrayList<>();
		   cardList.add(wxCardId);
		   returnMap = initReceiveConfig(cardList, mid, outerStr,getTokenUrl);
		   returnMap.put("isWxCoupon", true);
		   returnMap.put("status",200);
		   returnMap.put("message", "组装领卡参数完成");
	   }catch(Exception e) {
		   returnMap.put("status", 300);
		   returnMap.put("message", "组装领卡参数失败");
		   log.error(ExceptionUtils.getStackTrace(e));
	   }
	   return returnMap;
   }
   /*
    * 购买劵
    */
public Map<String,Object> addCouponAfterPayment(String wdCardId,String outerStr,String getTokenUrl,Map<String,Object> param){
	   Map<String,Object> returnMap = new HashMap<>();
	   boolean isWxCoupon = true;
	   String couponName = "";
	   List<String> cardList = new ArrayList<>();
	   try {
		 //购买的是劵
			//通过平台劵表cardid,查询商品所属劵类型，根据类型处理不同的逻辑
		   WdPlatformCoupon platformCoupon = wdPlatformCouponService.selectCouponByCardId(wdCardId);
			log.info("platformCoupon==="+platformCoupon);
		   if(platformCoupon==null) {
				returnMap.put("status", 300);
				returnMap.put("message", "未查到平台劵");
				return returnMap;
			}
			int mid = platformCoupon.getMid();
			log.info("mid===="+mid);
			String couponType = platformCoupon.getChannel_type();
			if(ChannelTypeEnum.WX.getChannelType().equals(couponType)) {
				log.info("查询官方券");
				//查询官方劵表
				String wxCardId = platformCoupon.getThird_card_id();
				cardList.add(wxCardId);    
			}else if(ChannelTypeEnum.WD_FREQ.getChannelType().equals(couponType)) {
				//TODO 调用领取次卡service
				//TODO 生成code
				String code = CodeRoleUtil.generateInviteCode();
				Map<String, Object>  resultMap = receiveFrequencyCardService.ReceiveFrequencyCard(platformCoupon.getCard_id(), code, param);
				if("000000".equals(resultMap.get("subCode").toString())) {
					couponName =resultMap.get("couponName").toString();
				}
				isWxCoupon = false;
			}else if(ChannelTypeEnum.WD_GIFT.getChannelType().equals(couponType)) {
				log.info("套餐=====");
				//查询套餐详情,关联平台劵查询
				List<WdPlatformCoupon> giftCouponList = wdPlatformCouponService.selectGiftCouponByCardid(wdCardId);
				for(WdPlatformCoupon couponid:giftCouponList) {
					String giftCouponType = couponid.getChannel_type();
					if(ChannelTypeEnum.WX.getChannelType().equals(giftCouponType)) {
						//微信官方劵
						String wxCardId = couponid.getThird_card_id();
						cardList.add(wxCardId);
					}else if(ChannelTypeEnum.WD_FREQ.getChannelType().equals(giftCouponType)) {
						//TODO 调用领取次卡service
						String code = CodeRoleUtil.generateInviteCode();
						receiveFrequencyCardService.ReceiveFrequencyCard(couponid.getCard_id(), code, param);
					}
				} 
				
			}
			if(isWxCoupon) {
				
				returnMap = initReceiveConfig(cardList, mid, outerStr,getTokenUrl);
				log.info("initReceiveConfig 返回的参数"+returnMap);
			}
			returnMap.put("couponName", couponName);
			returnMap.put("isWxCoupon", isWxCoupon);
	   }catch(Exception e) {
		   returnMap.put("status", 300);
		   returnMap.put("message", "组装领卡参数失败");
		   log.error(ExceptionUtils.getStackTrace(e));
	   }
		return returnMap;
   }
   
   public Map<String,Object> addCardListAfterPayment(String wxCardId,String outerStr,String getTokenUrl,Map<String, Object> param){
	   Map<String,Object> returnMap = new HashMap<>();
	   try {
		   log.info("付费开通会员卡，wxCardId="+wxCardId);
		   int payRuleId = (int) param.get("payRuleId");
		   log.info("付费购卡开卡活动编号："+payRuleId);
		   List<MiniAddCard> addCardList = new ArrayList<>();
		   WdMemCard memCard = wdMemCardService.selectByWxCardId(wxCardId);
		   if(memCard==null) {
			   returnMap.put("status", 300);
			   returnMap.put("message", "未查到会员卡信息");
			   return returnMap;
		   }
		   int mid = memCard.getMid();
		   List<String> cardList = new ArrayList<>();
		   cardList.add(wxCardId);
		   Map<String, Object> initReceiveConfig = initReceiveConfig(cardList, mid, outerStr,getTokenUrl);
		   //TODO 查询开卡规则参数，组装其他领卡参数  
		   WdReceiveCardRule wdReceiveCardRule = wdReceiveCardRuleService.selectById(payRuleId);
		   if(wdReceiveCardRule==null) {
			   List<MiniAddCard> addCardListConfig =  (List<MiniAddCard>) initReceiveConfig.get("addCardListConfig");
			   returnMap.put("addCardListConfig", addCardListConfig);
			   returnMap.put("isWxCoupon", true);
			   returnMap.put("status",200);
			   returnMap.put("message", "组装领卡参数完成");
			   return returnMap;
		   }
		   log.info("wdReceiveCardRule============"+wdReceiveCardRule);
		   String type = wdReceiveCardRule.getType();
		   if("1".equals(type)) {
			   String plateCouponCardId = wdReceiveCardRule.getWd_coupon_card_id();
			   Map<String, Object> addCouponAfterPayment = addCouponAfterPayment(plateCouponCardId, outerStr, getTokenUrl,param);
			   boolean isWxCoupon = (boolean) addCouponAfterPayment.get("isWxCoupon");
			   if(isWxCoupon) {
				   log.info("付费购卡赠送优惠劵");
				   List<MiniAddCard> addCouponListConfig =  (List<MiniAddCard>) addCouponAfterPayment.get("addCardListConfig");
				   List<MiniAddCard> addCardListConfig =  (List<MiniAddCard>) initReceiveConfig.get("addCardListConfig");
				   addCardList.addAll(addCouponListConfig);
				   addCardList.addAll(addCardListConfig);
			   }
		   }
		   returnMap.put("addCardListConfig", addCardList);
		   returnMap.put("isWxCoupon", true);
		   returnMap.put("status",200);
		   returnMap.put("message", "组装领卡参数完成");
	   }catch(Exception e) {
		   returnMap.put("status", 300);
		   returnMap.put("message", "组装领卡参数失败");
		   log.error(ExceptionUtils.getStackTrace(e));
	   }
	   return returnMap;
   }
}
