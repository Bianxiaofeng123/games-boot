package com.games.world.mp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

public class Y1daUnsubscribeHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daUnsubscribeHandler.class);
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		log.debug(">>>>>Y1daUnsubscribeHandler-handle-start");
		
		RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject( Constants.domain + "/subscribe?uopid=" + wxMessage.getFromUserName()+ "&subscribe=0", String.class);
	    
		log.debug(">>>>>Y1daUnsubscribeHandler-handle-end: {}", result);
		return null;
	}

}
