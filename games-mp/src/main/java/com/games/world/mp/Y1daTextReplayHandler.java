package com.games.world.mp;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.games.world.mp.message.HelpArticle;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTransferCustomerServiceMessage;

public class Y1daTextReplayHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daTextReplayHandler.class);
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>CustomerServiceHandler-handle-start");
		
		if("答主".equals(wxMessage.getContent())){
			WxMpXmlOutNewsMessage news = WxMpXmlOutNewsMessage
					.NEWS()
					.addArticle(HelpArticle.getHelpArticle2())
					.fromUser(wxMessage.getToUserName())
					.toUser(wxMessage.getFromUserName())
					.build();
			log.debug(">>>>>Y1daTextReplayHandler 答主");
			return news;
		}
		
		if("偷听".equals(wxMessage.getContent())){
			WxMpXmlOutNewsMessage news = WxMpXmlOutNewsMessage
					.NEWS()
					.addArticle(HelpArticle.getHelpArticle4())
					.fromUser(wxMessage.getToUserName())
					.toUser(wxMessage.getFromUserName())
					.build();
			log.debug(">>>>>Y1daTextReplayHandler 偷听");
			return news;
		}
		if("推荐有奖".equals(wxMessage.getContent())){
			RestTemplate restTemplate = new RestTemplate();
			try{
				String result = restTemplate.getForObject( Constants.domain + "/wxInviteImagePush?uopid=" + wxMessage.getFromUserName().toString(), String.class);
				log.debug("result:{}", result);
			}catch(Exception e){
			}
			log.debug(">>>>>Y1daTextReplayHandler 推荐有奖");
			return null;
		}
		//##############################################
		//  以下统一处理文本消息
		//##############################################
		@SuppressWarnings("serial") 
		Map<String, String> contentMap = new HashMap<String,String>(){{
			// 教育用关键字模板
			put("芝麻开门","1. <a href=\"" + Constants.domain + "/statis\">E答整体统计</a>\n\n2. <a href=\"" + Constants.domain + "/oauth?p=statis0\">教育统计</a>\n\n3. <a href=\"" + Constants.domain + "/oauth?p=mkt\">答主入驻板块</a>\n\n4. <a href=\"" + Constants.domain + "/oauth?p=edufcpn\">免费送书</a>\n\n");
			put("题库","请点击“进入E答”，随后在页面中点击“教育”，即可看到购买页面，购买支付成功后即可复习题目了 ");
			put("习题集","<a href=\"" + Constants.domain  + "/oauth?p=edu00\">试题集</a>");
			put("试题集","<a href=\"" + Constants.domain  + "/oauth?p=edu00\">试题集</a>");
			put("妇科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=5\">妇科试题集</a>");
			put("儿科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=6\">儿科试题集</a>");
			put("中医","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=27\">中医科试题集</a>");
			put("中医科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=27\">中医科试题集</a>");
			put("心内","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=23\">心内科试题集</a>");
			put("心内科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=23\">心内科试题集</a>");
			put("icu","<a href=\"" + Constants.domain  + "/oauth?p=edu04_28&ebid=28\">急危重症护理学题库全集</a>\n<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=8\">急危重症护理知识试题集2016版</a>");
			put("ICU","<a href=\"" + Constants.domain  + "/oauth?p=edu04_28&ebid=28\">急危重症护理学题库全集</a>\n<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=8\">急危重症护理知识试题集2016版</a>");
			put("普外","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=19\">普外科试题集</a>");
			put("普外科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=19\">普外科试题集</a>");
			put("耳鼻喉","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=24\">耳鼻喉及口腔科试题集</a>");
			put("耳鼻喉科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=24\">耳鼻喉及口腔科试题集</a>");
			put("呼吸","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=7\">呼吸内科试题集</a>");
			put("呼吸内","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=7\">呼吸内科试题集</a>");
			put("呼吸内科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=7\">呼吸内科试题集</a>");
			put("眼科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=2\">眼科试题集</a>");
			put("骨科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=3\">骨科试题集</a>");
			put("内分泌","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=4\">内分泌试题集</a>");
			put("内分泌科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=4\">内分泌试题集</a>");
			put("消化","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=9\">消化内科试题集</a>");
			put("消化内","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=9\">消化内科试题集</a>");
			put("消化内科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=9\">消化内科试题集</a>");
			put("神经科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=10\">神经内科试题集</a>\n<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=26\">神经外科试题集</a>");
			put("神经","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=10\">神经内科试题集</a>\n<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=26\">神经外科试题集</a>");
			put("神经内","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=10\">神经内科试题集</a>");
			put("神经内科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=10\">神经内科试题集</a>");
			put("神经外科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=26\">神经外科试题集</a>");
			put("泌尿","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=11\">泌尿外科试题集</a>");
			put("泌尿外","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=11\">泌尿外科试题集</a>");
			put("泌尿外科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=11\">泌尿外科试题集</a>");
			put("胸外","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=12\">心胸外科试题集</a>");
			put("胸外科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=12\">心胸外科试题集</a>");
			put("心外","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=12\">心胸外科试题集</a>");
			put("心外科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=12\">心胸外科试题集</a>");
			put("心胸外科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=12\">心胸外科试题集</a>");
			put("康复","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=13\">康复科试题集</a>");
			put("康复科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=13\">康复科试题集</a>");
			put("肿瘤","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=14\">肿瘤科试题集</a>");
			put("肿瘤科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=14\">肿瘤科试题集</a>");
			put("肾内","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=15\">肾内科试题集</a>");
			put("肾内科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=15\">肾内科试题集</a>");
			put("皮肤","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=16\">皮肤科试题集</a>");
			put("皮肤科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=16\">皮肤科试题集</a>");
			put("精神","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=17\">精神科试题集</a>");
			put("精神科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=17\">精神科试题集</a>");
			put("感染","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=18\">感染科试题集</a>");
			put("感染科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=18\">感染科试题集</a>");
			put("消毒","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=20\">消毒供应室专科试题集</a>");
			put("消毒供应室专科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=20\">消毒供应室专科试题集</a>");
			put("糖尿病","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=21\">糖尿病专科试题集</a>");
			put("糖尿病专科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=21\">糖尿病专科试题集</a>");
			put("静脉输液","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=22\">静脉输液专科试题集</a>");
			put("静脉输液科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=22\">静脉输液专科试题集</a>");
			put("静脉输液专科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=22\">静脉输液专科试题集</a>");
			put("老年","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=25\">老年专科试题集</a>");
			put("老年专科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=25\">老年专科试题集</a>");
			put("急危重症","<a href=\"" + Constants.domain  + "/oauth?p=edu04_28&ebid=28\">急危重症护理学题库全集</a>\n<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=8\">急危重症护理知识试题集2016版</a>");
			put("风湿免疫","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=29\">风湿免疫科试题集</a>");
			put("风湿免疫科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=29\">风湿免疫科试题集</a>");
			put("产科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=30\">产科试题集</a>");
			put("性病","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=31\">皮肤性病科试题集</a>");
			put("皮肤性病","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=31\">皮肤性病科试题集</a>");
			put("皮肤性病科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=31\">皮肤性病科试题集</a>");
			put("烧伤","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=32\">烧伤外科试题集</a>");
			put("烧伤外科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=32\">烧伤外科试题集</a>");
			put("营养","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=33\">营养科试题集</a>");
			put("营养科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=33\">营养科试题集</a>");
			put("医学影像","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=34\">医学影像科试题集</a>");
			put("肛肠","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=35\">肛肠科试题集</a>");
			put("肛肠科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=35\">肛肠科试题集</a>");
			put("口腔","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=36\">口腔科护理知识试题集2016版</a>\n<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=24\">耳鼻喉及口腔科试题集</a>");
			put("口腔科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=36\">口腔科护理知识试题集2016版</a>\n<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=24\">耳鼻喉及口腔科试题集</a>");
			put("手术室","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=37\">手术室科试题集</a>");
			put("手术室科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=37\">手术室科试题集</a>");
			put("麻醉","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=38\">麻醉科试题集</a>");
			put("麻醉科","<a href=\"" + Constants.domain  + "/oauth?p=edu01&ebid=38\">麻醉科试题集</a>");
			
			// 三基考试用模板
			
			put("三基","<a href=\"" + Constants.domain  + "/oauth?p=exrm01\">三基考试</a>");
			put("三基考","<a href=\"" + Constants.domain  + "/oauth?p=exrm01\">三基考试</a>");
			put("三基考试","<a href=\"" + Constants.domain  + "/oauth?p=exrm01\">三基考试</a>");
			put("三基模拟","<a href=\"" + Constants.domain  + "/oauth?p=exam00\">三基模拟考试</a>");
			
			// 题库上传
			put("上传题库","<a href=\"" + Constants.domain + "/oauth?p=upex00\">戳我</a>");
		}};


		if(contentMap.containsKey(wxMessage.getContent())){
			WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content(contentMap.get(wxMessage.getContent())).fromUser(wxMessage.getToUserName())
					.toUser(wxMessage.getFromUserName()).build();
			log.debug(">>>>>CustomerServiceHandler-handle-end:"+m);
			return m;
		}else{
			//客服消息转发至微信服务器，微信服务器会把这次发送的消息转到多客服系统。
			WxMpXmlOutTransferCustomerServiceMessage m = WxMpXmlOutTransferCustomerServiceMessage.TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUserName())
					.toUser(wxMessage.getFromUserName()).build();
			
			log.debug(">>>>>CustomerServiceHandler-handle-end:"+m);
			return m;
		}
	}
}