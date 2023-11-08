package com.cg.trg.boot.exceptions;

import com.cg.trg.boot.dto.AppResponse;

public class DuplicateEmployeeException extends RuntimeException {
	private AppResponse response;

	public DuplicateEmployeeException(AppResponse response) {
		this.response = response;
	}

	public AppResponse getResponse() {
		return response;
	}

	public void setResponse(AppResponse response) {
		this.response = response;
	}

}
