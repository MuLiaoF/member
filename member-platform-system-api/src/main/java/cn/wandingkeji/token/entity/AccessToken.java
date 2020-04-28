package cn.wandingkeji.token.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author fujiarui
 *
 */
public class AccessToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String appname;
	private String thirdmid;
	private String appId;
	private String appSecret;
	private String appToken;
	private String encodingAESKey;
	private String channel_mid;// 商户标识
	private int type;// 1.普通服务商、2.小微服务商、3.全渠道大商户、4.普通商户
	private String access_token;
	private int expires_in;
	private long expiresTime;
	private Timestamp createTime;
	private String reserve1;// 启用备用字段，支付通知的通用订单模板ID
	private String reserve2;
	private String api_key;
	private String cert_path;
	private String cert_pwd;
	private int agent_id;
	private int parent_id;
	private String isopen;// Y代表开发平台代公众号和小程序的token
	private String refresh_token;// 开发平台代公众号和小程序的token超时后需要用的刷新令牌重新获取，否则需要重新授权，所以必须要存上

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public AccessToken() {
	}

	public AccessToken(String appId, String access_token, int expires_in) {
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.expiresTime = (System.currentTimeMillis() + (expires_in - 200) * 1000l) / 1000;
		// this.id = id;
		this.appId = appId;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	

	public long getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(long expiresTime) {
		this.expiresTime = expiresTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public String getChannel_mid() {
		return channel_mid;
	}

	public void setChannel_mid(String channel_mid) {
		this.channel_mid = channel_mid;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getAppToken() {
		return appToken;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getThirdmid() {
		return thirdmid;
	}

	public void setThirdmid(String thirdmid) {
		this.thirdmid = thirdmid;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public String getCert_path() {
		return cert_path;
	}

	public void setCert_path(String cert_path) {
		this.cert_path = cert_path;
	}

	public String getCert_pwd() {
		return cert_pwd;
	}

	public void setCert_pwd(String cert_pwd) {
		this.cert_pwd = cert_pwd;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIsopen() {
		return isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String toString() {
		return "{appid=" + this.appId + "|id=" + this.id + "|token=" + this.access_token + "|expires_in="
				+ this.expires_in + "|expiresTime=" + this.expiresTime + "|type=" + this.type + "}";
	}

}
