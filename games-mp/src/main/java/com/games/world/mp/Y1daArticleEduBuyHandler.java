package com.games.world.mp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class Y1daArticleEduBuyHandler  implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(YidaTextHandler.class);
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>YidaTextHandler-handle-start");
		WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content("购买小红书 , <a href=\"" + Constants.domain + "/oauth?p=edu04\">请点击此处</a> "  ).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();
		log.debug(">>>>>YidaTextHandler-handle-end");
		return m;
	}
	
}
