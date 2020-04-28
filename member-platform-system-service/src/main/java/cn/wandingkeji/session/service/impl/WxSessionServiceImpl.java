package cn.wandingkeji.session.service.impl;

import cn.wandingkeji.comm.enums.AccessTokenType;
import cn.wandingkeji.comm.enums.PlatformEnum;
import cn.wandingkeji.comm.service.GetTokenService;
import cn.wandingkeji.comm.utils.SessionIdGeneratorUtils;
import cn.wandingkeji.common.http.PayHelper;
import cn.wandingkeji.common.utils.ObjectUtils;
import cn.wandingkeji.session.entity.WxSession;
import cn.wandingkeji.session.mapper.WxSessionMapper;
import cn.wandingkeji.session.service.IWxSessionService;
import cn.wandingkeji.system.entity.PlatformBaseData;
import cn.wandingkeji.system.service.IPlatformBaseDataService;
import cn.wandingkeji.token.entity.AccessToken;
import cn.wandingkeji.token.entity.AccessTokenRes;
import cn.wandingkeji.token.service.IGetTokenUtilService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service("wxSessionService")
public class WxSessionServiceImpl implements IWxSessionService {
	private static final Logger log = LoggerFactory.getLogger(WxSessionServiceImpl.class);
	@Autowired
	private WxSessionMapper wxSessionMapper;
	@Autowired
	private IGetTokenUtilService getTokenUtilService;
	@Autowired
	private IPlatformBaseDataService platformBaseDataService;
	@Value("${open.appid}")
	private String openAppid;// 生产：wxfaba01cbb5e3fb5d；测试：wx6b38dc60888d07b2
	public int saveSelective(WxSession record) {
		int result = wxSessionMapper.insertSelective(record);
		return result;
	}

	public WxSession findByAppIdAndOpenId(Map<String, Object> record) {
		WxSession wxSession = wxSessionMapper.selectByAppIdAndOpenId(record);
		return wxSession;
	}

	public int updateByAppIdAndOpenId(Map<String, Object> record) {
		int result = wxSessionMapper.updateByAppIdAndOpenId(record);
		return result;
	}

	@Override
	public WxSession findBySession(Map<String, Object> record) {
		WxSession wxSession = wxSessionMapper.selectBySession(record);
		return wxSession;
	}

	@Override
	public String getSessionKeyBySessionId(String session) {
		Map<String, Object> record=new HashMap<>();
		record.put("session", session);
		WxSession wxSession = wxSessionMapper.selectBySession(record);
		if(ObjectUtils.isNotEmpty(wxSession)){
			return wxSession.getSessionKey();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> jscodeToSession(Map<String, Object> paramsMap) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			String js_code = (String) paramsMap.get("code");
			String appid = (String) paramsMap.get("appid");// 小程序的appid
			String sessionId = (String) paramsMap.get("session");

			// TODO 通过appid和type查询token
			AccessToken openToken = getTokenUtilService.getTokenByTypeAndAppid(AccessTokenType.TYPE_5.getType(), openAppid);
			//第三方授权模式代小程序实现登录
			PlatformBaseData tokenUrlData = platformBaseDataService.findByDataKey(PlatformEnum.TOKENURL.getKey());
			String tokenUrl = tokenUrlData.getDataValue();
			//TODO 通过appid和type查询accesstoken
			String getTokenUrl = String.format(tokenUrl, openToken.getId());
			GetTokenService getTokenService = new GetTokenService();
			AccessTokenRes accessTokenRes = getTokenService.request(getTokenUrl);
			
			String component_access_token = accessTokenRes.getAccessToken();
			String reqUrl = "https://api.weixin.qq.com/sns/component/jscode2session?appid=" + appid + "&js_code=" + js_code + "&grant_type=authorization_code"+"&component_appid="+openAppid+"&component_access_token="+component_access_token;
			 
			log.info("请求微信接口地址====" + reqUrl);
			String returnRes = PayHelper.sendGET(reqUrl);
			log.info("登录凭证校验返回结果====" + returnRes);
			Map<String, Object> resMap = (Map<String, Object>) JSONObject.parseObject(returnRes);
			if (!resMap.containsKey("errcode")) {
				String openId = "";
				String sessionKey = "";
				String unionid = "";
				if (resMap.get("openid") != null) {
					openId = (String) resMap.get("openid");
				}
				if (resMap.get("session_key") != null) {
					sessionKey = (String) resMap.get("session_key");
				}
				if (resMap.get("unionid") != null) {
					unionid = (String) resMap.get("unionid");
				}

				log.info("获取到小程序openId==" + openId);
				String session = SessionIdGeneratorUtils.generateSessionId();
				log.info("获取到小程序session==" + session);
				log.info("获取到小程序sessionId==" + sessionId);
				if (StringUtils.isEmpty(sessionId)) {
					Map<String, Object> condition = new HashMap<>();
					condition.put("appid", appid);
					condition.put("openid", openId);
					WxSession wxSession = wxSessionMapper.selectByAppIdAndOpenId(condition);
					if (wxSession == null) {
						// 插入
						WxSession insertWxSession = new WxSession();
						insertWxSession.setAppid(appid);
						insertWxSession.setOpenid(openId);
						insertWxSession.setSessionKey(sessionKey);
						insertWxSession.setReserve1(unionid);
						long currentTime = System.currentTimeMillis();
						long expiresTime = (currentTime + 7000 * 1000l) / 1000;
						insertWxSession.setExpiresTime(expiresTime);
						insertWxSession.setExpiresIn(7200);
						insertWxSession.setGmtCreate(new Date());
						insertWxSession.setSession(session);

						wxSessionMapper.insertSelective(insertWxSession);
					} else {
						// 更新session
						Map<String, Object> updateMap = new HashMap<>();
						updateMap.put("session", session);
						updateMap.put("sessionKey", sessionKey);
						long currentTime = System.currentTimeMillis();
						long expiresTime = (currentTime + 7000 * 1000l) / 1000;
						updateMap.put("expiresTime", expiresTime);
						updateMap.put("appid", appid);
						updateMap.put("openid", openId);

						wxSessionMapper.updateByAppIdAndOpenId(updateMap);
					}
				} else {
					Map<String, Object> updateMap = new HashMap<>();
					updateMap.put("session", session);
					updateMap.put("sessionKey", sessionKey);
					long currentTime = System.currentTimeMillis();
					long expiresTime = (currentTime + 7000 * 1000l) / 1000;
					updateMap.put("expiresTime", expiresTime);
					updateMap.put("appid", appid);
					updateMap.put("openid", openId);

					wxSessionMapper.updateByAppIdAndOpenId(updateMap);
				}
				returnMap.put("sessionId", session);
				returnMap.put("openId", openId);
			}
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			log.error("jscodeToSession异常");
		}
		return returnMap;
	}

	@Override
	public int updateByPrimaryKeySelective(WxSession record) {
		
		return wxSessionMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Map<String, Object> findWxSessionByMiniOpenId(Map<String, Object> condition) {
		return wxSessionMapper.findWxSessionByMiniOpenId(condition);
	}

}
