package com.games.world.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.games.world.model.JsonResult;
import com.games.world.util.QiNiuUtils;

@Controller
@RequestMapping(value = "/")
public class UploadController {
	

	/**
	 * @author mas
	 * 头像上传
	 * /assis/location/portait/upload
	 * @param file name:uploadfile values:??
	 * return 
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST) 
	public JsonResult uploadFile(@RequestHeader HttpHeaders httpHeaders,@RequestParam("uploadfile") MultipartFile uploadfile
			) throws Exception {
		JsonResult r = new JsonResult();
		Map<String, Object> result = new HashMap<>();
		String imgKeys=null;
		String imgkey=null;
		String imgUrl=null;
		try {
			imgKeys = QiNiuUtils.uploadPublic(uploadfile.getBytes(), false);
			imgkey = QiNiuUtils.getValByKey4Str(imgKeys, "key");
			imgUrl = QiNiuUtils.getPublicPath(imgkey);
		} catch (Exception e) {
			throw new Exception("提交失败");
		}
		result.put("imgurl", imgUrl);
		result.put("imgkey", imgkey);
		System.out.println(result);
		return r;
	}

}
