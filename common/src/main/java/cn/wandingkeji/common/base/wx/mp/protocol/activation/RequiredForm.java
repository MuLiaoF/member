package cn.wandingkeji.common.base.wx.mp.protocol.activation;

import java.util.List;
import java.util.Map;

/*
 * add by ws 0512
 * 一键激活必填项字段
 */
public class RequiredForm {

	private boolean can_modify=false;
	List<Map<String,Object>> rich_field_list;
	List<String> common_field_id_list;
	public boolean isCan_modify() {
		return can_modify;
	}
	public void setCan_modify(boolean can_modify) {
		this.can_modify = can_modify;
	}
	public List<Map<String, Object>> getRich_field_list() {
		return rich_field_list;
	}
	public void setRich_field_list(List<Map<String, Object>> rich_field_list) {
		this.rich_field_list = rich_field_list;
	}
	public List<String> getCommon_field_id_list() {
		return common_field_id_list;
	}
	public void setCommon_field_id_list(List<String> common_field_id_list) {
		this.common_field_id_list = common_field_id_list;
	}
	
	
	
	
	
}
