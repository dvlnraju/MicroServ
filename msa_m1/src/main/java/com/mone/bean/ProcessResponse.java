package com.mone.bean;

public class ProcessResponse {

	private boolean statusFlag;
	
	private String statusMessage;

	public boolean isStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(boolean statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public ProcessResponse(boolean statusFlag,String statusMessage) {
		this.statusFlag=statusFlag;
		this.statusMessage=statusMessage;
	}

	public ProcessResponse() {
	}
	
}
