package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.store.in.GetStoreListReq;
import cn.wandingkeji.common.base.wx.mp.protocol.store.out.GetStoreInfoRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 查询微信小程序门店列表
 * add by ws 0513
 */
public class PosGetStoreListService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(PosGetStoreListService.class);

    public PosGetStoreListService(String access_token) {
        super(WeiXinConstant.WX_GET_STORE_LIST + access_token);
    }

    public GetStoreInfoRes request(GetStoreListReq getStoreListReq) {

        String responseString = sendPost(getStoreListReq);
        log.info("==responseContent==" + responseString);
        GetStoreInfoRes storeInfoRes = (GetStoreInfoRes) JSON.parseObject(responseString, GetStoreInfoRes.class);
        return storeInfoRes;

    }
}
