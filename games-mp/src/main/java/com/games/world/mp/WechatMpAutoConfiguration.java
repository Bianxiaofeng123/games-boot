package com.games.world.mp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

@Configuration
@ConditionalOnClass(WxMpService.class)
@EnableConfigurationProperties(WechatMpProperties.class)
public class WechatMpAutoConfiguration {
	@Autowired
	private WechatMpProperties properties;

	@Bean
	@ConditionalOnMissingBean
	//微信公众号的配置
	public WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage() {
		WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
		configStorage.setAppId(properties.getAppId());
		configStorage.setSecret(properties.getSecret());
		configStorage.setToken(properties.getToken());
		configStorage.setAesKey(properties.getAesKey());
		configStorage.setPartnerId(properties.getPartnerId());
		configStorage.setPartnerKey(properties.getPartnerKey());
		configStorage.setPartnerKey(properties.getPartnerKey());
		configStorage.setPartnerKey(properties.getPartnerKey());

		return configStorage;
	}

	@Bean
	@ConditionalOnMissingBean
	//实例化微信服务（设置配置）
	public WxMpService wxMpService(WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage) {
		WxMpService wxMpService = new WxMpServiceImpl();
		wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
		return wxMpService;
	}

	@SuppressWarnings("unused")
	@Bean
	//微信消息路由器：微信推送给公众号的消息类型很多，而公众号也需要针对用户不同的输入做出不同的反应。
	public WxMpMessageRouter wxMpMessageRouter(WxMpService wxMpService) {

		
		WxMpMessageHandler logHandler = new Y1daLogHandler();
//		WxMpMessageHandler imageHandler = new Y1daImageHandler();
//		WxMpMessageHandler textHandler = new YidaTextHandler();
//		WxMpMessageHandler oauth2handler = new Y1daOAuth2Handler();
		WxMpMessageHandler edubuyhandler = new Y1daArticleEduBuyHandler();
		

		WxMpMessageHandler subscribehandler = new Y1daSubscribeHandler();
		WxMpMessageHandler unsubscribehandler = new Y1daUnsubscribeHandler();
		WxMpMessageHandler newshandler = new Y1daNewsHandler();
		WxMpMessageHandler scanhandler = new Y1daScanHandler();
		WxMpMessageHandler myCardHandler = new Y1daMyCardHandler();
		WxMpMessageHandler sysMenuHandler = new Y1daSysMenuHandler();
		WxMpMessageHandler managerHandler = new Y1daManagerHandler();
		WxMpMessageHandler locationHandler = new Y1daLocationHandler();
		//消息转到多客服系统。
		WxMpMessageHandler y1daTextReplayHandler = new Y1daTextReplayHandler();
		WxMpMessageHandler inviteImageHandler = new Y1daInviteImageHandler();
		// 卡券
		WxMpMessageHandler getCardHandler = new Y1daGetCardHandler();
		WxMpMessageHandler delCardHandler = new Y1daDelCardHandler();
		WxMpMessageRouter wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
		wxMpMessageRouter
			.rule().handler(logHandler).next()
//			.rule().msgType(WxConsts.XML_MSG_TEXT).end()
			.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SUBSCRIBE).handler(subscribehandler).end() // 关注后发送欢迎文字信息
			.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_UNSUBSCRIBE).handler(unsubscribehandler).end() // 取消关注后的动作
			.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SCAN).handler(scanhandler).end()
			.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_LOCATION).handler(locationHandler).end() //根据经纬度，调用高德地图，获取用户的位置信息。
			// 用户领取卡券
			.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_USER_GET_CARD).handler(getCardHandler).end()
			// 用户删除卡券
			.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_USER_DEL_CARD).handler(delCardHandler).end()
			
            //兜底路由规则，一般放到最后
            //消息转到多客服系统，必须放到路由文字消息的后面，否则不能执行文字消息对应的handler。
            .rule().async(false).msgType(WxConsts.XML_MSG_IMAGE).handler(y1daTextReplayHandler).end()
            .rule().async(false).msgType(WxConsts.XML_MSG_TEXT).handler(y1daTextReplayHandler).end()
            .rule().async(false).msgType(WxConsts.XML_MSG_VOICE).handler(y1daTextReplayHandler).end()
            ; 	
		return wxMpMessageRouter;
	}
}
