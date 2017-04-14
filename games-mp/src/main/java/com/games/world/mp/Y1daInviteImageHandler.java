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

public class Y1daInviteImageHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daInviteImageHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		log.debug(">>>>>Y1daInviteImageHandler-handle-start");
		log.debug("context-{}", context);
		RestTemplate restTemplate = new RestTemplate();
		try{
			String result = restTemplate.getForObject( Constants.domain + "/wxInviteImagePush?uopid=" + wxMessage.getFromUserName().toString(), String.class);
			log.debug("result:{}", result);
		}catch(Exception e){
			e.printStackTrace();
	    }
		log.debug(">>>>>Y1daInviteImageHandler-handle-end");
		return null;
	}

}
