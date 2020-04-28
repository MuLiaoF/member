package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.RoleInfo;

/*
 * 查询支付后投放卡券规则详情接口
 * add by ws 0508
 */
public class queryDeliveryByPayRes {

    private String errcode;
    private String errmsg;
    private RoleInfo role_info;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public RoleInfo getRole_info() {
        return role_info;
    }

    public void setRole_info(RoleInfo role_info) {
        this.role_info = role_info;
    }


}
