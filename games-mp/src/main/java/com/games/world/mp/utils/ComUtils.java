package com.games.world.mp.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

public class ComUtils {
	public static Map<String,String> unicodeParamstr2Map(String str){
		String paramstr = StringEscapeUtils.unescapeJava(str);
		Map<String, String> result = new LinkedHashMap<String, String>();
	    String[] pairs = paramstr.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        if (idx >= 0){
	        	result.put(pair.substring(0, idx), pair.substring(idx + 1));
	        }else{
	        	result.put(pair, null);
	        }
	    }
	    return result;
	}

}
