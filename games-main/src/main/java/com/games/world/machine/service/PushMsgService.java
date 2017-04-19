package com.games.world.machine.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.games.world.util.QRCodeUtil;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

@Service
public class PushMsgService {
	private Logger log = LoggerFactory.getLogger(PushMsgService.class);
	
    @Autowired
    private WxMpService wxMpService;
    
	@Value("${spring.profiles.active}")
	private String activeProfile;
    
    //用户提问通知(图文消息)
	public void pushQstMsg(Map<String, Object> params)throws Exception{
		log.debug("--------image:{}", params);
		String openId = params.get("openid").toString();
		WxMpCustomMessage.WxArticle article1 = new WxMpCustomMessage.WxArticle();
		article1.setUrl(params.get("url").toString());
		/*article1.setPicUrl("PIC_URL");*/
		String msg = "test";
		article1.setDescription(msg);
		article1.setTitle("用户提问通知");

		WxMpCustomMessage message = WxMpCustomMessage.NEWS()
		    .toUser(openId)
		    .addArticle(article1)
		    .build();
		wxMpService.customMessageSend(message);
	}
	
	//退款通知(拒绝)(图文消息)
	public void pushRefundMsg(Map<String, Object> params)throws Exception{
		log.debug("--------image:{}", params);
		String openId = params.get("openid").toString();
		WxMpCustomMessage.WxArticle article1 = new WxMpCustomMessage.WxArticle();
		article1.setUrl(params.get("url").toString());
		/*article1.setPicUrl("PIC_URL");*/
		String msg = "test";
		article1.setDescription(msg);
		article1.setTitle("退款通知");

		WxMpCustomMessage message = WxMpCustomMessage.NEWS()
		    .toUser(openId)
		    .addArticle(article1)
		    .build();
		wxMpService.customMessageSend(message);
	}
	
	/**
	 * 主动向用户发送文字消息
	 * @params {openid, content}
	 */
	public void text(Map<String, Object> params) throws WxErrorException{
		log.debug("--------text:{}", params);
		String openId = params.get("uopid").toString();
		String content = params.get("content").toString();
		WxMpCustomMessage message = WxMpCustomMessage
		  .TEXT()
		  .toUser(openId)
		  .content(content)
		  .build();
		 wxMpService.customMessageSend(message);
	}
	
	/**
	 * 主动向用户发送图片消息
	 * @params {openid, mediaid}
	 */
	public void image(Map<String, Object> params) throws WxErrorException{
		log.debug("--------image:{}", params);
		String openId = params.get("uopid").toString();
		String mediaId = params.get("mediaid").toString();
		WxMpCustomMessage message = WxMpCustomMessage
		  .IMAGE()
		  .toUser(openId)
		  .mediaId(mediaId)
		  .build();
		wxMpService.customMessageSend(message);
		
	}
	public void imageWithQrcode(Map<String,Object> params) throws Exception{
		log.debug("--------imageWithQrcode:{}", params);
		if (!params.containsKey("uopid") || StringUtils.isEmpty(params.get("uopid").toString())){
			log.debug("uopid必须");
			return;
		}
		String uopid = params.get("uopid").toString();
		InputStream headInputSm = null;
		headInputSm = ClassLoader.getSystemResourceAsStream("logo.jpg");;
		// 获取图书的封面
		InputStream qrbgSm = ClassLoader.getSystemResourceAsStream("images/qrbg02.jpg");
		BufferedImage bgBufferImage = ImageIO.read(qrbgSm);
		// 永久ticket
		WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateLastTicket("edupaid&p=exbm00&uopid=" + uopid);
		// 获得一个在系统临时目录下的文件，是jpg格式的
		File file = wxMpService.getQrcodeService().qrCodePicture(ticket);
		InputStream qrcode = new FileInputStream(file);
//		QRCodeUtil.insertQrcodeToBg(bgBufferImage, qrcode, 48, 745, 222, 222, true);
//		QRCodeUtil.insertQrcodeToBg(bgBufferImage, headInputSm, 125, 830, 60, 60,true);
		QRCodeUtil.insertQrcodeToBg(bgBufferImage, qrcode, 95, 388, 177, 177, true);
		QRCodeUtil.insertQrcodeToBg(bgBufferImage, headInputSm, 160, 453, 55, 55,true);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(bgBufferImage, "jpeg", os);
		InputStream wxBgImageis = new ByteArrayInputStream(os.toByteArray());
		
		WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService().mediaUpload(WxConsts.MEDIA_IMAGE, WxConsts.FILE_JPG, wxBgImageis);
		WxMpCustomMessage message = WxMpCustomMessage
				  .IMAGE()
				  .toUser(uopid)
				  .mediaId(wxMediaUploadResult.getMediaId())
				  .build();
		wxMpService.customMessageSend(message);
	}
	
	/**
	 * 主动向用户发送声音消息
	 * @params {openid, mediaid}
	 */
	public void voice(Map<String, Object> params) throws WxErrorException{
		log.debug("--------voice:{}", params);
		String openId = params.get("uopid").toString();
		String mediaId = params.get("mediaid").toString();
		WxMpCustomMessage message = WxMpCustomMessage.VOICE()
		  .toUser(openId)
		  .mediaId(mediaId)
		  .build();
		wxMpService.customMessageSend(message);
	}
	
	/**
	 * 主动向用户发送视频
	 */
	public void video(Map<String, Object> params) throws WxErrorException{
		log.debug("--------image:{}", params);
		String openId = params.get("uopid").toString();
		String mediaId1 = params.get("mediaid1").toString();
		String mediaId2 = params.get("mediaid2").toString();
		WxMpCustomMessage message = WxMpCustomMessage.VIDEO()
		  .toUser(openId)
		  .title("TITLE") //视频标题
		  .mediaId(mediaId1)
		  .thumbMediaId(mediaId2)
		  .description("DESCRIPTION") //视频描述
		  .build();
		wxMpService.customMessageSend(message);
	}
}
