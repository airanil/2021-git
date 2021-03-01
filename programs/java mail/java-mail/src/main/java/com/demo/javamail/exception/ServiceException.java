package com.demo.javamail.exception;

import com.demo.javamail.model.BaseMessage;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BaseMessage baseMessage;

	public BaseMessage getBaseMessage() {
		return baseMessage;
	}

	public void setBaseMessage(BaseMessage baseMessage) {
		this.baseMessage = baseMessage;
	}

}
