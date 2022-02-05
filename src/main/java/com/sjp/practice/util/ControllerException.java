package com.sjp.practice.util;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMsg;
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public ControllerException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	public ControllerException() {
		super();
	}
}
