package com.games.world.mp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutImageMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

public class Y1daMyCardHandler implements WxMpMessageHandler{
	
	private Logger log = LoggerFactory.getLogger(Y1daMyCardHandler.class);
	@Autowired
	WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
	@Autowired
	private static RestTemplate template = new RestTemplate();

	
	@SuppressWarnings("unchecked")
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager){
		log.debug(">>>>>Y1daMyCardHandler-handle-start");
		log.debug("-----------mycard------------1");
		try {
			HashMap<String, Object> message = template.getForObject( Constants.domain + "/findausrinfo?uopid=" + wxMessage.getFromUserName(), HashMap.class);
			log.debug(">>>>>Y1daSubscribeHandler-handle-end: {}" , message);
			int aswfg = Integer.parseInt(message.get("aswfg").toString());
			if(aswfg == 0){
				//如果不是答主，直接给出E答的二维码，链接至E答首页
				return null;
			}
			//从答主信息表中查询答主的个人主页地址，如果有，则不再生成个人二维码图片，直接从七牛云下载个人二维码图片；如果没有，则生成个人二维码图片上传之七牛云图片。
			BufferedImage cardImage = null;
			ByteArrayOutputStream os = null;
			InputStream is = null;
			
			if(message.get("qrkey") == null || StringUtils.isEmpty(message.get("qrkey"))){
				String uopid = wxMessage.getFromUserName().toString();
				String text = Constants.domain  + "/oauth?p=bqst&aopid=" + uopid;
				String shortUrl = wxMpService.shortUrl(text);
				log.debug("shortUrl=" + shortUrl);
				String headImgUrl = message.get("hdurl").toString();
				log.debug("-------headImgUrl=------" + headImgUrl);
				URL url = null;  
				InputStream iss = null; 
				url = new URL(headImgUrl);  
				iss = url.openStream();  
				//img = ImageIO.read(is); 
				log.debug("-----------mycard------------4");
				cardImage = QRCodeUtil.encode(shortUrl, iss, true);
				log.debug("-----------mycard------------5");
				os = new ByteArrayOutputStream();
				log.debug("-----------------开始把个人二维码的图片转换图片为jpeg：---------------");
				ImageIO.write(cardImage, WxConsts.FILE_JPG, os);
				log.debug("-----------mycard------------6");
				is = new ByteArrayInputStream(os.toByteArray());
				log.debug("-----------mycard------------7");
				//上传个人二维码图片至七牛
				/*byte[] qrbyte = QRCodeUtil.buf2byte(QRCodeUtil.encode(shortUrl, is, true));
				
		        HttpHeaders headers = new HttpHeaders();
		        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		        headers.setContentType(type);
		        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		        
		        Map<String, Object> params = new HashMap<>();
		        params.put("qrbyte", qrbyte);
		        
		        JSONObject jsonObj = JSONObject.fromObject(null);
		        
		        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

				String qrkey = template.postForObject(url, formEntity, String.class);*/
				/*String qrkey = QiNiuUtils.uploadPublic(qrbyte, false);
				// 如果是二维码页面 把qrurl返回给 result即可
				String qrurl = Constants.publicUrl + "/" + qrkey;
				log.debug("qrurl ::::: {}", qrurl);*/
			}else{
				//此处为开发完成，为七牛云存储。
			}
			WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService().mediaUpload(WxConsts.MEDIA_IMAGE, WxConsts.FILE_JPG,
					is);
			log.debug("-----------mycard------------8");
			log.debug("-----------mycard------------9");
			WxMpXmlOutImageMessage m = WxMpXmlOutMessage
					.IMAGE()
					.mediaId(wxMediaUploadResult.getMediaId())
					.fromUser(wxMessage.getToUserName())
					.toUser(wxMessage.getFromUserName())
					.build();
			log.debug("-----------mycard------------10");
			log.debug(">>>>>Y1daMyCardHandler-handle-end");
			is.close();
			os.close();
			return m;
		} catch (WxErrorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
