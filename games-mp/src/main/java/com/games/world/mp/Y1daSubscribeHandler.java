package com.games.world.mp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.games.world.mp.message.WelcomeText;
import com.games.world.mp.utils.ComUtils;
import com.google.gson.Gson;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

public class Y1daSubscribeHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daSubscribeHandler.class);
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>Y1daSubscribeHandler-handle-start");
		Gson g = new Gson();
		System.out.println("[Y1daSubscribeHandler]>>>>wxMessage>>>>:"+ g.toJson(wxMessage));
		
		RestTemplate restTemplate = new RestTemplate();
		// 发送欢迎语
		WxMpCustomMessage textMessage = WxMpCustomMessage.TEXT().toUser(wxMessage.getFromUserName()).content(WelcomeText.getWelcomeText( Constants.domain )).build();
		try {
			wxMpService.customMessageSend(textMessage);
			log.debug(">>>>>1>>>>>>>");
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		
		
		
		//MP3欢迎词
//		try {
//			WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService().mediaUpload(
//					WxConsts.MASS_MSG_VOICE, WxConsts.FILE_MP3, ClassLoader.getSystemResourceAsStream("welcome.mp3"));
//			WxMpCustomMessage voidMessage = WxMpCustomMessage.VOICE().toUser(wxMessage.getFromUserName()).mediaId(wxMediaUploadResult.getMediaId()).build();
//			String result = restTemplate.getForObject( Constants.domain  + "/subscribe?uopid=" + wxMessage.getFromUserName()+ "&subscribe=1", String.class);
//			wxMpService.customMessageSend(voidMessage);
//			log.debug(">>>>>Y1daSubscribeHandler-handle-end: {}", result);
//		} catch (WxErrorException | IOException e) {
//			e.printStackTrace();
//		}
		
//		// 推送欢迎文章
//		WxMpCustomMessage  newsMessage = WxMpCustomMessage.NEWS().toUser(wxMessage.getFromUserName())
//				.addArticle(HelpArticle2.getHelpArticle1())
////				.addArticle(HelpArticle2.getHelpArticle2())
////				.addArticle(HelpArticle2.getHelpArticle3())
////				.addArticle(HelpArticle2.getHelpArticle4())
//				.build();
//		try {
//			wxMpService.customMessageSend(newsMessage);
//			log.debug(">>>>>2>>>>>>>");
//		} catch (WxErrorException e) {
//			e.printStackTrace();
//		}
		
		try{
			String result = restTemplate.getForObject( Constants.domain + "/wxInviteImagePush?uopid=" + wxMessage.getFromUserName().toString(), String.class);
			log.debug("result:{}", result);
			log.debug(">>>>>2>>>>>>>");
		}catch(Exception e){
			e.printStackTrace();
	    }
		
		//在未关注公众号的时候，则推送一条消息(url指向E答教育图书列表页面)。
		if(wxMessage.getEventKey().contains("qrscene_edupaid")){
			Map<String,String> eventKeyMap = ComUtils.unicodeParamstr2Map(wxMessage.getEventKey());
			log.debug(">>>>>Y1daSubscribeHandler eventKeyMap:{}" , eventKeyMap);
			String page = eventKeyMap.get("p");
			String fuopid = eventKeyMap.get("uopid");
			restTemplate.getForObject( Constants.domain  + "/sr?fopid=" + fuopid + "&ropid="+ wxMessage.getFromUserName()+ "&stype=3", String.class);

			if ("ox705w4Fp2S6c5250aG6zVozFd2A".equals(fuopid)){
				//针对458医院推送链接 做特别设置
				restTemplate.getForObject( Constants.domain  + "/coupon?uopid=" + wxMessage.getFromUserName().toString() + "&couponid=1084603", String.class);
				WxMpCustomMessage couponTextMessage = WxMpCustomMessage.TEXT().toUser(wxMessage.getFromUserName()).content("458医院的姐妹们：购买三基考试书籍<a href=\"" + Constants.domain +"/oauth?p=exbm00\">点这里（特惠价）！</a>").build();
				try {
					wxMpService.customMessageSend(couponTextMessage);
				} catch (WxErrorException e) {
					e.printStackTrace();
				}
			}else{
				WxMpCustomMessage purchaseInvitationTextMessage = WxMpCustomMessage.TEXT().toUser(wxMessage.getFromUserName()).content(
						WelcomeText.getPurchaseInvitationText(Constants.domain, "/oauth?p=" + page )).build();
				try {
					wxMpService.customMessageSend(purchaseInvitationTextMessage);
				} catch (WxErrorException e) {
					e.printStackTrace();
				}
			}
		}
		//在未关注公众号的时候，扫码成功后带有参数ebid的，则转向对应的详情页。
		if(wxMessage.getEventKey().contains("qrscene_educampaign")){
			Map<String,String> eventKeyMap = ComUtils.unicodeParamstr2Map(wxMessage.getEventKey());
			log.debug(">>>>>Y1daSubscribeHandler eventKeyMap:{}" , eventKeyMap);
			String ebid = eventKeyMap.get("ebid");
			WxMpCustomMessage purchaseInvitationTextMessage = WxMpCustomMessage.TEXT().toUser(wxMessage.getFromUserName()).content(
					WelcomeText.getEdubookIdText(Constants.domain, "/oauth?p=edu01&ebid=" + ebid )).build();
			try {
				wxMpService.customMessageSend(purchaseInvitationTextMessage);
			} catch (WxErrorException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
