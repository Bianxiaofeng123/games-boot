package com.games.world.mp;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

public class Y1daManagerHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daManagerHandler.class);
	@Autowired
	private static RestTemplate template = new RestTemplate();

	@SuppressWarnings("unchecked")
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>Y1daManagerHandler-handle-start");
		
		
		// 查询是否是管理员权限
		// 1 系统管理员 2 市场推广人员 3 医院一级管理者 4 医院二级管理员
		HashMap<String, Object> message = template.getForObject( Constants.domain + "/mngrmenu?uopid=" + wxMessage.getFromUserName(), HashMap.class);
		log.debug(">>>>>Y1daSubscribeHandler-handle-end: {}" , message);
		String content = message.get("menu").toString();
		WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content(content).fromUser(wxMessage.getToUserName())
				.toUser(wxMessage.getFromUserName()).build();
		log.debug(">>>>>Y1daManagerHandler-handle-end");
		
		return m;


	}

}
