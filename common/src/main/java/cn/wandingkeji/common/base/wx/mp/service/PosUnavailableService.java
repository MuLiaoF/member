package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.UnavailableReq;
import cn.wandingkeji.common.base.wx.mp.protocol.manageCard.out.ResBaseData;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 设置会员卡失效service(某一用户的会员卡)
 */
public class PosUnavailableService extends BaseAPIService {
    private static final Logger log = LoggerFactory.getLogger(PosUnavailableService.class);

    public PosUnavailableService(String access_token) {

        super(WeiXinConstant.WX_UNAVAILABLE + access_token);
    }

    public ResBaseData request(UnavailableReq unavailableReq) {
        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(unavailableReq);
        log.info("==responseContent==" + responseString);
        ResBaseData baseDateRes = (ResBaseData) JSON.parseObject(responseString, ResBaseData.class);
        return baseDateRes;
    }
}
