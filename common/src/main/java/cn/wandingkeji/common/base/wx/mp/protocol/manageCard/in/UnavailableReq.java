package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;
/*
 * 设置卡失效接口
 * add by ws
 * 0527
 */
public class UnavailableReq {

	private String code;
	private String card_id;
	private String reason;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
