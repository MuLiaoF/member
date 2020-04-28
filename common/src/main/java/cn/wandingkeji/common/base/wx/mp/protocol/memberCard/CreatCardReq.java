package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 创建会员卡接口
 */

public class CreatCardReq {

	/**
	 * 默认是会员卡
	 */
	private String  card_type  = "MEMBER_CARD";
	private MemberCard member_card;
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public MemberCard getMember_card() {
		return member_card;
	}
	public void setMember_card(MemberCard member_card) {
		this.member_card = member_card;
	}
	

	public static void main(String[] args) {
	
		AdvancedInfo ad=new AdvancedInfo();
		
		List<String> business_service=new ArrayList<>();
		business_service.add("BIZ_SERVICE_FREE_WIFI");
		business_service.add( "BIZ_SERVICE_WITH_PET");
		business_service.add( "BIZ_SERVICE_FREE_PARK");
		business_service.add( "BIZ_SERVICE_DELIVER");
		ad.setBusiness_service(business_service);
		List<Map<String,Object>> text_image_list=new ArrayList<Map<String,Object>>();
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("image_url", "http://mmbiz.qpic.cn/mmbiz");
		map1.put("text","此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾");
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("image_url", "http://mmbiz.qpic.cn/mmbiz");
		map2.put("text","此菜品迎合大众口味，老少皆宜，营养均衡");
		text_image_list.add(map1);
		text_image_list.add(map2);
		ad.setTime_limit(text_image_list);
		Map<String,Object> use_condition=new HashMap<String,Object>();
		use_condition.put("accept_category", "鞋类");
		use_condition.put("reject_category", "阿迪达斯");
		use_condition.put("can_use_with_other_discount", true);
		ad.setUse_condition(use_condition);
		
		CardBaseInfo baseInfo=new CardBaseInfo();
		baseInfo.setBrand_name("1");
		baseInfo.setCan_give_friend(true);
		baseInfo.setCode_type("2");
		baseInfo.setColor("3");
		baseInfo.setCustom_url("4");
		baseInfo.setCustom_url_name("5");
		baseInfo.setCustom_url_sub_title("6");
		baseInfo.setDate_info();
		baseInfo.setDescription("7");
		baseInfo.setGet_limit(0);
		baseInfo.setLogo_url("8");
		List<String> location_id_list=new ArrayList<>();
		location_id_list.add("121");
		location_id_list.add("232");
		baseInfo.setLocation_id_list(location_id_list);
		baseInfo.setNeed_push_on_view(true);
		baseInfo.setSku(0);
		baseInfo.setTitle("titilrwe");
		
		MemberCard memberCard=new MemberCard();
		memberCard.setActivate_url("https://mmbiz.qlogo.cn/mmbiz");
		memberCard.setAdvanced_info(ad);
		memberCard.setBase_info(baseInfo);
		memberCard.setSupply_balance(true);
		memberCard.setSupply_bonus(false);
		memberCard.setPrerogative("121454");
		memberCard.setBackground_pic_url("www.wandoingh.com");
		memberCard.setDiscount(10);
		
		CreatCardReq creatCardReq=new CreatCardReq();
		creatCardReq.setCard_type("member_card");
		creatCardReq.setMember_card(memberCard);
		Object requestJson = JSON.toJSON(creatCardReq);		
		System.out.println(requestJson);
		
	}
}
