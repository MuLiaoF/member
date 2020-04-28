package cn.wandingkeji.comm.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

/**
 * 
 * @author jing_huan
 * 2018年1月26日
 */
public class RC4Utils {

	private static String algorithm = "RC4";

	public static byte[] encrypt(String toEncrypt, String key) throws Exception {
		// 创建二进制秘钥
		SecureRandom sr = new SecureRandom(key.getBytes());
		KeyGenerator kg = KeyGenerator.getInstance(algorithm);
		kg.init(sr);
		SecretKey sk = kg.generateKey();

		// 创建密码实例
		Cipher cipher = Cipher.getInstance(algorithm);

		// 使用密钥对密码进行初始化
		cipher.init(Cipher.ENCRYPT_MODE, sk);

		// 加密
		byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());

		return encrypted;
	}

	public static String decrypt(byte[] toDecrypt, String key) throws Exception {
		// 创建二进制秘钥
		SecureRandom sr = new SecureRandom(key.getBytes());
		KeyGenerator kg = KeyGenerator.getInstance(algorithm);
		kg.init(sr);
		SecretKey sk = kg.generateKey();

		// 使用密匙进行解密
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, sk);
		byte[] decrypted = cipher.doFinal(toDecrypt);

		return new String(decrypted);
	}

	private RC4Utils() {
	}

}
