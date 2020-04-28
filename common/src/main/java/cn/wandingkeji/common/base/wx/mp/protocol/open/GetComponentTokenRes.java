package cn.wandingkeji.common.base.wx.mp.protocol.open;

public class GetComponentTokenRes {

	
	private String component_access_token;
	private int expires_in;
	public GetComponentTokenRes() {
		// TODO Auto-generated constructor stub
	}
	public String getComponent_access_token() {
		return component_access_token;
	}
	public void setComponent_access_token(String component_access_token) {
		this.component_access_token = component_access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	

}
