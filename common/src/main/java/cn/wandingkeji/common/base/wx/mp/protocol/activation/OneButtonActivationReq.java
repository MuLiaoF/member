package cn.wandingkeji.common.base.wx.mp.protocol.activation;

import java.util.Map;

/*
 * 一键激活设置开卡字段请求数据
 * add by ws 0512
 */
public class OneButtonActivationReq {

	private String card_id;
	private Map<String,Object> service_statement;
	private Map<String,Object> bind_old_card;
	RequiredForm required_form;//必填项
	OptionalForm optional_form;//选填项
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public Map<String, Object> getService_statement() {
		return service_statement;
	}
	public void setService_statement(Map<String, Object> service_statement) {
		this.service_statement = service_statement;
	}
	public Map<String, Object> getBind_old_card() {
		return bind_old_card;
	}
	public void setBind_old_card(Map<String, Object> bind_old_card) {
		this.bind_old_card = bind_old_card;
	}
	public RequiredForm getRequired_form() {
		return required_form;
	}
	public void setRequired_form(RequiredForm required_form) {
		this.required_form = required_form;
	}
	public OptionalForm getOptional_form() {
		return optional_form;
	}
	public void setOptional_form(OptionalForm optional_form) {
		this.optional_form = optional_form;
	}
	
	
}
