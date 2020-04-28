package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.QueryCardStatusReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;

/*
 * add by ws
 * 查询卡卷情况
 */
public class PosQueryCardStatusService extends BaseAPIService {

    public PosQueryCardStatusService(String access_token) {
        super(WeiXinConstant.WX_GET_CARD_STATUS + access_token);
    }

    public String request(QueryCardStatusReq queryCardStatusReq) {

        //--------------------------------------------------------------------

        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(queryCardStatusReq);

        return responseString;
    }

}
