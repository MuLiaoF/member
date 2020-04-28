package cn.wandingkeji.common.base.wx.mp.protocol.coupon.discount;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.AdvancedInfo;
import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.CouponBaseInfo;

public class CountDiscount {

    private CouponBaseInfo base_info;
    private AdvancedInfo advanced_info;
    private int discount;

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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


}
