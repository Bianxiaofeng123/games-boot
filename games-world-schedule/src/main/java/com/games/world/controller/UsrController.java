//package com.games.world.controller;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.games.world.model.JsonResult;
//import com.games.world.model.Validation;
//import com.games.world.service.UsrService;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 用户
// *
// */
//@Slf4j
//@RestController
//@RequestMapping(value = "/")
//public class UsrController {
//	
//	@Autowired
//	UsrService usrService;
//	
//	@Autowired
//	MessageSource messageSource;
//	
//	
//	
//	/**
//	 * 登录
//	 * @param parmas
//	 * @param pager
//	 * @return
//	 *//*
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public JsonResult login(@RequestParam Map<String, Object> parmas){
//		JsonResult jsonResult=new JsonResult();
//		StringBuffer errMsg = new StringBuffer();
//		if(!Validation.checkBlank(parmas, errMsg, messageSource, "username","password")){
//			throw new IllegalArgumentException(errMsg.toString());
//		}
//		Map<String, Object> loginMap=usrService.login(parmas);
//		if (usrService.login(parmas)!=null) {
//			jsonResult.put(loginMap);
//		}else {
//			jsonResult.putFailed("账号/密码错误");
//		}
//		return jsonResult;
//	}*/
//	/**
//	 * 测试
//	 * @param parmas
//	 * @param pager
//	 * @return
//	 */
//	@RequestMapping(value = "/text", method = RequestMethod.GET)
//	public JsonResult text(@RequestParam Map<String, Object> parmas) throws Exception{
//		log.info("parmas{}",parmas);
//		JsonResult jsonResult=new JsonResult();
//		String url=parmas.get("url").toString();
//		return jsonResult.put(url);
//	}
//	
//	/**
//	 * 测试
//	 * @param parmas
//	 * @param pager
//	 * @return
//	 */
//	@RequestMapping(value = "/usrs", method = RequestMethod.GET)
//	public String usrs(@RequestParam Map<String, Object> parmas){
//		log.info("parmas{}",parmas);
//		usrService.usrs();
//		return "ok";
//	}
//}
