package cn.wandingkeji.common.base.wx.mp.protocol.activation;
/*
 * 获取开卡插件参数 ws 2017-12-14
 */
public class GetUrlReq {

	private String card_id;
	private String outer_str;
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getOuter_str() {
		return outer_str;
	}
	public void setOuter_str(String outer_str) {
		this.outer_str = outer_str;
	}
	
	
}
