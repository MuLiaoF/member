package cn.wandingkeji.comm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Sha1Util {
	private static final Logger log = LoggerFactory.getLogger(Sha1Util.class);
	public static String getNonceStr() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}

	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}

	// 创建签名SHA1
	public static String createSHA1Sign(SortedMap<String, String> signParams) throws Exception {
		StringBuffer sb = new StringBuffer();
		Set es = signParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			sb.append(k + "=" + v + "&");
			// 要采用URLENCODER的原始值！
		}
		String params = sb.substring(0, sb.lastIndexOf("&"));
		System.out.println("sha1 sb:" + params);
		return getSha1(params);
	}
	
    /**
     * 
     * @param map
     * @param key
     * @return
     */
    public static String getSHA1Sign(Map<String, Object> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != "") {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
        	if(i+1==size){
        		//去除最后的&
        		sb.append(arrayToSort[i].substring(0, arrayToSort[i].length()-1));
        	}else{
        		
        		sb.append(arrayToSort[i]);
        	}
        }
        String result = sb.toString();
        log.debug("Sign Before SHA1:" + result);
        MessageDigest crypt = null;
        String signature =null;
		try {
			crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(result.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        result = MD5.MD5Encode(result).toUpperCase();
        log.debug("Sign Result:" + signature);
        return signature;
    }
    /**
     * 
     * @param map
     * @param key
     * @return
     */
    public static String getCardSHA1Sign(Map<String, Object> map) {
    	ArrayList<String> list = new ArrayList<String>();
    	for (Map.Entry<String, Object> entry : map.entrySet()) {
    		if (entry.getValue() != "") {
    			list.add(entry.getValue().toString());
    		}
    	}
    	int size = list.size();
    	String[] arrayToSort = list.toArray(new String[size]);
    	Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < size; i++) {
    		sb.append(arrayToSort[i]);
    	}
    	String result = sb.toString();
    	log.debug("Sign Before SHA1:" + result);
    	MessageDigest crypt = null;
    	String signature =null;
    	try {
    		crypt = MessageDigest.getInstance("SHA-1");
    		crypt.reset();
    		crypt.update(result.getBytes("UTF-8"));
    		signature = byteToHex(crypt.digest());
    	} catch (NoSuchAlgorithmException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (UnsupportedEncodingException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
//        result = MD5.MD5Encode(result).toUpperCase();
    	log.debug("Sign Result:" + signature);
    	return signature;
    }

	// Sha1签名
	public static String getSha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes("UTF-8"));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}
	 private static String byteToHex(final byte[] hash) {
	        Formatter formatter = new Formatter();
	        for (byte b : hash)
	        {
	            formatter.format("%02x", b);
	        }
	        String result = formatter.toString();
	        formatter.close();
	        return result;
	    }
	
	public static void main(String[] args) {
		String kk = "jsapi_ticket=kgt8ON7yVITDhtdwci0qeXESsNLgjnQYfMT-NyI9MzCbPjIZpIT1O-eqsQPDaxI1rEGEAPqZaCsdP16WGUr7DQ&noncestr=04ECB1FA28506CCB6F72B12C0245DDBC&timestamp=1496998191&url=http://test.weupay.com/pay/shopping/index.html?code=061mjwA81r3EXS1TFVx81OoxA81mjwAB&mid=66";
		String ss  = "jsapi_ticket=kgt8ON7yVITDhtdwci0qeXESsNLgjnQYfMT-NyI9MzCbPjIZpIT1O-eqsQPDaxI1rEGEAPqZaCsdP16WGUr7DQ&nonceStr=04ECB1FA28506CCB6F72B12C0245DDBC&timestamp=1496998191&url=http://test.weupay.com/pay/shopping/index.html?code=061mjwA81r3EXS1TFVx81OoxA81mjwAB&mid=66";
		System.out.println(kk.substring(0,kk.length()-1));
	}
}
