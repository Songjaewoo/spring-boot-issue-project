package com.songjaewoo.util;

import java.util.HashMap;
import java.util.Map;

import com.songjaewoo.model.type.CategoryType;

public class Constant {

	public static Map<Integer, CategoryType> getCategoryType() {
		Map<Integer, CategoryType> categoryMap = new HashMap<Integer, CategoryType>();
		
		for (CategoryType c : CategoryType.values()) {
			categoryMap.put(c.seq, c);
		}
		
		return categoryMap;
	}
}
