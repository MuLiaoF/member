package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

import java.util.List;
import java.util.Map;

/*
 * 设置支付后投放卡券接口返回数据
 * add by ws0508
 */

public class DeliveryByPayRes {

	private String errcode;
	private String errmsg;
	private String rule_id;
	/*
	 *  {
            "mchid": "111",
            "errcode": 23112,
            "errmsg": "err",
            "occupy_rule_id": 12332123,
            "occupy_appid": "appid"
        }
	 */
	private List<Map<String,Object>> fail_mchid_list;
	private List<String> succ_mchid_list;
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
	public String getRule_id() {
		return rule_id;
	}
	public void setRule_id(String rule_id) {
		this.rule_id = rule_id;
	}
	public List<Map<String, Object>> getFail_mchid_list() {
		return fail_mchid_list;
	}
	public void setFail_mchid_list(List<Map<String, Object>> fail_mchid_list) {
		this.fail_mchid_list = fail_mchid_list;
	}
	public List<String> getSucc_mchid_list() {
		return succ_mchid_list;
	}
	public void setSucc_mchid_list(List<String> succ_mchid_list) {
		this.succ_mchid_list = succ_mchid_list;
	}
	
	
}
