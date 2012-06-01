package br.com.abril.rino.model;

import java.io.Serializable;

public class Hit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// REQUIRED FIELDS
	  private String linkHref;
	  private String imgSrc;       
	  private String timestamp;     
	  private String clickX;
	  private String clickY;
	  private String browserHeight;
	  private String browserWidth;
	                            
	  // RECOMMENDED FIELDS      
	  private String linkText;
	  private String linkTitle;
	  private String linkRel;
	  private String referer;
	  private String originalReferer;
	  private String userAgent;
	  private String remoteAddr;
	                            
	  private String createdMinute;
	  private String createdHour;
	  
	  private String createdAt;

	  private String valid;
	  
	  

	public Hit(String linkHref, String imgSrc, String timestamp, String clickX,
			String clickY, String browserHeight, String browserWidth) {
		super();
		this.linkHref = linkHref;
		this.imgSrc = imgSrc;
		this.timestamp = timestamp;
		this.clickX = clickX;
		this.clickY = clickY;
		this.browserHeight = browserHeight;
		this.browserWidth = browserWidth;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public String getLinkRel() {
		return linkRel;
	}

	public void setLinkRel(String linkRel) {
		this.linkRel = linkRel;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getOriginalReferer() {
		return originalReferer;
	}

	public void setOriginalReferer(String originalReferer) {
		this.originalReferer = originalReferer;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getCreatedMinute() {
		return createdMinute;
	}

	public void setCreatedMinute(String createdMinute) {
		this.createdMinute = createdMinute;
	}

	public String getCreatedHour() {
		return createdHour;
	}

	public void setCreatedHour(String createdHour) {
		this.createdHour = createdHour;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getLinkHref() {
		return linkHref;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getClickX() {
		return clickX;
	}

	public String getClickY() {
		return clickY;
	}

	public String getBrowserHeight() {
		return browserHeight;
	}

	public String getBrowserWidth() {
		return browserWidth;
	}
	  
	  
	  
	  
}
