package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;
/*
 * 获取用户已领取卡券接口
 * add by ws 170508
 */
public class GetCardListReq {

	private String openid;
	private String card_id;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	
	
	
}
