package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.verification.online.SelfConsumReq;
import cn.wandingkeji.common.base.wx.mp.protocol.verification.online.SelfConsumRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by ws 0606
 * 设置自助核销接口
 */
public class SelfConsumService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(SelfConsumService.class);

    public SelfConsumService(String access_token) {
        super(WeiXinConstant.WX_SELF_CONSUM + access_token);

    }

    /**
     * 设置自助核销接口
     *
     * @return API返回的JSON数据
     */
    public SelfConsumRes request(SelfConsumReq selfConsumReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(selfConsumReq);
        log.info("==responseContent==" + responseString);
        SelfConsumRes selfConsumRes = (SelfConsumRes) JSON.parseObject(responseString, SelfConsumRes.class);
        return selfConsumRes;
    }

}
