package cn.wandingkeji.session.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

//import com.weupay.admin.model.Entity;

public class WxSession {

	private static Logger log = LoggerFactory.getLogger(WxSession.class);

	private Integer id;

	private String appid;

	private String openid;

	private String session;

	private String sessionKey;

	private Integer expiresIn;

	private Long expiresTime;

	private Date gmtCreate;

	private Date gmtModified;

	private String reserve1;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public Integer getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(Long expiresTime) {
		this.expiresTime = expiresTime;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public WxSession() {
		super();
	}

	public WxSession(String appid, String openid, String session, String sessionKey, Integer expiresIn) {
		super();
		this.appid = appid;
		this.openid = openid;
		this.session = session;
		this.sessionKey = sessionKey;
		this.expiresIn = Integer.valueOf(String.valueOf(((System.currentTimeMillis() + expiresIn * 1000l) / 1000)));
	}

	public synchronized boolean isSessionExpired() {
		log.info("过期时间戳：" + this.expiresTime * 1000);
		long currentTime = System.currentTimeMillis();
		log.info("当前时间戳：" + currentTime);
		boolean result = currentTime > this.expiresTime * 1000;
		log.info("是否过期：" + result);
		return result;
	}

}