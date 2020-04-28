package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUserInfoReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;

/*
 * 拉取会员信息接口
 * add by ws 0513
 */
public class PosGetUserInfoService extends BaseAPIService {

    public PosGetUserInfoService(String access_token) {
        super(WeiXinConstant.WX_GET_USERINFO + access_token);
    }

    public String request(GetUserInfoReq getUserInfoReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(getUserInfoReq);

        return responseString;
    }


}
