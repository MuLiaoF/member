package cn.wandingkeji.token.service.impl;

import cn.wandingkeji.comm.enums.AccessTokenType;
import cn.wandingkeji.comm.service.GetTokenService;
import cn.wandingkeji.token.entity.AccessToken;
import cn.wandingkeji.token.entity.AccessTokenRes;
import cn.wandingkeji.token.entity.MerToken;
import cn.wandingkeji.token.mapper.AccessTokenMapper;
import cn.wandingkeji.token.service.IGetTokenUtilService;
import cn.wandingkeji.token.service.IMerTokenService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取token 的公共方法
 * @author jing_huan
 *
 */
@Slf4j
@Service("getTokenUtilService")
public class GetTokenUtilServiceImpl implements IGetTokenUtilService {
	@Autowired
	private IMerTokenService merTokenService;
	@Autowired
	private AccessTokenMapper accessTokenMapper;
	/**
	 * 获取token对象
	 * @param mid
	 * @param tokenUrl
	 * @param tokenType token类型
	 * @return
	 */
	@Override
	public AccessTokenRes getToken(int mid, String tokenUrl, int tokenType) {
		log.info("===进入获取token公共方法=入参=:" + mid+" tokenUrl="+tokenUrl);
		MerToken merToken = merTokenService.selectByMidAndType(mid, String.valueOf(tokenType));
		String getTokenUrl = String.format(tokenUrl, merToken.getToken_id());
		GetTokenService getTokenService = new GetTokenService();
		System.out.println("getTokenUrl*************"+getTokenUrl);
		
		AccessTokenRes accessTokenRes = getTokenService.request(getTokenUrl);
		System.out.println("--------->>>>>>>>>"+JSONObject.toJSONString(accessTokenRes));
		
		log.info("accessTokenRes返回:" + accessTokenRes.toString());
		String apiToken = accessTokenRes.getAccessToken();// "IpK_1T69hDhZkLQTlwsAX_Fe-_4xWt_bBqc3Ky0dA4edPqgSBh2gOrUbNTUEyTxYbXCzKfTizmh0ahGsGCtgJg";
		log.info("======apiToken是:" + apiToken);
		return accessTokenRes;
	}
	@Override
	public AccessToken getTokenByTypeAndAppid(int type, String appid) {
		log.info("===进入获取token公共方法=入参=:" + type+" appid="+appid);
		AccessToken accessToken = accessTokenMapper.selectByAppidAndType(type, appid);
		return accessToken;
	}
	@Override
	public AccessToken getMiniSmallToken(String appid,String tokenUrl) {
		log.info("===进入获取token公共方法=入参=:" + appid);
		String getTokenUrl = String.format(tokenUrl,appid, AccessTokenType.TYPE_7.getType());
		log.info("===getTokenUrl=:" + getTokenUrl);
		GetTokenService getTokenService = new GetTokenService();
		AccessTokenRes accessTokenRes = getTokenService.request(getTokenUrl);
		AccessToken  accessToken = JSONObject.parseObject(accessTokenRes.getAccessToken(),AccessToken.class);
		return accessToken;
	}

}
