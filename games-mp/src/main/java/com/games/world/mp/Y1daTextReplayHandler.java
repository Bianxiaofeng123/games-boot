package com.games.world.mp;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTransferCustomerServiceMessage;

public class Y1daTextReplayHandler implements WxMpMessageHandler {
	private Logger log = LoggerFactory.getLogger(Y1daTextReplayHandler.class);

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) {
		System.out.println("Y1daTextReplayHandler start");
		log.debug(">>>>>CustomerServiceHandler-handle-start");
		RestTemplate restTemplate = new RestTemplate();
		if ("推荐有奖".equals(wxMessage.getContent())) {
			try {
				String result = restTemplate.getForObject(
						Constants.domain + "/wxInviteImagePush?uopid=" + wxMessage.getFromUserName().toString(),
						String.class);
				log.debug("result:{}", result);
			} catch (Exception e) {
			}
			log.debug(">>>>>Y1daTextReplayHandler 推荐有奖");
			return null;
		} else if ("text".equals(wxMessage.getMsgType())) {
			String result = restTemplate.getForObject(Constants.domain + "/ocr/hospnm?uopid="
					+ wxMessage.getFromUserName() + "&hospnm=" + wxMessage.getContent(), String.class);
			log.debug("result:{}", result);
		} else if ("image".equals(wxMessage.getMsgType())) {
			String result = restTemplate.getForObject(Constants.domain + "/ocr/image?uopid="
					+ wxMessage.getFromUserName() + "&picurl=" + wxMessage.getPicUrl(), String.class);
			log.debug("result:{}", result);
		}

		// ##############################################
		// 以下统一处理文本消息
		// ##############################################
		@SuppressWarnings("serial")
		Map<String, String> contentMap = new HashMap<String, String>() {
			{
				// 教育用关键字模板
				put("芝麻开门",
						"1. <a href=\"" + Constants.domain + "/statis\">E答整体统计</a>\n\n2. <a href=\"" + Constants.domain
								+ "/oauth?p=statis0\">教育统计</a>\n\n3. <a href=\"" + Constants.domain
								+ "/oauth?p=mkt\">答主入驻板块</a>\n\n4. <a href=\"" + Constants.domain
								+ "/oauth?p=edufcpn\">免费送书</a>\n\n");
				put("题库", "请点击“进入E答”，随后在页面中点击“教育”，即可看到购买页面，购买支付成功后即可复习题目了 ");
			}
		};

		if (contentMap.containsKey(wxMessage.getContent())) {
			WxMpXmlOutTextMessage m = WxMpXmlOutMessage.TEXT().content(contentMap.get(wxMessage.getContent()))
					.fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName()).build();
			log.debug(">>>>>CustomerServiceHandler-handle-end:" + m);
			return m;
		} else {
			// 客服消息转发至微信服务器，微信服务器会把这次发送的消息转到多客服系统。
			WxMpXmlOutTransferCustomerServiceMessage m = WxMpXmlOutTransferCustomerServiceMessage
					.TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUserName()).toUser(wxMessage.getFromUserName())
					.build();

			log.debug(">>>>>CustomerServiceHandler-handle-end:" + m);
			return m;
		}
	}
}