package cn.wandingkeji.common.base.wx.mp.protocol.verification.offline;

public class ConsumeCodeReq {

	private String code;
	private String card_id;
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
	
}
