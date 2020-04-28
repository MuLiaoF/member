/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

/**
 * 针对org.apache.commons.codec.binary.Base64，
 * 需要导入架包commons-codec-1.9（或commons-codec-1.8等其他版本）
 * 官方下载地址：http://commons.apache.org/proper/commons-codec/download_codec.cgi
 */
package cn.wandingkeji.comm.utils;

import cn.wandingkeji.system.exception.AesException;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.Security;
import java.util.Random;

/**
 * 提供接收和推送给小程序平台消息的加解密接口(UTF8编码的字符串).
 */
public class WXMiniBizMsgCrypt {
	private static final Logger log = LoggerFactory.getLogger(WXMiniBizMsgCrypt.class);
	static Charset CHARSET = Charset.forName("utf-8");
	 // 算法名称
	final String KEY_ALGORITHM = "AES";
	 // 加解密算法/模式/填充方式
	final String algorithmStr = "AES/CBC/PKCS7Padding";//AES/CBC/PKCS7Padding
	Base64 base64 = new Base64();
	byte[] aesKey;
	String session_key;
	String appId;

	/**
	 * 构造函数
	 * @param sessionKey 小程序的
	 * @param appId 小程序appid
	 * 
	 * @throws AesException 执行失败，请查看该异常的错误码和具体的错误信息
	 */
	public WXMiniBizMsgCrypt(String sessionKey, String appId) throws AesException {


		
		this.appId = appId;
		aesKey = Base64.decodeBase64(sessionKey);
		// 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
		/*int base = 16;
		if (aesKey.length % base != 0) {
			int groups = aesKey.length / base + (aesKey.length % base != 0 ? 1 : 0);
			byte[] temp = new byte[groups * base];
			Arrays.fill(temp, (byte) 0);
			System.arraycopy(aesKey, 0, temp, 0, aesKey.length);
			aesKey = temp;
		}*/
	}

	// 生成4个字节的网络字节序
	byte[] getNetworkBytesOrder(int sourceNumber) {
		byte[] orderBytes = new byte[4];
		orderBytes[3] = (byte) (sourceNumber & 0xFF);
		orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
		orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
		orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
		return orderBytes;
	}

	// 还原4个字节的网络字节序
	int recoverNetworkBytesOrder(byte[] orderBytes) {
		int sourceNumber = 0;
		for (int i = 0; i < 4; i++) {
			sourceNumber <<= 8;
			sourceNumber |= orderBytes[i] & 0xff;
		}
		return sourceNumber;
	}

	// 随机生成16位字符串
	String getRandomStr() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 16; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	

	/**
	 * 对密文进行解密.
	 * 
	 * @param text 需要解密的密文
	 * @return 解密得到的明文
	 * @throws AesException aes解密失败
	 */
	public String decrypt(String encryptedData,String ivStr) throws AesException {
		byte[] ivDecode;
		byte[] original;
		try {
			ivDecode = Base64.decodeBase64(ivStr);
			// 设置解密模式为AES的CBC模式
			// 初始化
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance(algorithmStr,"BC");
			SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(ivDecode);
			cipher.init(Cipher.DECRYPT_MODE, key_spec, iv);

			// 使用BASE64对密文进行解码
			byte[] encrypted = Base64.decodeBase64(encryptedData);

			// 解密
			original = cipher.doFinal(encrypted);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new AesException(AesException.DecryptAESError);
		}

		String result = null;
		if (null != original && original.length > 0) {
            try {
				result = new String(original, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				log.error(e.getMessage());
				throw new AesException(AesException.IllegalBuffer);
			}
        }

		
		return result;

	}

	



	/**
	 * 验证
	 * @param msgSignature 签名串，返回参数的msg_signature
	 * @param rawData 参数的rawData
	 * 
	 * @return 解密之后的signResult true代表验证成功反之false失败
	 * @throws AesException 执行失败，请查看该异常的错误码和具体的错误信息
	 */
	public boolean verifySign(String msgSignature,String rawData)
			throws AesException {
		boolean signResult = false;
		String signature = SHA1.getSHA1(rawData, session_key);

		if (!signature.equals(msgSignature)) {
			throw new AesException(AesException.ValidateSignatureError);
		}else{
			signResult = true;
		}

		return signResult;
	}

}