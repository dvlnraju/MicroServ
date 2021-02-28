package com.mone.uri;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("origin")
public class Configuration {

	private String servType;
	
	private String servId;

	private String actionsAllowed;
	
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

	public String getActionsAllowed() {
		return actionsAllowed;
	}

	public void setActionsAllowed(String actionsAllowed) {
		this.actionsAllowed = actionsAllowed;
	}
	
	
}
