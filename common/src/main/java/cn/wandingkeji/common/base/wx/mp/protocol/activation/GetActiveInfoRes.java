package cn.wandingkeji.common.base.wx.mp.protocol.activation;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;

/*
 * 获取用户开卡时提交的信息（小程序跳转型开卡组件）
 */
public class GetActiveInfoRes extends ResBaseData {

    private UserInfo info;

    public UserInfo getInfo() {
        return info;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

}
