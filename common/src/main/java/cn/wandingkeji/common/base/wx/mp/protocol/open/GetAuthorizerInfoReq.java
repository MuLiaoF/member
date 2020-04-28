package cn.wandingkeji.common.base.wx.mp.protocol.open;

/**
 * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
 * @author Administrator
 *
 */
public class GetAuthorizerInfoReq {
	private String component_appid;
	private String authorizer_appid;
	public GetAuthorizerInfoReq(){}
	public GetAuthorizerInfoReq(String component_appid,String authorizer_appid){
		this.component_appid = component_appid;
		this.authorizer_appid = authorizer_appid;
	}
	public String getComponent_appid() {
		return component_appid;
	}
	public void setComponent_appid(String component_appid) {
		this.component_appid = component_appid;
	}
	public String getAuthorizer_appid() {
		return authorizer_appid;
	}
	public void setAuthorizer_appid(String authorizer_appid) {
		this.authorizer_appid = authorizer_appid;
	}
	

}
