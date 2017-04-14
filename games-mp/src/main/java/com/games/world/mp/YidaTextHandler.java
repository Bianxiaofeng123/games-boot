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

public class YidaTextHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(YidaTextHandler.class);
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>YidaTextHandler-handle-start");
		WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content("E答项目暂时不支持自由消息，有问题请狠戳以下链接 " + Constants.domain  ).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();
		log.debug(">>>>>YidaTextHandler-handle-end");
		return m;
	}
}