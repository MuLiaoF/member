package cn.wandingkeji.common.base.wx.mp.service.open;

import cn.wandingkeji.common.base.wx.mp.protocol.open.AuthorizerRefreshTokenReq;
import cn.wandingkeji.common.base.wx.mp.protocol.open.AuthorizerRefreshTokenRes;
import cn.wandingkeji.common.base.wx.mp.util.BaseAPIService;
import cn.wandingkeji.common.base.wx.mp.util.WeiXinConstant;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
 * add by fjr 0916
 * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
 */
public class AuthorizerRefreshTokenService extends BaseAPIService {

	private static final Logger log = LoggerFactory.getLogger(AuthorizerRefreshTokenService.class);
	public AuthorizerRefreshTokenService(String access_token) {
		super(WeiXinConstant.AUTHORIZER_REFRESH_TOKEN+access_token);
	}
	  /**
     * 
     *
     * @return API返回的JSON数据
     */
	  public AuthorizerRefreshTokenRes request(AuthorizerRefreshTokenReq authQueryReq) {

	        //--------------------------------------------------------------------
	        //发送HTTPS的Post请求到API地址
	        //--------------------------------------------------------------------
	        String responseString = sendPost(authQueryReq);
	        log.info("==responseContent=="+responseString);
	        AuthorizerRefreshTokenRes checkCodeRes = (AuthorizerRefreshTokenRes)  JSON.parseObject(responseString, AuthorizerRefreshTokenRes.class);
	        return checkCodeRes;
	    }

}
