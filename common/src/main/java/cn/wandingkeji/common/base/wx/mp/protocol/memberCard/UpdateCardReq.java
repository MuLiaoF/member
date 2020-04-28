package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

public class UpdateCardReq {

	private String card_id;
	private UpdateMemberCard member_card;//会员卡
	private UpdateCouponInfo gift;//兑换劵
	private UpdateCouponInfo groupon;//团购券
	private UpdateCouponInfo discount;//折扣券
	private UpdateCouponInfo cash;//代金券
	private UpdateCouponInfo general_coupon;//通用卷
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public UpdateMemberCard getMember_card() {
		return member_card;
	}
	public void setMember_card(UpdateMemberCard member_card) {
		this.member_card = member_card;
	}
	public UpdateCouponInfo getGift() {
		return gift;
	}
	public void setGift(UpdateCouponInfo gift) {
		this.gift = gift;
	}
	public UpdateCouponInfo getGroupon() {
		return groupon;
	}
	public void setGroupon(UpdateCouponInfo groupon) {
		this.groupon = groupon;
	}
	public UpdateCouponInfo getDiscount() {
		return discount;
	}
	public void setDiscount(UpdateCouponInfo discount) {
		this.discount = discount;
	}
	public UpdateCouponInfo getCash() {
		return cash;
	}
	public void setCash(UpdateCouponInfo cash) {
		this.cash = cash;
	}
	public UpdateCouponInfo getGeneral_coupon() {
		return general_coupon;
	}
	public void setGeneral_coupon(UpdateCouponInfo general_coupon) {
		this.general_coupon = general_coupon;
	}
	
	
	

	
}
