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

public class Y1daGetCardHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daGetCardHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		log.debug(">>>>>Y1daGetCardHandler-handle-start");
		String uopid = wxMessage.getFromUserName();
		String couponcd = wxMessage.getUserCardCode();
		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getForObject( Constants.domain + "/getCoupon?uopid=" + uopid + "&couponcd=" + couponcd, String.class);
		
		return null;
	}

}
