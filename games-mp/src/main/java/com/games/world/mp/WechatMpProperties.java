package com.games.world.mp;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.wechatmp")
public class WechatMpProperties {
	/**
	 * 服务器域名
	 */
	private String domain;
	/**
	 * 服务器IP
	 */
	private String remoteip;
	/**
	 * 设置微信公众号的appid
	 */
	private String appId;
	/**
	 * 设置微信公众号的app secret
	 */
	private String secret;
	/**
	 * 微信支付partner id
	 */
	private String partnerId;
	/**
	 * 微信支付partner key
	 */
	private String partnerKey;
	/**
	 * 设置微信公众号的token
	 */
	private String token;
	/**
	 * 设置微信公众号的EncodingAESKey
	 */
	private String aesKey;

	public String getDomain(){
		return domain;
	}
	public void setDomain(String domain){
		this.domain = domain;
	}
	public String getRemoteip(){
		return remoteip;
	}
	public void setRemoteip(String remoteip){
		this.remoteip = remoteip;
	}
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerKey() {
		return partnerKey;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}
}
