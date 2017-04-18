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
public class MchpayCouponBean  implements Serializable {
	
	@XStreamAlias("return_code")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String returnCode;
	
	@XStreamAlias("return_msg")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String returnMsg;
	
	@XStreamAlias("appid")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String appid;
	
	@XStreamAlias("mch_id")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String mchid;
	
	@XStreamAlias("device_info")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String deviceInfo;
	
	@XStreamAlias("nonce_str")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String nonceStr;
	
	@XStreamAlias("sign")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String sign;
	
	@XStreamAlias("err_code")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String errCode;
	
	@XStreamAlias("err_code_des")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String errCodeDes;
	
	@XStreamAlias("coupon_stock_id")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String couponStockId;
	
	@XStreamAlias("resp_count")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String respCount;
	
	@XStreamAlias("success_count")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String successCount;
	
	@XStreamAlias("failed_count")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String failedCount;
	
	@XStreamAlias("openid")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String openid;
	
	@XStreamAlias("ret_code")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String retCode;
	
	@XStreamAlias("coupon_id")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String couponId;
	
	@XStreamAlias("ret_msg")
	@XStreamConverter(value=XStreamCDataConverter.class)
	private String retMsg;
	
	public static MchpayCouponBean fromXml(String xml) {
	    return MchpayCouponXStreamTransformer.fromXml(MchpayCouponBean.class, xml);
	}

	  public static MchpayCouponBean fromXml(InputStream is) {
	    return MchpayCouponXStreamTransformer.fromXml(MchpayCouponBean.class, is);
	  }

}
