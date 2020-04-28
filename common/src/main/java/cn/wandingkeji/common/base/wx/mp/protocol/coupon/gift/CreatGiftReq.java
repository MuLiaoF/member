package cn.wandingkeji.common.base.wx.mp.protocol.coupon.gift;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.Gift;

/*
 * 创建卡卷javabean
 * add by ws
 * 20170505
 */
public class CreatGiftReq {

    private String card_type;
    private Gift gift;

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }


}
