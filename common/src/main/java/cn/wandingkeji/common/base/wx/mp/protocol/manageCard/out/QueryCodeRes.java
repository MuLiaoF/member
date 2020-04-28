package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

/*
 * 查询Code接口res
 * add by ws 0508
 */
public class QueryCodeRes {

	private String errcode;
	private String errmsg;
	private Card card;
	
	private String openid;
	private boolean can_consume;
	
	
	private String outer_str;
	private String user_card_status;
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
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public boolean isCan_consume() {
		return can_consume;
	}
	public void setCan_consume(boolean can_consume) {
		this.can_consume = can_consume;
	}
	public String getOuter_str() {
		return outer_str;
	}
	public void setOuter_str(String outer_str) {
		this.outer_str = outer_str;
	}
	public String getUser_card_status() {
		return user_card_status;
	}
	public void setUser_card_status(String user_card_status) {
		this.user_card_status = user_card_status;
	}
	
	
	
	
}
