package cn.wandingkeji.token.entity;

public class AccessTokenRes {

	/**
	 * 错误码
	 */
	private String return_code;

	/**
	 * 对错误码的描述
	 */
	private String return_msg;

	private String thirdmid;

	private String appid;

	private String appSecret;

	private String appToken;

	private String encodingaeskey;

	private String accessToken;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getThirdmid() {
		return thirdmid;
	}

	public void setThirdmid(String thirdmid) {
		this.thirdmid = thirdmid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppToken() {
		return appToken;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getEncodingaeskey() {
		return encodingaeskey;
	}

	public void setEncodingaeskey(String encodingaeskey) {
		this.encodingaeskey = encodingaeskey;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccessTokenRes [return_code=");
		builder.append(return_code);
		builder.append(", return_msg=");
		builder.append(return_msg);
		builder.append(", thirdmid=");
		builder.append(thirdmid);
		builder.append(", appid=");
		builder.append(appid);
		builder.append(", appSecret=");
		builder.append(appSecret);
		builder.append(", appToken=");
		builder.append(appToken);
		builder.append(", encodingaeskey=");
		builder.append(encodingaeskey);
		builder.append(", accessToken=");
		builder.append(accessToken);
		builder.append("]");
		return builder.toString();
	}

}
