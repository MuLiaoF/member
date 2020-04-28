package cn.wandingkeji.common.base.wx.mp.protocol.activation;

import java.util.List;
import java.util.Map;

public class UserInfo {

	private List<Map<String,Object>> common_field_list;
	private List<Map<String,Object>> custom_field_list;
	public List<Map<String, Object>> getCommon_field_list() {
		return common_field_list;
	}
	public void setCommon_field_list(List<Map<String, Object>> common_field_list) {
		this.common_field_list = common_field_list;
	}
	public List<Map<String, Object>> getCustom_field_list() {
		return custom_field_list;
	}
	public void setCustom_field_list(List<Map<String, Object>> custom_field_list) {
		this.custom_field_list = custom_field_list;
	}
	
	
	
}
