package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;
/*
 * 查看卡券详情
 * 开发者可以调用该接口查询某个card_id的创建信息、审核状态以及库存数量。
 * add by ws 0515
 */
public class QueryCardStatusRes {
	private String errcode;
	private String errmsg;
	private Card card;
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
	
	

}
