package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.verification.offline.ConsumeCodeReq;
import cn.wandingkeji.common.base.wx.mp.protocol.verification.offline.ConsumeCodeRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by ws 0605
 * 核销code接口
 */
public class ConsumeCodeService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(ConsumeCodeService.class);

    public ConsumeCodeService(String access_token) {
        super(WeiXinConstant.WX_CONSUME_CODE + access_token);

    }

    /**
     * 核销code接口
     *
     * @return API返回的JSON数据
     */
    public ConsumeCodeRes request(ConsumeCodeReq consumeCodeReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(consumeCodeReq);
        log.info("==responseContent==" + responseString);
        ConsumeCodeRes consumeCodeRes = (ConsumeCodeRes) JSON.parseObject(responseString, ConsumeCodeRes.class);
        return consumeCodeRes;
    }

}
