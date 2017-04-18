package com.games.world.model;

import java.io.InputStream;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import lombok.Data;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

@SuppressWarnings("serial")
@Data
//@XmlRootElement(name="xml")
@XStreamAlias("xml")
public class MchpayBean  implements Serializable {
	
	@XStreamAlias("return_code")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String returnCode;
	
	@XStreamAlias("return_msg")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String returnMsg;
	
	@XStreamAlias("mch_appid")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String mchAppid;
	
	@XStreamAlias("mchid")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String mchid;
	
	@XStreamAlias("device_info")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String deviceInfo;
	
	@XStreamAlias("nonce_str")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String nonceStr;
	
	@XStreamAlias("result_code")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String resultCode;
	
	@XStreamAlias("partner_trade_no")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String partnerTradeNo;
	
	@XStreamAlias("payment_no")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String paymentNo;
	
	@XStreamAlias("payment_time")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String paymentTime;
	
	public static MchpayBean fromXml(String xml) {
	    return MchpayXStreamTransformer.fromXml(MchpayBean.class, xml);
	}

	  public static MchpayBean fromXml(InputStream is) {
	    return MchpayXStreamTransformer.fromXml(MchpayBean.class, is);
	  }

}
