package com.games.world.mp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.games.world.mp.message.WelcomeText;
import com.games.world.mp.utils.ComUtils;
import com.google.gson.Gson;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

public class Y1daScanHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daScanHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		log.debug(">>>>>Y1daScanHandler-handle-start");
		Gson g = new Gson();
		log.debug("educampaign  wxMessage-{}", g.toJson(wxMessage));
		log.debug("context-{}", context);
		
		//扫码成功后带有参数ebid的，则转向对应的详情页。
		if(wxMessage.getEventKey().contains("educampaign")){
			Map<String,String> eventKeyMap = ComUtils.unicodeParamstr2Map(wxMessage.getEventKey());
			log.debug(">>>>>educampaign:{}" , eventKeyMap);
			String ebid = eventKeyMap.get("ebid");
			log.debug(WelcomeText.getEdubookIdText(Constants.domain, "/oauth?p=edu01&ebid=" + ebid ));
			WxMpCustomMessage m = WxMpCustomMessage.TEXT().toUser(wxMessage.getFromUserName()).content(
					WelcomeText.getEdubookIdText(Constants.domain, "/oauth?p=edu01&ebid=" + ebid )).build();
			try{
				wxMpService.customMessageSend(m);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
