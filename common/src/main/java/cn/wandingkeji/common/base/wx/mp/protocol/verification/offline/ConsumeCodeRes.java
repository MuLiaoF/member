package cn.wandingkeji.common.base.wx.mp.protocol.verification.offline;

import java.util.Map;

/*
 * 核销Code接口出参
 * add by ws
 * 0605
 */
public class ConsumeCodeRes {

	private String errcode;
	private String errmsg;   //自定义code时card_id传入
	private Map<String,Object> card;
	private String openid;
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
	public Map<String, Object> getCard() {
		return card;
	}
	public void setCard(Map<String, Object> card) {
		this.card = card;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
	
	
	
	
	
	
	
}
