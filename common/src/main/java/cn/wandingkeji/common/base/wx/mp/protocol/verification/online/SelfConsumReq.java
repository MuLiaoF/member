package cn.wandingkeji.common.base.wx.mp.protocol.verification.online;
/*
 * 自助核销
 */
public class SelfConsumReq {

	private String card_id;
	private boolean is_open;
	private boolean need_verify_code;
	private boolean need_remark_amount;
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public boolean isIs_open() {
		return is_open;
	}
	public void setIs_open(boolean is_open) {
		this.is_open = is_open;
	}

	public boolean isNeed_verify_code() {
		return need_verify_code;
	}
	public void setNeed_verify_code(boolean need_verify_code) {
		this.need_verify_code = need_verify_code;
	}
	public boolean isNeed_remark_amount() {
		return need_remark_amount;
	}
	public void setNeed_remark_amount(boolean need_remark_amount) {
		this.need_remark_amount = need_remark_amount;
	}
	
	
	
}
