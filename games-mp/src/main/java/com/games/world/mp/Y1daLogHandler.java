package com.games.world.mp;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class Y1daLogHandler implements WxMpMessageHandler {
	
	private Logger log = LoggerFactory.getLogger(Y1daLogHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug("[Y1daLogHandler]>>>>>Y1daLogHandler-handle-start");
		Gson g = new Gson();
		System.out.println("[Y1daLogHandler]>>>>wxMessage>>>>:"+ g.toJson(wxMessage));
		System.out.println("[Y1daLogHandler]>>>>context>>>>:"+ g.toJson(context));
		log.debug(">>>>>Y1daLogHandler-handle-end");
		return null;
	}
}
