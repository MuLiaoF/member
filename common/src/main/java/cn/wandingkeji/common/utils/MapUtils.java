package cn.wandingkeji.common.utils;

import com.google.gson.Gson;

import java.util.Map;

public class MapUtils {
	/**
	 * 判断是否为空.
	 */
	public static boolean isEmpty(final Map<?, ?> map) {
		return (map == null) || map.isEmpty();
	}

	/**
	 * 判断是否为空.
	 */
	public static boolean isNotEmpty(final Map<?, ?> map) {
		return (map != null) && !map.isEmpty();
	}

	public static String mapToString(final Map<?, ?> map) {
		return new Gson().toJson(map);
	}

}
