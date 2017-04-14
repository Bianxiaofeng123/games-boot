package com.games.world.mp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games.world.mp.message.HelpArticle;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;

public class Y1daArticleAnswerHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daArticleAnswerHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>Y1daArticleAnswerHandler-handle-start");
		
		
		WxMpXmlOutNewsMessage news = WxMpXmlOutNewsMessage
				.NEWS()
				.addArticle(HelpArticle.getHelpArticle2())
				.fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName())
				.build();
		
		return news;
	}

}
