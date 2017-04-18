package com.games.world.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.games.world.model.Validation;
import com.games.world.service.UsrService;

/**
 * 职称考试
 *
 */
@RestController
@RequestMapping(value = "/usr")
public class UsrController {
	
	@Autowired
	UsrService usrService;
	
	@Autowired
	MessageSource messageSource;
	
	/**
	 * 查询题库章节列表
	 * @param parmas
	 * @param pager
	 * @return
	 */
	@RequestMapping(value = "/chapters", method = RequestMethod.GET)
	public Map<String, Object> chapters(@RequestParam Map<String, Object> parmas){
		StringBuffer errMsg = new StringBuffer();
		if(!Validation.checkBlank(parmas, errMsg, messageSource, "uopid")){
			throw new IllegalArgumentException(errMsg.toString());
		}
		return usrService.login(parmas);
	}
		
	
}
