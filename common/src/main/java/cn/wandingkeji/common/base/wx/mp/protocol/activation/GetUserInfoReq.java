package cn.wandingkeji.common.base.wx.mp.protocol.activation;
/*
 * 拉取会员信息接口
 * add by ws 0513
 */
public class GetUserInfoReq {

	private String card_id;
	private String code;
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
