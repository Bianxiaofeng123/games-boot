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

public class Y1daSysMenuHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daSysMenuHandler.class);
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>Y1daSysMenuHandler-handle-start");
		
		WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content(""
					+ "1. <a href=\"" + Constants.domain + "/statis\">E答整体统计</a>\n\n"
					+ "2. <a href=\"" + Constants.domain + "/oauth?p=statis0\">教育统计</a>\n\n"
					+ "3. <a href=\"" + Constants.domain + "/oauth?p=mkt\">答主入驻板块</a>\n\n"
					+ "4. <a href=\"" + Constants.domain + "/oauth?p=edufcpn\">免费送书</a>\n\n").fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();
		log.debug(">>>>>Y1daSysMenuHandler-handle-end");
		
		return m;


	}

}
