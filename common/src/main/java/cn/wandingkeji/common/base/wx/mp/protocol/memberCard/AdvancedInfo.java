package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import java.util.List;
import java.util.Map;

public class AdvancedInfo {

	public AdvancedInfo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * "accept_category": "鞋类",
        "reject_category": "阿迪达斯",
        "can_use_with_other_discount": true
	 */
	private Map<String,Object> use_condition;
//	private Map<String,Object> abstract;
	
	/**
	 *  "BIZ_SERVICE_FREE_WIFI",
        "BIZ_SERVICE_WITH_PET",
        "BIZ_SERVICE_FREE_PARK",
        "BIZ_SERVICE_DELIVER"
	 */
	private List<String> business_service;
	/**
	 "time_limit": [
	                {
	                    "type": "MONDAY",
	                    "begin_hour":0,
	                    "end_hour":10,
	                    "begin_minute":10,
	                    "end_minute":59
	                },
	                {
	                    "type": "HOLIDAY"
	                }
	            ],
	*/
	List<Map<String,Object>> time_limit;
	
	/**
	 *   "text_image_list": [
        {
            "image_url": "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
            "text": "此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾"
        },
        {
            "image_url": "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
            "text": "此菜品迎合大众口味，老少皆宜，营养均衡"
        }
    ]
	 */
	List<Map<String,Object>>text_image_list;
	public Map<String, Object> getUse_condition() {
		return use_condition;
	}
	public void setUse_condition(Map<String, Object> use_condition) {
		this.use_condition = use_condition;
	}
	public List<String> getBusiness_service() {
		return business_service;
	}
	public void setBusiness_service(List<String> business_service) {
		this.business_service = business_service;
	}
	public List<Map<String, Object>> getTime_limit() {
		return time_limit;
	}
	public void setTime_limit(List<Map<String, Object>> time_limit) {
		this.time_limit = time_limit;
	}
	
	public List<Map<String, Object>> getText_image_list() {
		return text_image_list;
	}
	public void setText_image_list(List<Map<String, Object>> text_image_list) {
		this.text_image_list = text_image_list;
	}
	
	/*//ADD BY WS 0515
	private List<String> consume_share_card_list;
	private boolean share_friends;
	public List<String> getConsume_share_card_list() {
		return consume_share_card_list;
	}
	public void setConsume_share_card_list(List<String> consume_share_card_list) {
		this.consume_share_card_list = consume_share_card_list;
	}
	public boolean isShare_friends() {
		return share_friends;
	}
	public void setShare_friends(boolean share_friends) {
		this.share_friends = share_friends;
	}
	*/
	

}
