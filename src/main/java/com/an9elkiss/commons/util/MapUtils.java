package com.an9elkiss.commons.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class MapUtils {

	public static void addIfNotBlank(Map<String, Object> map, String key, Object value) {
		if (value == null) {
			return;
		}

		if (value instanceof String) {
			if (StringUtils.isBlank((String) value)) {
				return;
			}
		}

		map.put(key, value);
	}

}
