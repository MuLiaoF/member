package cn.wandingkeji.common.base.wx.mp.protocol.manageCard.in.code;

/**
 * @author fjr
 *解密code
 */
public class DecryptCodeReq {

	public DecryptCodeReq(String encrypt_code) {
		// TODO Auto-generated constructor stub
		this.encrypt_code = encrypt_code;
	}
	private String encrypt_code;
	public String getEncrypt_code() {
		return encrypt_code;
	}
	public void setEncrypt_code(String encrypt_code) {
		this.encrypt_code = encrypt_code;
	}

}
