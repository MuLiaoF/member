package cn.wandingkeji.comm.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.security.MessageDigest;
import java.security.SignatureException;


public class MD5Util {
	public static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'A', 'B', 'C', 'D', 'E', 'F' };
	public static char lowerHexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f' };
	public  static String MD5(String s) {
		if (StringUtils.isEmpty(s) || StringUtils.isBlank(s))
		{
			return null;
		}
		
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	public  static String lowerMD5(String s) {
		if (StringUtils.isEmpty(s) || StringUtils.isBlank(s))
		{
			return null;
		}
		
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = lowerHexDigits[byte0 >>> 4 & 0xf];
				str[k++] = lowerHexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getHashCode(Object object) throws IOException{
		if(object == null) return "";
		
		String ss = null;
		ObjectOutputStream s = null;
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
			try {
				s = new ObjectOutputStream(bo);
				s.writeObject(object);
				s.flush();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(s != null) {
					s.close();
					s = null;
				}
			}
		ss = MD5(bo.toString());
		return ss;
	}

	public static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		StringBuffer resultSb = new StringBuffer();
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return resultSb.append(hexDigits[d1]).append(hexDigits[d2]).toString();
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	 /**
     * MD5编码
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
    /**
     * 签名字符串
     *
     * @param text         需要签名的字符串
     * @param key          密钥
     * @param inputCharset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String inputCharset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

	
	public static void main(String[] args) {
		String str = "serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)serviceLocator = getDefaultClassLoader().loadClass(SERVICE_LOCATOR_CLASS)";
		System.out.println(MD5(str));
	}
}
