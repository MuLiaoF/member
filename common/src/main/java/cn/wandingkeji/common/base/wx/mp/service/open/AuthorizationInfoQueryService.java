package cn.wandingkeji.common.base.wx.mp.service.open;

import cn.wandingkeji.common.base.wx.mp.protocol.open.AuthorizationQueryReq;
import cn.wandingkeji.common.base.wx.mp.protocol.open.AuthorizationQueryRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0516
 * 查询授权信息接口
 */
public class AuthorizationInfoQueryService extends BaseAPIService {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationInfoQueryService.class);

    public AuthorizationInfoQueryService(String access_token) {
        super(WeiXinConstant.WX_QUERY_AUTH + access_token);
    }

    /**
     * @return API返回的JSON数据
     */
    public AuthorizationQueryRes request(AuthorizationQueryReq authQueryReq) {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(authQueryReq);
        log.info("==responseContent==" + responseString);
        AuthorizationQueryRes checkCodeRes = (AuthorizationQueryRes) JSON.parseObject(responseString, AuthorizationQueryRes.class);
        return checkCodeRes;
    }

}
