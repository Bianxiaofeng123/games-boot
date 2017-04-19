package com.games.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
	// 七牛
	final static public String QINIU_ACCESS_KEY = "";
	// 七牛
	final static public String QINIU_SECRET_KEY = "";
	// 私有图片获取过期默认时间（秒）
	final static public long tokenFailedSec = 3600;
	// 图片上传校验图片大小默认值 b （2m）
	final static public long checkFileLong = 1024 * 1024 * 2;
	public static final String privateBucketname = "privateBucketname";
	public static final String publicBucketname = "publicBucketname";
	public static final String publicAcsResBucket = "publicAcsResBucket";
	public static final String privateUrl = "privateUrl";
	public static final String publicUrl = "publicUrl";
	public static final String publicPipeline = "publicPipeline";

	public static List<Map<String, Object>> uopidsConstants() {
		List<Map<String, Object>> resultList = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "杨辉");
		map1.put("uopid", "ox705w5qQKiz2AexU2FzKqS4ut20");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("name", "小叶");
		map2.put("uopid", "ox705w9NizhZf2AErFPPvQKE0V0o");

		Map<String, Object> map3 = new HashMap<>();
		map3.put("name", "雷");
		map3.put("uopid", "ox705w-elrOdC8-M0_0SFlKIKFaA");

		Map<String, Object> map4 = new HashMap<>();
		map4.put("name", "支青");
		map4.put("uopid", "ox705wzfv9-55j6VfzEfQPGa8qfQ");
		resultList.add(map1);
		resultList.add(map2);
		resultList.add(map3);
		resultList.add(map4);
		return resultList;
	}
	// -------------------------------------百度ocr--------------------------------------
		// APP_ID
		public static final String BAIDU_OCR_APP_ID = "9402809";
		// AK
		public static final String BAIDU_OCR_API_KEY = "svWDc1plyHgWlKD2MmGf9nG0";
		// SK
		public static final String BAIDU_OCR_SECRET_KEY = "39yfKa49bmMFyjPHxtZg4v95ygeny5C1";
		// AK_ID
		public static final String BAIDU_OCR_ACCESS_KEY_ID = "ef503624977f4a198a0e1b2e2c0b3c9e";
		//检测朝向
		public static final String BAIDU_OCR_DETECT_DIRECTION = "false";
		// 语言
		// - CHN_ENG：中英文混合；
		// - ENG：英文；
		// - POR：葡萄牙语；
		// - FRE：法语；
		// - GER：德语；
		// - ITA：意大利语；
		// - SPA：西班牙语；
		// - RUS：俄语；
		// - JAP：日语
		public static final String BAIDU_OCR_LANGUAGE_TYPE = "CHN_ENG";

		// -------------------------------------百度ocr--------------------------------------
		// 高德地图
		public static final String GAODE_KEY = "cf0e7ec69e8c895f0f1d19cc18e86e9a";
		public static final String GAODE_REGEO_URL = "http://restapi.amap.com/v3/geocode/regeo?output=json&key="+ GAODE_KEY +"&location=%1s,%2s";
		public static final String GAODE_TEXT_URL = "http://restapi.amap.com/v3/place/text?output=json&key="+ GAODE_KEY+"&keywords=%1s";
		public static final String GAODE_GEO_URL = "http://restapi.amap.com/v3/geocode/geo?output=json&key="+ GAODE_KEY+"&address=";
		

}
