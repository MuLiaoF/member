package cn.wandingkeji.token.service;

import cn.wandingkeji.token.entity.AccessToken;
import cn.wandingkeji.token.entity.AccessTokenRes;

/**
 * 获取token 的公共方法
 * @author jing_huan
 *
 */
public interface IGetTokenUtilService {
	/**
	 * 获取token对象
	 * @param mid
	 * @param tokenUrl
	 * @param tokenType token类型
	 * @return
	 */
	public AccessTokenRes getToken(int mid, String tokenUrl, int tokenType);
	public AccessToken getTokenByTypeAndAppid(int type, String appid);
	
	public AccessToken getMiniSmallToken(String appid,String tokenUrl);

}
