package com.mthree.uri;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("common")
public class Configuration {

	private String servType;
	
	private String servId;
	
	private String appCheck;
	
	public String getServType() {
		return servType;
	}

	public void setServType(String servType) {
		this.servType = servType;
	}

	public String getServId() {
		return servId;
	}

	public void setServId(String servId) {
		this.servId = servId;
	}

	public String getAppCheck() {
		return appCheck;
	}

	public void setAppCheck(String appCheck) {
		this.appCheck = appCheck;
	}
	
	
}
