package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

import java.util.List;
import java.util.Map;

/*
 * 
 */
public class UserInfo {

	/*
	 * 
		            {
		                "name": "USER_FORM_INFO_FLAG_MOBILE",
		                "value": "15521328888"
		            },
		            {
		                "name": "USER_FORM_INFO_FLAG_NAME",
		                "value": "微信"
		            }
		        
	 */
	List<Map<String,Object>> common_field_list;
	
	List<String> custom_field_list;

	public List<Map<String, Object>> getCommon_field_list() {
		return common_field_list;
	}

	public void setCommon_field_list(List<Map<String, Object>> common_field_list) {
		this.common_field_list = common_field_list;
	}

	public List<String> getCustom_field_list() {
		return custom_field_list;
	}

	public void setCustom_field_list(List<String> custom_field_list) {
		this.custom_field_list = custom_field_list;
	}
	
	
}
