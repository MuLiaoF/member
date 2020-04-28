package cn.wandingkeji.common.base.wx.mp.protocol.member;

public class UpdateUserRes {

	private String errcode;
	private String errmsg;
	private int result_bonus;
	private int result_balance;
	private String openid;
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
	public int getResult_bonus() {
		return result_bonus;
	}
	public void setResult_bonus(int result_bonus) {
		this.result_bonus = result_bonus;
	}
	public int getResult_balance() {
		return result_balance;
	}
	public void setResult_balance(int result_balance) {
		this.result_balance = result_balance;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "UpdateUserRes{" +
				"errcode='" + errcode + '\'' +
				", errmsg='" + errmsg + '\'' +
				", result_bonus=" + result_bonus +
				", result_balance=" + result_balance +
				", openid='" + openid + '\'' +
				'}';
	}
}
