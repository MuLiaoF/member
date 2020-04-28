package cn.wandingkeji.common.base.wx.mp.service;

import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUrlReq;
import cn.wandingkeji.common.base.wx.mp.protocol.activation.GetUrlRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by ws 20171214
 * 获取开卡插件参数接口
 */
public class ActiveGetUrlService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(ActiveGetUrlService.class);

    public ActiveGetUrlService(String access_token) {
        super(WeiXinConstant.ACTIVATE_GETURL + access_token);
    }

    /**
     * @return API返回的JSON数据
     */
    public GetUrlRes request(GetUrlReq getUrlReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(getUrlReq);
        log.info("==responseContent==" + responseString);
        GetUrlRes getUrlRes = (GetUrlRes) JSON.parseObject(responseString, GetUrlRes.class);
        return getUrlRes;
    }

}
