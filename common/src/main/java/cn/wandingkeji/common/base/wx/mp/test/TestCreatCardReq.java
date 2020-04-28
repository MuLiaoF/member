package cn.wandingkeji.common.base.wx.mp.test;

import java.util.List;

/*
 * 设置测试白名单 请求
 * add by ws
 * 20170506
 */
public class TestCreatCardReq {

	private List<String> openid;
	private List<String> username;
	public List<String> getOpenid() {
		return openid;
	}
	public void setOpenid(List<String> openid) {
		this.openid = openid;
	}
	public List<String> getUsername() {
		return username;
	}
	public void setUsername(List<String> username) {
		this.username = username;
	}
	
	
}
