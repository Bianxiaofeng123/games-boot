package com.games.world.mp.message;

public class WelcomeText {
	
	public static String getWelcomeText(String domain){
		
//		String newUrl = "http://mp.weixin.qq.com/s?__biz=MzI3NTM0MTI1NQ==&mid=100000107&idx=1&sn=523cb9b708b26b6eee2c5b9a9ae0bdb1";
		StringBuilder welcome = new StringBuilder();
//		welcome.append("欢迎来到 <a href=\"" + domain +"/oauth?userinfo=1\">[ E答 ]  </a> !\n");
//		welcome.append("[e答]是付费语音健康知识分享平台，你【问】我【答】，有人“偷听”，你我收入平分，知名专家在线分享知识、经验、建议...\n\n");
//		welcome.append("1. 成为答主，<a href=\"" + domain  + "/oauth?p=mine&userinfo=1\">请点击此处</a>，或回复“答主”了解操作详情\n");
//		welcome.append("2. 我要提问，<a href=\"" + domain  + "/oauth?p=doccate\">请点击此处</a> 或回复“提问”了解操作详情\n");
//		welcome.append("3. 我要偷听，<a href=\"" + domain  + "/oauth?p=dochot&userinfo=1\">请点击此处</a>\n");
//		welcome.append("4. 新书上架丨购买各科护理试题集，<a href=\"" + domain  + "/oauth?p=edu00\"> 请点击此处</a>\n\n");
//		welcome.append("点击以下语音，体验你的第一次“偷听”↓↓↓↓、");
		
		welcome.append("<a href=\"" + domain +"/oauth?userinfo=1\"> [E答] </a> 可等到您了😘 ！\n\n");
//		welcome.append("[E答] 是 医护专业及健康知识互动平台。有海量知名医学，护理专家助您提升专业能力，解疑答惑！！！\n");
		welcome.append("我猜您需要：\n");
		welcome.append(" 1. <a href=\"" + domain + "/oauth?p=exrm01\">护士三基考试</a>\n");
		welcome.append(" 2. <a href=\"" + domain + "/oauth?p=sxam01\">护师考试(职称考试)</a>\n");
		welcome.append(" 3. <a href=\"" + domain + "/oauth?p=edu00\">临床护士用书</a>\n");
		welcome.append(" 4. <a href=\"" + domain + "/oauth?p=dochot\">专家在线答疑</a>\n");
		welcome.append("\n试试回复科室，如：儿科、急危重症、三基\n");
		welcome.append("\n小秘密：分享下图，好友购书就返利哦\n");
		return welcome.toString();
	}
	
	public static String getPurchaseInvitationText(String domain, String url){
		StringBuilder welcome = new StringBuilder();
		welcome.append("三基考试用书为您考试保驾护航 <a href=\"" + domain  + url + "\">请点击此处</a>\n");
		return welcome.toString();
	}
	
	public static String getEdubookIdText(String domain, String url){
		StringBuilder welcome = new StringBuilder();
		welcome.append("欢迎您加入“E答教育分享计划”，<a href=\"" + domain  + url + "\">进入图书详情页面</a>\n");
		return welcome.toString();
	}
	
	public static String getEdubookdt(String domain, String url){
		StringBuilder welcome = new StringBuilder();
		welcome.append("购买图书，<a href=\"" + domain  + url + "\">进入图书详情页面</a>\n");
		return welcome.toString();
	}
	
	public static String getEdubookshop(String domain, String url){
		StringBuilder welcome = new StringBuilder();
		welcome.append("购买图书，<a href=\"" + domain  + url + "\">进入图书详情页面</a>\n");
		return welcome.toString();
	}
}
