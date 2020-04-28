package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;
/*
 * 创建兑换劵的Gift
 * add by ws 
 * 0603
 */
public class Gift {

	private CouponBaseInfo base_info;
	
	private AdvancedInfo advanced_info;
	private String gift;

	public CouponBaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(CouponBaseInfo base_info) {
		this.base_info = base_info;
	}

	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}

	public void setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}

	public String getGift() {
		return gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	
}
