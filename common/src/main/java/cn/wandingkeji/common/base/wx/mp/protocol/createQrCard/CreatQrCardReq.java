package cn.wandingkeji.common.base.wx.mp.protocol.createQrCard;



/*
 * 创建二维码接口
 * add by ws
 * 20170506
 */
public class CreatQrCardReq {

	private String action_name="QR_CARD"; //单个卡卷：QR_CARD；多个卡卷：QR_MULTIPLE_CARD
	private String expire_seconds;
	ActionInfo action_info;
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	
	
	public String getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public ActionInfo getAction_info() {
		return action_info;
	}
	public void setAction_info(ActionInfo action_info) {
		this.action_info = action_info;
	}
	
	
}
