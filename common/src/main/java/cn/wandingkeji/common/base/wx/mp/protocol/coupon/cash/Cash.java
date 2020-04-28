package cn.wandingkeji.common.base.wx.mp.protocol.coupon.cash;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.AdvancedInfo;
import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.CouponBaseInfo;

public class Cash {

    private CouponBaseInfo base_info;
    AdvancedInfo advanced_info;
    private int least_cost;//代金券专用，表示起用金额（单位为分）
    private int reduce_cost;//代金券专用，表示减免金额。（单位为分）

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

    public int getLeast_cost() {
        return least_cost;
    }

    public void setLeast_cost(int least_cost) {
        this.least_cost = least_cost;
    }

    public int getReduce_cost() {
        return reduce_cost;
    }

    public void setReduce_cost(int reduce_cost) {
        this.reduce_cost = reduce_cost;
    }


}
