package com.games.world.mp;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

public class Y1daLocationHandler implements WxMpMessageHandler {
	@SuppressWarnings("unused")
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		RestTemplate restTemplate = new RestTemplate();
		try{
			String lon = wxMessage.getLongitude() + "";
			String lat = wxMessage.getLatitude() + "";
			String result = restTemplate.getForObject( Constants.domain + ":82/updloc?uopid=" + wxMessage.getFromUserName().toString() + "&lat=" + lat  + "&lon=" + lon, String.class);
		}catch(Exception e){
			e.printStackTrace();
	    }
		return null;
	}
}
