package cn.wandingkeji.common.base.wx.mp.protocol.reveive;

/*
 * 小程序内开卡
 * add by ws
 * 20190517
 */
public class MiniAddCard {

    private String cardId;

    private String cardExt;

    private String remark;

    private String cardType;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardExt() {
        return cardExt;
    }

    public void setCardExt(String cardExt) {
        this.cardExt = cardExt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "MiniAddCard{" +
                "cardId='" + cardId + '\'' +
                ", cardExt='" + cardExt + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
