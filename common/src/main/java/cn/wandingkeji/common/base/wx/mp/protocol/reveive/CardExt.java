package cn.wandingkeji.common.base.wx.mp.protocol.reveive;
/*
 * 开卡组件参数
 * add by ws
 * 20190517
 */
public class CardExt {

	private String code;
	private String openid;
	private String timestamp;
	private String nonce_str;
	private String fixed_begintimestamp;
	private String outer_str;
	private String signature;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getFixed_begintimestamp() {
		return fixed_begintimestamp;
	}
	public void setFixed_begintimestamp(String fixed_begintimestamp) {
		this.fixed_begintimestamp = fixed_begintimestamp;
	}
	public String getOuter_str() {
		return outer_str;
	}
	public void setOuter_str(String outer_str) {
		this.outer_str = outer_str;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "CardExt{" +
				"code='" + code + '\'' +
				", openid='" + openid + '\'' +
				", timestamp='" + timestamp + '\'' +
				", nonce_str='" + nonce_str + '\'' +
				", fixed_begintimestamp='" + fixed_begintimestamp + '\'' +
				", outer_str='" + outer_str + '\'' +
				", signature='" + signature + '\'' +
				'}';
	}
}
