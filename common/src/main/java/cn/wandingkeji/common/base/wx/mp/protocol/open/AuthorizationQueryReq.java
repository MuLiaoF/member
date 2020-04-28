package cn.wandingkeji.common.base.wx.mp.protocol.open;

public class AuthorizationQueryReq {
	private String component_appid;
	private String authorization_code;
	public AuthorizationQueryReq(){}
	public AuthorizationQueryReq(String component_appid,String authorization_code){
		this.component_appid = component_appid;
		this.authorization_code = authorization_code;
	}
	public String getComponent_appid() {
		return component_appid;
	}
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}
	public String getAuthorization_code() {
		return authorization_code;
	}
	public void setAuthorization_code(String authorization_code) {
		this.authorization_code = authorization_code;
	}

}
