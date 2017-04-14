package com.games.world.mp;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Y1daImageHandler implements WxMpMessageHandler {
	
	private Logger log = LoggerFactory.getLogger(Y1daImageHandler.class);
	
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		log.debug(">>>>>Y1daImageHandler-handle-start");
		try {
			WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService().mediaUpload(WxConsts.MEDIA_IMAGE, WxConsts.FILE_JPG,
					ClassLoader.getSystemResourceAsStream("mm.jpeg"));
			log.debug("-----------发送图片：---------");
			WxMpXmlOutImageMessage m = WxMpXmlOutMessage.IMAGE().mediaId(wxMediaUploadResult.getMediaId())
					.fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName()).build();
			
			log.debug(">>>>>Y1daImageHandler-handle-end");
			return m;
		} catch (WxErrorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
