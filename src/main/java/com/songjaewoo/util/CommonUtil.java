package com.songjaewoo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {
	
	public static Map<String, String> getQueryMap(String query) {
		String[] params = query.split("&");
		Map<String, String> map = new HashMap<String, String>();
		for (String param : params) {
			String[] p = param.split("=");
			String name = p[0];
			if (p.length > 1) {
				String value = p[1];
				map.put(name, value);
			}
		}
		return map;
	}
	
	public static Date convertStringToDate(String date, String dateFormat) throws ParseException {
		if (dateFormat == null) {
			dateFormat = "yyyy-MM-dd HH:mm:ss";
		}
		
		SimpleDateFormat transFormat = new SimpleDateFormat(dateFormat);
		Date toDate = transFormat.parse(date);
		
		return toDate;
		
	}
}
