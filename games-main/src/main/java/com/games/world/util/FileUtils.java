package com.games.world.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUtils {

	/**
	 * 保存文件到本地计算机
	 * 
	 * @author fengfeng
	 * @param picurl
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static void Fail(File file, String name, String format) throws Exception {
		// 这是你要保存之后的文件，是自定义的，本身不存在
		File afterfile = new File("d://" + name + "." + format);

		// 定义文件输入流，用来读取beforefile文件
		FileInputStream fis = new FileInputStream(file);

		// 定义文件输出流，用来把信息写入afterfile文件中
		FileOutputStream fos = new FileOutputStream(afterfile);

		// 文件缓存区
		byte[] b = new byte[1024];
		// 将文件流信息读取文件缓存区，如果读取结果不为-1就代表文件没有读取完毕，反之已经读取完毕
		while (fis.read(b) != -1) {
			// 将缓存区中的内容写到afterfile文件中
			fos.write(b);
			fos.flush();
		}
	}

	/**
	 * 保存图片到本地
	 * 
	 * @author fengfeng
	 * @param picurl
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static void Fail(String phurl, String name) throws Exception {
		try {
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

			// 这是你要保存之后的文件，是自定义的，本身不存在
			File afterfile = new File("d://" + name + "." + "jpg");

			// 定义文件输入流，用来读取beforefile文件
			//强制类型转换
			FileInputStream fis = (FileInputStream) (inStream);

			// 定义文件输出流，用来把信息写入afterfile文件中

			FileOutputStream fos = new FileOutputStream(afterfile);

			// 文件缓存区
			byte[] b = new byte[1024];
			// 将文件流信息读取文件缓存区，如果读取结果不为-1就代表文件没有读取完毕，反之已经读取完毕
			while (fis.read(b) != -1) {
				// 将缓存区中的内容写到afterfile文件中
				fos.write(b);
				fos.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
