package com.games.world.mp.message;

import me.chanjar.weixin.mp.bean.WxMpCustomMessage.WxArticle;

public class HelpArticle2 {

	public static WxArticle getHelpArticle1() {
		WxArticle item1 = new WxArticle();
		item1.setTitle("购书指南");
		item1.setPicUrl("http://qnyd-resource.y1da.com/y1da_edu_welcome02.jpg");
		item1.setUrl("http://w.url.cn/s/AJZ3TNm");
		return item1;
	}
	
	public static WxArticle getHelpArticle2() {
		WxArticle item2 = new WxArticle();
		item2.setTitle("怎么成为答主");
		item2.setPicUrl("http://qnyd-prod.y1da.com/to_answer2.jpg");
		item2.setUrl("http://w.url.cn/s/AVlLffO");
		return item2;
	}

	public static WxArticle getHelpArticle3() {
		WxArticle item3 = new WxArticle();
		item3.setTitle("怎么设置问题");
		item3.setPicUrl("http://mmbiz.qpic.cn/mmbiz/mMw2iabCRQUE8Yu9lgmM6F4icibHOXFQTTzia5OuveeAia56YptibOhRCnFjJy6PMqJspLssY6A0JotPbJf8icCrphtZg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1");
		item3.setUrl("http://w.url.cn/s/AXhXjls");
		return item3;
	}

	public static WxArticle getHelpArticle4() {
		WxArticle item4 = new WxArticle();
		item4.setTitle("如何让更多的人“偷听”呢");
		item4.setPicUrl("http://qnyd-prod.y1da.com/to_listen.jpg");
		item4.setUrl("http://w.url.cn/s/AGLapc1");
		return item4;
	}
	
	public static WxArticle getHelpArticle5() {
		WxArticle item2 = new WxArticle();
		item2.setTitle("E答教育");
		item2.setPicUrl(
				"http://qnyd-prod.y1da.com/to_answer2.jpg");
		item2.setUrl("http://w.url.cn/s/AVlLffO");
		return item2;
	}
}
