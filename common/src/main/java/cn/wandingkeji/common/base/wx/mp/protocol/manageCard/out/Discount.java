package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.AdvancedInfo;

import java.util.Map;

/*
 * add by ws 0515
 */
public class Discount {

    private Map<String, QueryBaseInfo> base_info;
    private Map<String, AdvancedInfo> advanced_info;
    private int discount;

    public Map<String, QueryBaseInfo> getBase_info() {
        return base_info;
    }

    public void setBase_info(Map<String, QueryBaseInfo> base_info) {
        this.base_info = base_info;
    }

    public Map<String, AdvancedInfo> getAdvanced_info() {
        return advanced_info;
    }

    public void setAdvanced_info(Map<String, AdvancedInfo> advanced_info) {
        this.advanced_info = advanced_info;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


}
