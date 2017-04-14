package com.games.world.mp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games.world.mp.message.HelpArticle;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutNewsMessage;

public class Y1daNewsHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daNewsHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		log.debug(">>>>>Y1daWelcomeHandler-handle-start");
		WxMpXmlOutNewsMessage news = WxMpXmlOutNewsMessage
				.NEWS()
				.addArticle(HelpArticle.getHelpArticle1())
				.addArticle(HelpArticle.getHelpArticle2())
				.addArticle(HelpArticle.getHelpArticle3())
				.addArticle(HelpArticle.getHelpArticle4())
				.fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName())
				.build();
		
		log.debug(">>>>>Y1daWelcomeHandler-handle-end");
		return news;
	}

}
