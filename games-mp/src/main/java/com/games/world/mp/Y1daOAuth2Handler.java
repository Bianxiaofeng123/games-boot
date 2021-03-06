package com.games.world.mp;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Y1daOAuth2Handler implements WxMpMessageHandler {
	protected final Logger log = LoggerFactory.getLogger(Y1daOAuth2Handler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>Y1daOAuth2Handler-handler-start");
		String href = "<a href=\"" + wxMpService.oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_USER_INFO, null, null)
				+ "\">测试oauth2</a>";

		log.info("", href);
//		System.out.println(href);
		log.debug(">>>>>Y1daOAuth2Handler-handler-end");
		return WxMpXmlOutMessage.TEXT().content(href).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();
	}
}
