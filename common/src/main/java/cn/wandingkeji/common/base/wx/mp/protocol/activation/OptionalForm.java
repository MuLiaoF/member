package cn.wandingkeji.common.base.wx.mp.protocol.activation;

import java.util.List;

/*
 * 一键激活选填项字段
 * add by ws 0512
 */
public class OptionalForm {

	private boolean can_modify=false;
	List<String> common_field_id_list;
	List<String> custom_field_list;
	public boolean isCan_modify() {
		return can_modify;
	}
	public void setCan_modify(boolean can_modify) {
		this.can_modify = can_modify;
	}
	public List<String> getCommon_field_id_list() {
		return common_field_id_list;
	}
	public void setCommon_field_id_list(List<String> common_field_id_list) {
		this.common_field_id_list = common_field_id_list;
	}
	public List<String> getCustom_field_list() {
		return custom_field_list;
	}
	public void setCustom_field_list(List<String> custom_field_list) {
		this.custom_field_list = custom_field_list;
	}
	
	
}
