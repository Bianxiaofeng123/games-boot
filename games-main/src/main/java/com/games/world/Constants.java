package com.games.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
	//答主回答单价最小值
	public static int UPRICE_MIN = 1;
	//答主回答单价最大值
	public static int UPRICE_MAX = 100;
	//答主头衔最小长度
	public static int UTITLE_MIN = 2;
	//答主头衔最大长度
	public static int UTITLE_MAX = 18;
	//答主简介最小长度
	public static int UINTRO_MIN = 2;
	//答主简介最大长度
	public static int UINTRO_MAX = 100;
	//提问问题最小长度20
	public static int QTITLE_MIN = 5;
	///提问问题最大长度
	public static int QTITLE_MAX = 60;
	//问题有效时间（小时数）
	public static int VALID_HOURS = 48;
	//问题过期提醒时间1(小时数)
	public static int REMIND_HOURS_FIRST = 24;
	//问题过期提醒时间2(小时数)
	public static int REMIND_HOURS_SECOND = 46;
	//置顶免费信息池条数(每天置顶展示的总条数)
	public static int TOP_FREEQST_POOL_NUB = 10;	
	//置顶免费信息条数
	public static int TOP_FREEQST_NUB = 5;
	//免费信息条数
	public static int QEST_FREE_NUB = 1;
	//问题榜问题条数
	public static int HOT_QEST_NUB = 20;
	//搜索的结果中答主的展示条数
	public static int SCH_AUSR_NUB = 3;
	//搜索的结果中问题的展示条数
	public static int SCH_QEST_NUB = 3;	
	//提问的问题价格(E答教育)
	public static int EDU_QEST_PRICE = 200;
	
	
	/**
	 * 注意ehg-y1da-schdule 和 ehg-y1da-wechat 有同名的定义
	 */
	@SuppressWarnings("serial")
	public static Map<String, String> SEND_TEMPID_MAP = new HashMap<String,String>(){{
		
		//用户提问通知模板id ( 用户咨询提醒 )
		put("SEND_TEMPID_QST_DEV","9IqgAuamFkaFOLH13tHuIZgBPxPwAf61Q1zPAHs6eF8");
		put("SEND_TEMPID_QST_PROD","x__yNavU_q-z-45AIwUWSYnjtG5dZntc13SFqe3hVVI");
		//收到回复通知模板id ( 咨询回复提醒 )
		put("SEND_TEMPID_ASW_DEV","eGv0-6WVkFZ1IegyO8vL_ezpNIu9tP5UpPv-PSjZY6E");
		put("SEND_TEMPID_ASW_PROD","FxknDl7vuKxLlQ0o8MyYwnE768B5OqLBcBswr7nKTSc");
		//结算通知模板ID ( 收入提醒 )
		put("SEND_TEMPID_INCOME_DEV","OlimRb6wp1PlchVPC5TcL_6XYoLwY6Uxa1LcpwSkqlo");
		put("SEND_TEMPID_INCOME_PROD","I5XriN5o16tCqzqKmkem8JCi238sAazUOHeYioo0TxM");
		//退款通知模板ID ( 退款通知 )
		put("SEND_TEMPID_REFUND_DEV","o1T531eNBAvccoD7Q6rGWb2RpsJZK_CbegQFfjwyrnQ");
		put("SEND_TEMPID_REFUND_PROD","Ag0nILAXvrddAH09KXHSQZI5xeNT3uHjO4dHROHyPhw");
		//操作提醒模板ID ( 操作提醒 )
		put("SEND_TEMPID_OPERATE_DEV","B0f43kAEHVduSo3pF5YHW4BtTm-NTRoichRccMdhXBI");
		put("SEND_TEMPID_OPERATE_PROD","o_STUnzFf43HHKYi3wKP8A4XPUOBXZOkd2R7gM-yBbc");
		//统计提醒模板ID ( 历史报告通知 )
		put("SEND_TEMPID_STATISTICS_DEV","T-X82Owtqpgybm270rq47J2fSOPBvAxIQHADs6SqeU4");
		put("SEND_TEMPID_STATISTICS_PROD","xgQh5N3qzJoFh1ziUXYg0QwDaJ7NvVk7evq9NURo5ho");
		//E答教育购买成功通知ID
		put("SEND_TEMPID_PAID_DEV","kaQuITHmCU9PnfGXn7ag7LnSRX1-94e903QkMTeW0Jw");
		put("SEND_TEMPID_PAID_PROD","FkEWXVTgeYOjW7nw0mbpG2EoVyS6pK_35AirN_r1RAE");

	}};
	
	//用户提问通知头
	public static String TEMPLATE_QST_FIRST = "%1s很仰慕你，并向你扔了一个问题。";
	//用户提问通知尾
	public static String TEMPLATE_QST_REMARK = "速去回答这个价值￥ %1s的问题。";
	//用户提问通知尾2
	public static String TEMPLATE_QST_REMARK2 = "速去回答这个问题吧。";
	//收到回复通知头
	public static String TEMPLATE_ASWED_FIRST = "%1s稳稳地接住了你的问题";
	//收到回复通知尾
	public static String TEMPLATE_ASWED_REMARK = "速去查看详情。";
	//退款通知头
	public static String TEMPLATE_REFUND_FIRST = "%1s躲过了你的问题，并把钱稳稳地还给了你。";
	//退款通知尾
	public static String TEMPLATE_REFUND_REMARK = "速去查看详情。";
	//操作提醒通知头(问题即将过期提醒)
	public static String TEMPLATE_REMIND_FIRST = "%1s,待你回答的问题即将过期。";
	//操作提醒通知内容模板(问题即将过期提醒)
	public static String TEMPLATE_REMIND_TEXT = "\"%1s\"，还有%2s小时过期。";
	//操作提醒通知尾(问题即将过期提醒)
	public static String TEMPLATE_REMIND_REMARK = "速去查看详情。";
	//操作提醒通知头(讨论组发布新公告后提醒)
	public static String TEMPLATE_REMIND_FIRST2 = "讨论组公告";
	//操作提醒通知内容模板(讨论组发布新公告后提醒)
	public static String TEMPLATE_REMIND_TEXT2 = "%1s，你关注的讨论组发布了新的公告";
	//操作提醒通知尾(讨论组发布新公告后提醒)
	public static String TEMPLATE_REMIND_REMARK2 = "速去查看详情。";
	//统计提醒通知头
	public static String TEMPID_STATISTICS_FIRST= "尊敬的领导，您好[E答]近期统计详情，第一手掌握。";
	//统计提醒通知尾
	public static String TEMPID_STATISTICS_REMARK = "速去查看近7天详情。";

	//结算通知模板
	public static String TEMPLATE_INCOME = "恭喜你今日领取“E答”收益 %1s 元,已自动入库微信钱包。 \n其中，\n本日回答问题收益 %2s元, \n答主偷听收益: %3s元, \n提问偷听收益: %4s元，\n版权收益:%5s元，\n分享收益:%6s元。(每天领取，躺着获得“睡”后收入)";
	
	public static String TEMPLATE_STATEMENT = " 恭喜你今日领取“E答”收益 %1s,已自动入库微信钱包 \n 结算时间段：%2s \n 总额： %3s \n 截至目前，你的“E答”总收入： \n %4s，总收益： %5s，"
			+ "已领取：%6s,代领取：%7s\n (收入90%归你，每夜领取，躺着获得“睡”后收入)";
	
	// 七牛
	final static public String QINIU_ACCESS_KEY = "YKeYlVVp_V3o3lOnC1f_f8qdifY22-nOrQVUP9pI";
	// 七牛
	final static public String QINIU_SECRET_KEY = "_8YPOxTPFeCDMH0MYBw7gaj1b-5TiyQNL1sSOw2U";
	// 七牛语音问答存储空间
	final static public String publicBucketname = "y1da";
	// 未使用
	final static public String privateBucketname = "y1da-private";
	// 七牛静态资源存储空间
	final static public String publicResourceBucket = "y1da-resource";
	// 七牛MSC文字转语音存储空间
	final static public String publicMscBucket = "y1da-msc-t2v";
	// 七牛语音转换通道
	final static public String publicPipeline = "y1da-pipeline";
	//讨论组附件空间
	final static public String publicAcsResBucket = "y1da-test";
	// 各个bucket公开url
	final static public String publicUrl = "http://qnyd-prod.y1da.com";
	final static public String privateUrl = "http://7xw1zz.com1.z0.glb.clouddn.com";
	//静态资源用的url
	final static public String publicResourceUrl = "http://qnyd-resource.y1da.com";
	// MSC资源用的url
	final static public String publicMscUrl = "http://qnyd-msct2v.y1da.com";
	//图片资源用的url
	final static public String devPublicUrl = "http://qiniu-yida-test.myecare.cn";
	//讨论组附件用的url
	final static public String publicAcsResUrl = "http://qiniu-yida-test.myecare.cn";
	// 私有图片获取过期默认时间（秒）
	final static public long tokenFailedSec = 3600;
	// 图片上传校验图片大小默认值 b （2m）
	final static public long checkFileLong = 1024 * 1024 * 2;
	
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
	
	
	//客服登录名
	final static public String CS_NAME = "cs001";
	//客服登录密码
	final static public String CS_PWD = "b01f6c9f53b211e6817300163e010f1e";
	
	// 高德地图
	public static final String GAODE_KEY = "cf0e7ec69e8c895f0f1d19cc18e86e9a";
	// POI类型 综合医院和专科医院（查询医院所用的type）
	public static final String GAODE_SEARCH_TYPES = "0901|0902"; 

	public static final String GAODE_REGEO_URL = "http://restapi.amap.com/v3/geocode/regeo?output=json&key="+ Constants.GAODE_KEY +"&location=%1s,%2s";

	
	// word导出模板保存地址
	public static final String HRULE_TEMPLATE_FILE = "hrule_template.xml";



	
	/**
	 * 正式版
	 * 杨辉  ox705w5qQKiz2AexU2FzKqS4ut20
	 * 小叶 ox705w9NizhZf2AErFPPvQKE0V0o
	 * 雷 ox705w-elrOdC8-M0_0SFlKIKFaA
	 * 支青 ox705wzfv9-55j6VfzEfQPGa8qfQ
	 */
	public static String[] BD_MANAGER_UOPID_PROD= new String[]{
			"ox705w5qQKiz2AexU2FzKqS4ut20",
			"ox705w9NizhZf2AErFPPvQKE0V0o",
			"ox705w-elrOdC8-M0_0SFlKIKFaA",
			"ox705wzfv9-55j6VfzEfQPGa8qfQ",
	};
	/**
	 * 测试版
	 * KEI o_NcwwV1sbC2dJWz4CFiAGhZTflQ
	 * 刘能 o_NcwwVGd3rDEJ_t67Ua7UPbUqmg
	 * 天勤 o_NcwwW1CZtNMXfMSZKyMjrt4Zi4
	 * 
	 */
	public static String[] BD_MANAGER_UOPID_DEV= new String[]{
			"o_NcwwVGd3rDEJ_t67Ua7UPbUqmg",
	};
	
	//  护士三基考试模拟（全国通用） 考试通用规则
	public static final String EXAM_GLOBAL_HRUID1 = "8B4B59FAACB511E6B63B00163E02331A";
	//  护士执业考试模拟（全国通用）考试规则
	//TODO 要替换，执业考试没有上线，不需要该ID，况且数据库中没有该ID
	public static final String EXAM_GLOBAL_URUID2 = "A3349D7ADE2D11E6B63B00163E02331A";
	//  职称考试书库（护师）全套购买，书的sbuidstr
	public static final String SXAM_BOOK__PACKAGE_UUID = "4CADF4F7148E11E7AEFB00163E0A0015";
	//  职称考试书库（护师）全套购买，价格
	public static final String SXAM_BOOK_PACKAGE_PRICE = "11000";
	
	
	public static List<Map<String, Object>> uopidsConstants() {
		List<Map<String, Object>> resultList=new ArrayList<>();
		Map<String, Object> map1=new HashMap<>();
		map1.put("name","杨辉");
		map1.put("uopid","ox705w5qQKiz2AexU2FzKqS4ut20");
		Map<String, Object> map2=new HashMap<>();
		map2.put("name","小叶");
		map2.put("uopid","ox705w9NizhZf2AErFPPvQKE0V0o");
		
		Map<String, Object> map3=new HashMap<>();
		map3.put("name","雷");
		map3.put("uopid","ox705w-elrOdC8-M0_0SFlKIKFaA");
		
		Map<String, Object> map4=new HashMap<>();
		map4.put("name","支青");
		map4.put("uopid","ox705wzfv9-55j6VfzEfQPGa8qfQ");
		resultList.add(map1);
		resultList.add(map2);
		resultList.add(map3);
		resultList.add(map4);
		return resultList;
	}
	
	public static final String PUSH_TEXT_URL = "http://www.myecare.cn/oauth?p=statis1";
	
}
