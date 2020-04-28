package cn.wandingkeji.common.utils;

import cn.wandingkeji.common.constant.Constant;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 */
public class RandomStringGenerator {

	private static String baseString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * 获取一定长度的随机字符串
	 * 
	 * @param length
	 *            指定字符串长度
	 * @return 一定长度的字符串
	 */
	public static String getRandomStringByLength(int length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();

		String instance_id = Constant.INSTANCE_ID;
		if (!StringUtils.isBlank(instance_id)) {
			sb.append(instance_id);
			length = length - 2;
		}

		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getRandomStringByLengthTwo(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getRandomString(int length) {
		// String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(baseString.length());
			sb.append(baseString.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 32位流水
	 * 
	 * @return
	 */
	public static String getSerialNum() {
		String randomString = DateFormatUtils.ISO_DATETIME.format(new Date())
				+ RandomStringGenerator.getRandomStringByLength(15);// 系统自建的退款订单号
		return randomString;
	}

	/**
	 * 方法1
	 * 
	 * @param min
	 * @param max
	 * @return
	 * 
	 * 
	 */
	public static String getIntRandom(int min, int max) {
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return String.valueOf(s);

		/**
		 * 也可以方法2 (数据类型)(最小值+Math.random()*(最大值-最小值+1)) 例:
		 * (int)(1+Math.random()*(10-1+1)) 从1到10的int型随数
		 */

	}

	/**
	 * @param min
	 * @param max
	 * @return
	 */
	public static String getDoubleRandom(int min, int max) {
		Random random = new Random();
		BigDecimal randomD = new BigDecimal(random.nextDouble());// ;*(max-min)+min;
		BigDecimal multiplyMiddle = randomD.multiply(new BigDecimal(max - min)).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal result = multiplyMiddle.add(new BigDecimal(min));
		return String.valueOf(result);

	}

	public static void main(String[] args) {
		System.out.println(getDoubleRandom(1, 20));
	}

	/*
	 * 安卓调用新大陆流水号
	 */
	public static String getNlRandomNum(String deviceNum) {
		String randomString = "NL" + DateFormatUtils.ISO_DATETIME.format(new Date()) + deviceNum
				+ RandomStringGenerator.getRandomStringByLength(5);// 系统自建的退款订单号
		return randomString;
	}

	/*
	 * 安卓调用本平台流水号
	 */
	public static String getAwRandomNum() {
		String randomString = "AW" + DateFormatUtils.ISO_DATETIME.format(new Date())
				+ RandomStringGenerator.getRandomStringByLength(13);// 系统自建的退款订单号
		return randomString;
	}

}
