package com.games.world.model;

import java.io.InputStream;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import lombok.Data;
import me.chanjar.weixin.common.util.xml.XStreamCDataConverter;

@SuppressWarnings("serial")
@Data
@XStreamAlias("xml")
public class MchrefundBean implements Serializable {

	@XStreamAlias("return_code")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String returnCode;
	
	@XStreamAlias("return_msg")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String returnMsg;
	
	@XStreamAlias("result_code")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String resultCode;
	
	@XStreamAlias("appid")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String mchAppid;
	
	@XStreamAlias("mch_id")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String mchId;
	
	@XStreamAlias("device_info")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String deviceInfo;
	
	@XStreamAlias("nonce_str")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String nonceStr;
	
	@XStreamAlias("transaction_id")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String transactionId;
	
	@XStreamAlias("out_trade_no")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String outTradeNo;
	
	@XStreamAlias("out_refund_no")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String outRefundNo;
	
	@XStreamAlias("refund_fee")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String refundFee;
	
	@XStreamAlias("settlement_refund_fee_$n")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String settlementRefundFee;
	
	@XStreamAlias("total_fee")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String totalFee;
	
	@XStreamAlias("settlement_total_fee")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String settlementTotalFee;
	
	@XStreamAlias("cash_fee")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String cashFee;
	
	public static MchrefundBean fromXml(String xml) {
	    return MchrefundXStreamTransformer.fromXml(MchrefundBean.class, xml);
	}

	public static MchrefundBean fromXml(InputStream is) {
		return MchrefundXStreamTransformer.fromXml(MchrefundBean.class, is);
	}
}
