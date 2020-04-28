package cn.wandingkeji.comm.utils;

import cn.wandingkeji.common.utils.DateFormatUtils;
import org.apache.commons.codec.binary.Hex;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 自定义平台码值规则 (code码)
 * @author jing_huan
 * @date 2019年5月20日
 *
 */
public class CodeRoleUtil {

	/**
	 * 生成code规则(之前邀请码规则)
	 * 生成14随机数 规则如下<br>
	 * @return 
	 */
	public static String generateCode() {
		StringBuffer codeStr = new StringBuffer();
		codeStr.append("8");
		codeStr.append(randomMath(10));
		return codeStr.toString();
	}
	public static String generateInviteCode() throws Exception {
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		int random = threadLocalRandom.nextInt(999999999);
		String key = UUID.randomUUID().toString();
		String encode = new String(Hex.encodeHex(RC4Utils.encrypt(String.valueOf(random), key)));
		String encodeTemp = encode.substring(0, 14);
		int replacement = threadLocalRandom.nextInt(9);
		String regex = "[A-Za-z]";
		return encodeTemp.replaceAll(regex, replacement + "");
	}
	/**
	 * <br>生成cardid规则
	 * <br> 2位数(类型代表业务 例如:90,91...)+年月日时分秒毫秒+9位随机数
	 * <br> 总:28位
	 * @return
	 */
	public static String generateCardId(String type) {
		StringBuffer codeStr = new StringBuffer();
		codeStr.append(type);
		codeStr.append(DateFormatUtils.ISO_DATETIME.format(new Date()));
		codeStr.append(randomMath(9));
		return codeStr.toString();
	} 		
	
	public static  String randomMath(int math) {
		Random random = new Random();
		String str =""; 
		for (int i = 0; i < math; i++) {
			int nextInt = random.nextInt(10);
			str = str+nextInt;
			//System.out.println(str);
		}
		return str;
	} 	
	
	public static void main(String[] args) {
		
		System.out.println(generateCardId("ka"));
		try {
			System.out.println(generateInviteCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
