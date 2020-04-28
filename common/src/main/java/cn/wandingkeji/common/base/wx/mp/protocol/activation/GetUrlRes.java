package cn.wandingkeji.common.base.wx.mp.protocol.activation;

public class GetUrlRes {

	private String errcode;
	private String errmsg;
	private String url;//内含调用开卡插件所需的参数
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
