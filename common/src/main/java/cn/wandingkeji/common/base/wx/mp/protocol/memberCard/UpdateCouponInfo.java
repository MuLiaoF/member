package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

/*
 * 更新微信劵信息
 */
public class UpdateCouponInfo {


	
	AdvancedInfo advanced_info;

	private UpdateCouponBaseInfo base_info;

	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}
	public UpdateCouponInfo setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
		return this;
	}
	public UpdateCouponBaseInfo getBase_info() {
		return base_info;
	}
	public void setBase_info(UpdateCouponBaseInfo base_info) {
		this.base_info = base_info;
	}

	



}
