package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

public class UpdateIntegralRes {

	private String errcode;
	private String errmsg;
	private boolean send_check;
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
	public boolean isSend_check() {
		return send_check;
	}
	public void setSend_check(boolean send_check) {
		this.send_check = send_check;
	}
	
	
}
