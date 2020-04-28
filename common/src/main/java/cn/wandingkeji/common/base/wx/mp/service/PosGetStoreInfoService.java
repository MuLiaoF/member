package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.store.in.GetStoreInfoReq;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;

/*
 * 查询门店列表
 * add by ws 0513
 */
public class PosGetStoreInfoService extends BaseAPIService {

    public PosGetStoreInfoService(String access_token) {
        super(WeiXinConstant.WX_GET_STOREINFO + access_token);
    }

    public String request(GetStoreInfoReq getStoreInfoReq) {

        String responseString = sendPost(getStoreInfoReq);
        return responseString;

    }
}
