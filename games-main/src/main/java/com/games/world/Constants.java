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

	final static public String QRCODE_CHARSET = "UTF-8";
	// 生成二维码格式
	final static public String QRCODE_FORMAT_NAME = "JPG";
	// 二维码尺寸
	final static public int QRCODE_SIZE = 430;
	// 二维码LOGO宽度
	final static public int QRCODE_LOGO_WIDTH = 150;
	// 二维码LOGO高度
	final static public int QRCODE_LOGO_HEIGHT = 150;
	// 分享二维码头像与二维码宽度
	final static public int QRCODE_HD_WIDTH = 80;
	// 分享二维码头像与二维码高度
	final static public int QRCODE_HD_HEIGHT = 80;

	// 客服登录名
	final static public String CS_NAME = "cs001";
	// 客服登录密码
	final static public String CS_PWD = "b01f6c9f53b211e6817300163e010f1e";

	// 高德地图
	public static final String GAODE_KEY = "cf0e7ec69e8c895f0f1d19cc18e86e9a";
	// POI类型 综合医院和专科医院（查询医院所用的type）
	public static final String GAODE_SEARCH_TYPES = "0901|0902";

	public static final String GAODE_REGEO_URL = "http://restapi.amap.com/v3/geocode/regeo?output=json&key="
			+ Constants.GAODE_KEY + "&location=%1s,%2s";

	// word导出模板保存地址
	public static final String HRULE_TEMPLATE_FILE = "hrule_template.xml";

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

}
