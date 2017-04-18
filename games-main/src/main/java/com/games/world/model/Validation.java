package com.games.world.model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.util.StringUtils;

import com.games.world.util.ConvertDateTime;
public class Validation {
	private final static Logger log = LoggerFactory.getLogger(Validation.class);
	
	public static void main(String[] args){
		
		@SuppressWarnings({ "unused", "serial" })
		Map<String,Object> params = new HashMap<String,Object>(){{
			put("limit", "1");
			put("start", 1);
		}};
		StringBuffer errMsg = new StringBuffer();
		log.debug("errMsg:{}", errMsg);
		
	}
	public static Boolean checkBlank(Map<String,Object> params, String... fields){
		Boolean result = true;
		for(String field: fields){
			log.debug("contains:{}", params.containsKey(field) );
			if (!params.containsKey(field)){
				result = false;
				break;
			}
			if (params.get(field) == null){
				result = false;
				break;
			}
			if (StringUtils.isEmpty(params.get(field))){
				result = false;
				break;
			}
		}
		return result;
	}
	public static Boolean checkBlank(Map<String,Object> params, StringBuffer errMsg, MessageSource messageSource, String... fields){
		Boolean result = true;
		for(String field: fields){
//			log.debug("contains:{}", params.containsKey(field) );
			String desc = messageSource.getMessage(field, null, null);
			if (!params.containsKey(field)){
				errMsg.append(desc + " 必填 ; ");
				result = false;
				continue;
			}
			if (params.get(field) == null||params.get(field).equals("null")){
				errMsg.append(desc + " 不能为空; ");
				result = false;
				continue;
			}
			if (StringUtils.isEmpty(params.get(field))){
				errMsg.append(desc + " 不能为空字符; ");
				result = false;
				continue;
			}
		}
		return result;
	}
	
	 
	public static Boolean checkInteger(Map<String,Object> params, StringBuffer errMsg, MessageSource messageSource, String... fields){
		Boolean result = true;
		for(String field: fields){
			if (!params.containsKey(field)){
				continue;
			}
			String desc = messageSource.getMessage(field, null, null);
			try {
		        String value = params.get(field).toString();
		        Integer.parseInt(value);
		    } catch (NumberFormatException e) {
		    	result = false;
		    	errMsg.append(desc + " 非数字; ");
		    }
		}
		return result;
	}
	public static Boolean checkInteger(Map<String,Object> params, StringBuffer errMsg, MessageSource messageSource, String field, int min, int max){
		Boolean result = true;
		String desc = messageSource.getMessage(field, null, null);
		if (!params.containsKey(field)){
			errMsg.append(desc + " 不能为空; ");
			result = false;
		}
		if (params.get(field) == null){
			errMsg.append(desc + " 不能为空; ");
			result = false;
		}
		
		try{
			Integer value = Integer.parseInt(params.get(field).toString());
			if (value < min || value > max){
				errMsg.append(desc + "必须满足范围: (" + min + "," + max + ")");
				result = false;
			}
		}catch(Exception e){
			errMsg.append(desc + "必须满足范围: (" + min + "," + max + ")");
			result =false;
		}
		return result;
	}
	
	public static Boolean checkLength(Map<String,Object> params, StringBuffer errMsg, MessageSource messageSource, String field, int min, int max){
		Boolean result = true;
		String desc = messageSource.getMessage(field, null, null);
		if (!params.containsKey(field)){
			errMsg.append(desc + " 不能为空; ");
			result = false;
		}
		if (params.get(field) == null){
			errMsg.append(desc + " 不能为空; ");
			result = false;
		}
		
		String value = params.get(field).toString();
		if (value.length() < min || value.length() > max){
			errMsg.append(desc + " 长度必须满足范围: [" + min + "," + max + "]");
			result = false;
		}
		return result;
	}
	
	public static Boolean checkTimeAfterNow(Map<String, Object> params, StringBuffer errMsg, MessageSource messageSource,
			String field) throws Exception {
		Boolean result = true;
		String desc = messageSource.getMessage(field, null, null);
		if (!params.containsKey(field)) {
			errMsg.append(desc + " 不能为空; ");
			result = false;
		}
		if (params.get(field) == null) {
			errMsg.append(desc + " 不能为空; ");
			result = false;
		}

		String value = params.get(field).toString();
		String pattern = "^([\\d]{4}-[\\d]{1,2}-[\\d]{1,2} [\\d]{1,2}:[\\d]{1,2})$";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(value);
		if (!m.find()) {
			errMsg.append(desc + " 时间格式为: [" + ConvertDateTime.getCurrentTimeNow2() + "]");
			result = false;
			return result;
		}
		Seconds seconds = Seconds.secondsBetween(
				ConvertDateTime.dateFormatStrToTime(ConvertDateTime.FORMAT_YMDHM_DATETIME_EN, value), 
				ConvertDateTime.getCurTime());
		if(seconds.getSeconds() > 0){
			errMsg.append(desc + " 必须大于当前时间");
			result = false;
		}
		return result;
	}
	public static Boolean checkTimeFromTo(Map<String, Object> params, StringBuffer errMsg, MessageSource messageSource,
			String field1, String field2) throws Exception {
		Boolean result = true;
		String desc1 = messageSource.getMessage(field1, null, null);
		String desc2 = messageSource.getMessage(field2, null, null);
		String value1 = params.get(field1).toString();
		String value2 = params.get(field2).toString();
		Seconds seconds = Seconds.secondsBetween(
				ConvertDateTime.dateFormatStrToTime(ConvertDateTime.FORMAT_YMDHM_DATETIME_EN, value1), 
				ConvertDateTime.dateFormatStrToTime(ConvertDateTime.FORMAT_YMDHM_DATETIME_EN, value2));
		if(seconds.getSeconds() <= 0){
			errMsg.append(desc2 + " 必须大于 " + desc1 );
			result = false;
		}
		return result;
	}
	
	public static Boolean checkDate(Map<String, Object> params, StringBuffer errMsg, MessageSource messageSource,
			 String field)throws Exception{
		Boolean result = true;
		String desc = messageSource.getMessage(field, null, null);
		String datestr = params.get(field).toString();
		DateTimeFormatter df = DateTimeFormat.forPattern(ConvertDateTime.SERIAL_YMDHM_DATETIME);
		try{
			DateTime dateFormatTime = DateTime.parse( datestr, df);
			System.out.println(datestr );
			System.out.println(dateFormatTime);
		}catch(Exception ex){
			result = false;
			errMsg.append(desc + " 格式错误");  
		}       
		  
		return result;
	}
	
}
