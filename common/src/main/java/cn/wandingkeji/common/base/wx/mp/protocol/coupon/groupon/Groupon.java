package cn.wandingkeji.common.base.wx.mp.protocol.coupon.groupon;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.AdvancedInfo;
import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.CouponBaseInfo;

public class Groupon {


    private String deal_detail;
    private CouponBaseInfo base_info;
    AdvancedInfo advanced_info;

    public String getDeal_detail() {
        return deal_detail;
    }

    public void setDeal_detail(String deal_detail) {
        this.deal_detail = deal_detail;
    }

    public AdvancedInfo getAdvanced_info() {
        return advanced_info;
    }

    public void setAdvanced_info(AdvancedInfo advanced_info) {
        this.advanced_info = advanced_info;
    }

    public CouponBaseInfo getBase_info() {
        return base_info;
    }

    public void setBase_info(CouponBaseInfo base_info) {
        this.base_info = base_info;
    }


}
