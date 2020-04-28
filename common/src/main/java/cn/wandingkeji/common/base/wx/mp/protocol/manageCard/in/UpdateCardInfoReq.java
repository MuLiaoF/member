package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in;

import cn.wandingkeji.common.base.wx.mp.protocol.memberCard.MemberCard;

/*
 * 更改会员卡信息接口
 * add by ws
 * 20170506
 */
public class UpdateCardInfoReq {

    private String card_id;
    MemberCard member_card;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public MemberCard getMember_card() {
        return member_card;
    }

    public void setMember_card(MemberCard member_card) {
        this.member_card = member_card;
    }


}
