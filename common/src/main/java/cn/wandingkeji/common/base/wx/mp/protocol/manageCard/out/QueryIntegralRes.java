package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

/*
 * 拉取会员信息（积分查询）接口
 * add by ws 
 * 20170506
 */
public class QueryIntegralRes {

	private String errcode;
	private String errmsg;
	private String openid;
	private String nickname;
	private String membership_number;
	private String bonus;
	private String sex;
	private String user_card_status;
	
	UserInfo user_info;

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMembership_number() {
		return membership_number;
	}

	public void setMembership_number(String membership_number) {
		this.membership_number = membership_number;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUser_card_status() {
		return user_card_status;
	}

	public void setUser_card_status(String user_card_status) {
		this.user_card_status = user_card_status;
	}

	public UserInfo getUser_info() {
		return user_info;
	}

	public void setUser_info(UserInfo user_info) {
		this.user_info = user_info;
	}

	
	
	
}
