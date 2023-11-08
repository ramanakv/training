package com.cg.trg.boot.dto;

public class AppResponse {
	
	private String respCode;
	private String message;
	
	public AppResponse() {
		super();
	}

	public AppResponse(String respCode, String message) {
		super();
		this.respCode = respCode;
		this.message = message;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
