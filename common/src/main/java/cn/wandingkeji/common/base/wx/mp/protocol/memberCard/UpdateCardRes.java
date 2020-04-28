package cn.wandingkeji.common.base.wx.mp.protocol.memberCard;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;

public class UpdateCardRes extends ResBaseData {

    private boolean send_check;//此次更新是否需要提审true(),false()

    public boolean isSend_check() {
        return send_check;
    }

    public void setSend_check(boolean send_check) {
        this.send_check = send_check;
    }


}
