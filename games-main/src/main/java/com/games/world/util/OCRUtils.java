package com.games.world.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.games.world.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class OCRUtils {
	
	/**
	 * 解析图片文字信息 正确率大概在60%
	 * @author fengfeng
	 * @param picurl
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> Transform(String phurl) throws Exception {
		// 初始化一个OcrClient
		AipOcr client = new AipOcr(Constants.BAIDU_OCR_APP_ID, Constants.BAIDU_OCR_API_KEY,
				Constants.BAIDU_OCR_SECRET_KEY);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		// 自定义参数定义
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("detect_direction", Constants.BAIDU_OCR_DETECT_DIRECTION);
		options.put("language_type", Constants.BAIDU_OCR_LANGUAGE_TYPE);
		// new一个URL对象
		URL url = new URL(phurl);
		// 打开链接
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置请求方式为"GET"
		conn.setRequestMethod("GET");
		// 超时响应时间为5秒
		conn.setConnectTimeout(5 * 1000);
		// 通过输入流获取图片数据
		InputStream inStream = conn.getInputStream();
		// 得到图片的二进制数据，以二进制封装得到数据，具有通用性
		byte[] data = readInputStream(inStream);
		JSONObject response = client.general(data, options);
		// 转换list
		Gson gson = new Gson();
		Map<String, Object> TEXTMap = gson.fromJson(response.toString(), new TypeToken<Map<String, Object>>() {
		}.getType());
		return TEXTMap;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		// 每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		// 使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		// 关闭输入流
		inStream.close();
		// 把outStream里的数据写入内存
		return outStream.toByteArray();
	}
}
