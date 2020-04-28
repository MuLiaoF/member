package cn.wandingkeji.session.service;

import cn.wandingkeji.session.entity.WxSession;

import java.util.Map;

/**
 * 
 * @author liaoxiang
 *
 */
public interface IWxSessionService {

	/**
	 * 保存
	 * 
	 * @param record
	 * @return
	 */
	int saveSelective(WxSession record);

	/**
	 * 根据appid和openid获取session对象
	 * 
	 * @param record
	 * @return
	 */
	WxSession findByAppIdAndOpenId(Map<String, Object> record);

	/**
	 * 根据sessionid获取session对象
	 * 
	 * @param record
	 * @return
	 */
	WxSession findBySession(Map<String, Object> record);

	/**
	 * 根据appid和openid更新session对象信息
	 * 
	 * @param record
	 * @return
	 */
	int updateByAppIdAndOpenId(Map<String, Object> record);
	
	int updateByPrimaryKeySelective(WxSession record);

	/**
	 * 获取sessionkey,在获取时应判断此对象不为null
	 * @param session
	 * @return
	 */
	String getSessionKeyBySessionId(String session);

	Map<String, Object> jscodeToSession(Map<String, Object> paramsMap);

	Map<String, Object> findWxSessionByMiniOpenId(Map<String, Object> condition);
}
