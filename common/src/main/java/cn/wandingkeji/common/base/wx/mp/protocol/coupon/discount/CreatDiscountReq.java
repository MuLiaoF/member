package cn.wandingkeji.common.base.wx.mp.protocol.coupon.discount;

/*
 * 创建卡卷javabean 
 * add by ws 
 * 20170505
 */
public class CreatDiscountReq {

	private String card_type;
	private CountDiscount discount;
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public CountDiscount getDiscount() {
		return discount;
	}
	public void setDiscount(CountDiscount discount) {
		this.discount = discount;
	}
	
	
}
