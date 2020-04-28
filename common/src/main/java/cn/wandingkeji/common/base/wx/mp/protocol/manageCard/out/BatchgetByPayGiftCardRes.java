package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

import java.util.List;

/*
 * 批量查询支付后投放卡券规则接口
 * add by ws 0508
 */
public class BatchgetByPayGiftCardRes {

	private String errcode;
	private String errmsg;
	private int total_count;
	/*
	 * "rule_list": [
	        {
	            "type": "RULE_TYPE_PAY_MEMBER_CARD",
	            "base_info": {
	                "mchid_list": [
	                    "123",
	                    "456"
	                    ],
	                "begin_time": 1480317217,
	                "end_time": 1580317217,
	                "status": "RULE_STATUS_OK",
	                "create_time": 1480317217,
	                "update_time": 1480317217
	            },
	            "member_rule": {
	                "card_id": "abcdefg",
	                "least_cost": 2,
	                "max_cost": 20000,
	                "jump_url": "www.qq.com"
	            }
	        }
	    ]
	 */
	private List<String> rule_list;//
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public List<String> getRule_list() {
		return rule_list;
	}
	public void setRule_list(List<String> rule_list) {
		this.rule_list = rule_list;
	}
	
	
}
