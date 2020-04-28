package cn.wandingkeji.common.base.wx.mp.protocol.open;

import java.util.Map;

/**
 * 授权方的帐号基本信息
 * @author Administrator
 *
 */
public class AuthorizerInfo {
	private String nick_name;
	private String head_img;
	private Map<String,Object> service_type_info;//授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号，示例{ "id": 2 }
	private Map<String,Object> verify_type_info;//示例：{ "id": 2 }
	private String user_name;//授权方公众号的原始ID
	private String principal_name;//公众号的主体名称
	private String alias;//授权方公众号所设置的微信号，可能为空
	private String business_info;//用以了解以下功能的开通状况（0代表未开通，1代表已开通）示例{"open_store": 0, "open_scan": 0, "open_pay": 0, "open_card": 0, "open_shake": 0}
	private String qrcode_url;//二维码图片的URL，开发者最好自行也进行保存
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getHead_img() {
		return head_img;
	}
	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}
	public Map<String, Object> getService_type_info() {
		return service_type_info;
	}
	public void setService_type_info(Map<String, Object> service_type_info) {
		this.service_type_info = service_type_info;
	}
	public Map<String, Object> getVerify_type_info() {
		return verify_type_info;
	}
	public void setVerify_type_info(Map<String, Object> verify_type_info) {
		this.verify_type_info = verify_type_info;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPrincipal_name() {
		return principal_name;
	}
	public void setPrincipal_name(String principal_name) {
		this.principal_name = principal_name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getBusiness_info() {
		return business_info;
	}
	public void setBusiness_info(String business_info) {
		this.business_info = business_info;
	}
	public String getQrcode_url() {
		return qrcode_url;
	}
	public void setQrcode_url(String qrcode_url) {
		this.qrcode_url = qrcode_url;
	}
	

	
}
