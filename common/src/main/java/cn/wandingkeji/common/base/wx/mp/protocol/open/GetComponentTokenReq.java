package cn.wandingkeji.common.base.wx.mp.protocol.open;

/**
 * 第三方平台component_access_token是第三方平台的下文中接口的调用凭据
 * @author Administrator
 *
 */
public class GetComponentTokenReq {
	private String component_appid;
	private String component_appsecret;
	private String component_verify_ticket;
	public GetComponentTokenReq(){}
	public GetComponentTokenReq(String component_appid,String component_appsecret,String component_verify_ticket){
		this.component_appid = component_appid;
		this.component_appsecret = component_appsecret;
		this.component_verify_ticket = component_verify_ticket;
	}
	public String getComponent_appid() {
		return component_appid;
	}
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}
	public String getComponent_appsecret() {
		return component_appsecret;
	}
	public void setComponent_appsecret(String component_appsecret) {
		this.component_appsecret = component_appsecret;
	}
	public String getComponent_verify_ticket() {
		return component_verify_ticket;
	}
	public void setComponent_verify_ticket(String component_verify_ticket) {
		this.component_verify_ticket = component_verify_ticket;
	}
	

}
