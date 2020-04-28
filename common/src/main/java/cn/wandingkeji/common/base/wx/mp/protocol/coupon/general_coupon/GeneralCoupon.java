package cn.wandingkeji.common.base.wx.mp.protocol.coupon.general_coupon;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.AdvancedInfo;
import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.CouponBaseInfo;

public class GeneralCoupon {

    private CouponBaseInfo base_info;
    private AdvancedInfo advanced_info;
    private String default_detail;

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

    public String getDefault_detail() {
        return default_detail;
    }

    public void setDefault_detail(String default_detail) {
        this.default_detail = default_detail;
    }


}
