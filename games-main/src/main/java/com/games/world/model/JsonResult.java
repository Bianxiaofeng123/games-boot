package com.games.world.model;

import java.util.HashMap;



public class JsonResult extends HashMap<String, Object>{

	private static final long serialVersionUID = 1L;
	final String SUCCESSCODE = "0";
	final String SUCCESSMSG = "ok";
	final String FAILEDCODE = "400";
	
	/**
	 * 返回结果集, 无记录条数, 和成功/错误信息+errCode
	 * @param object	结果集
	 * @param errCode
	 * @param errMsg	
	 * @return
	 */
	public JsonResult put(Object object, String errCode, String errMsg){
		super.put("result", object);
		super.put("errorCode", errCode);
		super.put("errorMessage", errMsg);
		return this;
	}
	
	/**
	 * 返回结果集, 带记录条数
	 * @param object	结果集
	 * @param num		总记录条数
	 * @return
	 */
	public JsonResult put(Object object , String num) {
		super.put("result", object);
		super.put("errorCode", SUCCESSCODE);
		super.put("total", num);
		return this;
	}
	
	/**
	 * 返回结果集, 无记录条数
	 * @param object	结果集
	 * @return
	 */
	public JsonResult put(Object object){
		super.put("result", object);
		super.put("errorCode", SUCCESSCODE);
		return this;
	}
	
	/**
	 * 返回成功/错误信息+errCode
	 * @param errMsg	结果集
	 * @param errCode	errorcode
	 * @return
	 */
	public JsonResult put(String errMsg, String errCode){
		super.put("errorCode", errCode);
		super.put("errorMessage", errMsg);
		return this;
	}
	
	/**
	 * 返回成功信息+errCode
	 * @param errMsg	结果集
	 * @param errCode	errorcode
	 * @return
	 */
	public JsonResult putSuccess(){
		super.put("errorCode", SUCCESSCODE);
		super.put("errorMessage", SUCCESSMSG);
		return this;
	}
	
	/**
	 * 返回失败信息+errCode
	 * @param errMsg	结果集
	 * @param errCode	errorcode
	 * @return
	 */
	public JsonResult putFailed(String errMsg){
		super.put("errorCode", FAILEDCODE);
		super.put("errorMessage", errMsg);
		return this;
	}
}
