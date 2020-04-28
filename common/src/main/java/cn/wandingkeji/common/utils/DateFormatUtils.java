package cn.wandingkeji.common.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

public class DateFormatUtils {

	public static final FastDateFormat ISO_DATETIME_FORMAT1 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
	public static final FastDateFormat ISO_DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss");
	public static final FastDateFormat ISO_DATETIME = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");
	public static final FastDateFormat ISO_DATETIME_SS = FastDateFormat.getInstance("yyyyMMddHHmmss");
	public static final FastDateFormat ISO_DATETIME_HH = FastDateFormat.getInstance("yyyy-MM-dd HH");

	// 以T分隔日期和时间, 并带时区信息, 符合ISO8601规范
	public static final String PATTERN_ISO = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
	public static final String PATTERN_ISO_ON_SECOND = "yyyy-MM-dd'T'HH:mm:ssZZ";
	public static final String PATTERN_ISO_ON_DATE = "yyyy-MM-dd";

	// 以空格分隔日期和时间, 不带时区信息
	public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String PATTERN_DEFAULT_ON_SECOND = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 分析日期字符串, 仅用于pattern不固定的情况.
	 * 
	 * 否则直接使用DateFormats中封装好的FastDateFormat.
	 * 
	 * FastDateFormat.getInstance()已经做了缓存，不会每次创建对象，但直接使用对象仍然能减少在缓存中的查找.
	 * 
	 * @throws ParseException
	 */
	public static Date parseDate(String pattern, String dateString) throws ParseException {
		return FastDateFormat.getInstance(pattern).parse(dateString);
	}

	/**
	 * 格式化日期, 仅用于pattern不固定的情况.
	 * 
	 * 否则直接使用本类中封装好的FastDateFormat.
	 * 
	 * FastDateFormat.getInstance()已经做了缓存，不会每次创建对象，但直接使用对象仍然能减少在缓存中的查找.
	 */
	public static String formatDate(String pattern, Date date) {
		return FastDateFormat.getInstance(pattern).format(date);
	}

	/**
	 * 格式化日期, 仅用于不固定pattern不固定的情况.
	 * 
	 * 否否则直接使用本类中封装好的FastDateFormat.
	 * 
	 * FastDateFormat.getInstance()已经做了缓存，不会每次创建对象，但直接使用对象仍然能减少在缓存中的查找.
	 */
	public static String formatDate(String pattern, long date) {
		return FastDateFormat.getInstance(pattern).format(date);
	}

}
