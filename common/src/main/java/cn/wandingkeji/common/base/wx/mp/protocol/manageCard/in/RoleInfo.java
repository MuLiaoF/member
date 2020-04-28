package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
 * 设置支付后投放卡券接口的接口参数对象
 * add by ws 20170506
 */
public class RoleInfo {

	private  String type= "RULE_TYPE_PAY_MEMBER_CARD";
	Map<String,Object> member_rule;
	PayBaseInfo base_info;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, Object> getMember_rule() {
		return member_rule;
	}
	public void setMember_rule(Map<String, Object> member_rule) {
		this.member_rule = member_rule;
	}
	public RoleInfo setMember_rule(String card_id,String least_cost,BigDecimal max_cost,String jump_url) {
		Map<String,Object> map=new HashMap<>();
		map.put("card_id", card_id);
		map.put("least_cost", least_cost);
		map.put("max_cost", max_cost);
		map.put("jump_url", jump_url);
		this.member_rule = map;
		return this;
	}

	
	public PayBaseInfo getBase_info() {
		return base_info;
	}
	public void setBase_info(PayBaseInfo base_info) {
		this.base_info = base_info;
	}


	//add by ws 0508
	private SinglePay single_pay;
	public SinglePay getSingle_pay() {
		return single_pay;
	}
	public void setSingle_pay(SinglePay single_pay) {
		this.single_pay = single_pay;
	}
	
	
	
	
}
