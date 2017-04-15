package com.games.world.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import com.games.world.Constants;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

public class QiNiuUtils {

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	// 创建上传对象
	static UploadManager uploadManager = new UploadManager();

	// 密钥配置
	final static Auth auth = Auth.create(Constants.QINIU_ACCESS_KEY, Constants.QINIU_SECRET_KEY);

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	private static String getUpToken(String bucketname) {
		return auth.uploadToken(bucketname);
		// (bucket, key) 覆盖上传
	}

	/*
	 * @param file 文件
	 * 
	 * @param isUpload2Private 是否需要上传至私有空间
	 */
	private static String upload(File file, boolean isUpload2Private, boolean isNeedCrc32) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			if (isNeedCrc32) {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname), null,
						null, true);
			} else {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname));
			}
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			throw new QiniuException(r);
		}
	}

	/*
	 * @param byte[]
	 * 
	 * @param isUpload2Private 是否需要上传至私有空间
	 */
	private static String upload(byte[] file, boolean isUpload2Private, boolean isNeedCrc32) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			if (isNeedCrc32) {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname), null,
						null, true);
			} else {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname));
			}
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			throw new QiniuException(r);
		}
	}

	private static boolean checkFileLenth(File file) throws IOException {
		if (file.length() > Constants.checkFileLong) {
			throw new IOException("文件不得大于2m");
		}
		return true;
	}

	private static boolean checkFileLenth(byte[] file) throws IOException {
		if (file.length > Constants.checkFileLong) {
			throw new IOException("文件不得大于2m");
		}
		return true;
	}

	/**
	 * 上传至公共空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPublic(File file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, false, isNeedCrc32);
	}

	/**
	 * 上传至私有空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPrivate(File file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, false, isNeedCrc32);
	}

	/**
	 * 上传至公共空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPublic(byte[] file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, false, isNeedCrc32);
	}

	/**
	 * 上传至私有空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPrivate(byte[] file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, false, isNeedCrc32);
	}
	
	/**
	 * 讨论组附件上传
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadAcsRes(byte[] file, boolean isNeedCrc32) throws Exception {
		return uploadFiles(file, false, isNeedCrc32);
	}
	public static String uploadAcsRes(byte[] file, String key, boolean isNeedCrc32) throws Exception {
		return uploadFiles(file, key, false, isNeedCrc32);
	}
	
	/*
	 * @param byte[]
	 * 
	 * @param isUpload2Private 是否需要上传至私有空间(讨论组附件上传)
	 */
	private static String uploadFiles(byte[] file, boolean isUpload2Private, boolean isNeedCrc32) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			res = uploadManager.put(file, null,
						getUpToken(Constants.publicAcsResBucket), null,
						null, true);
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			throw new QiniuException(r);
		}
	}
	
	private static String uploadFiles(byte[] file, String key, boolean isUpload2Private, boolean isNeedCrc32) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			res = uploadManager.put(file, key,
						getUpToken(Constants.publicAcsResBucket), null,
						null, true);
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			throw new QiniuException(r);
		}
	}
	
	/**
	 * 获取私有图片
	 * @param key  文件key
	 * @param invalidSec  失效时间(秒)
	 * @return url
	 */
	public static String getPublicAcsResPath(String key) throws Exception {
		return Constants.privateUrl + "/" + key;
	}

	/**
	 * 获取私有图片
	 * 
	 * @param key
	 *            文件key
	 * @param invalidSec
	 *            失效时间(秒)
	 * @return url
	 */
	public static String getPrivateFilePath(String key, long invalidSec) throws Exception {
		return auth.privateDownloadUrl(Constants.privateUrl + "/" + key, invalidSec);
	}

	/**
	 * 获取私有图片
	 * 
	 * @param key
	 *            文件key
	 * @param invalidSec
	 *            失效时间(秒)
	 * @return url
	 */
	public static String getPrivateFilePath(String key) throws Exception {
		return auth.privateDownloadUrl(Constants.privateUrl + "/" + key, Constants.tokenFailedSec);
	}

	/**
	 * 获取public图片
	 * 
	 * @param key
	 *            文件key
	 * @param invalidSec
	 *            失效时间(秒)
	 * @return url
	 */
	public static String getPublicPath(String key) throws Exception {
		return Constants.publicUrl + "/" + key;
	}

	/**
	 * 根据string 获取key值
	 * 
	 * @param str:
	 *            "{\"hash\":\"FoS4hOJm5EZSEXHaPuUs7HF8o4-g\",\"key\":\"FoS4hOJm5EZSEXHaPuUs7HF8o4-g\"}"
	 * @param key:
	 *            hash
	 * @return FoS4hOJm5EZSEXHaPuUs7HF8o4-g
	 */
	public static String getValByKey4Str(String str, String key) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> map = new Gson().fromJson(str, HashMap.class);
		return map.get(key);
	}

	public static String convertAmr2Mp3(String key) {
		// 新建一个OperationManager对象
		OperationManager operater = new OperationManager(auth);
		// 设置要转码的空间和key，并且这个key在你空间中存在
		String bucket = Constants.publicBucketname;
		// 设置转码操作参数
		String fops = "avthumb/mp4/ab/256k/ar/44100/acodec/libfaac";
		// 设置转码的队列
		// 可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
		String key2 = key + ".aac";
		String urlbase64 = UrlSafeBase64.encodeToString(Constants.publicBucketname + ":" + key2);
		String pfops = fops + "|saveas/" + urlbase64;

		// 设置pipeline参数
		StringMap params = new StringMap().putWhen("force", 1, true).putNotEmpty("pipeline", Constants.publicPipeline);
		try {
			String persistid = operater.pfop(bucket, key, pfops, params);
			// 打印返回的persistid
			return persistid;
		} catch (QiniuException e) {
			// 捕获异常信息
			Response r = e.response;
			// 请求失败时简单状态信息
			System.out.println(r.toString());
			try {
				// 响应的文本信息
				System.out.println(r.bodyString());
			} catch (QiniuException e1) {
				// ignore
			}
		}
		return "";
	}

	/**
	 * 提交到七牛带后缀(public)
	 * @param file
	 * @param mime
	 * @return
	 * @throws Exception
	 */
	public static String upload(String nm, byte[] file, String mime) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			res = uploadManager.put(file, nm, getUpToken(Constants.publicBucketname), null, mime, false);
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			e.printStackTrace();
			throw new QiniuException(r);
		}
	}
	
	public static void main(String[] args) {
		try {
			// System.out.println(uploadPublic(new
			// File("C:/Users/Administrator/Desktop/V60429-170742.mp4"),
			// false));
			// System.out.println(getPrivateFilePath("Fkq6SDqV0sJEYfuUW_QJTpC2IbCc"));
			for (int i = 0; i < 10000; i++)
				System.out.println(Base64.encodeBase64(UUID.randomUUID().toString().getBytes()).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
