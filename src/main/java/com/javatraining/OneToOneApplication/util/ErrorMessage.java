package com.javatraining.OneToOneApplication.util;

import java.time.LocalDateTime;

public class ErrorMessage {

	private String errorMessage;
	private LocalDateTime timeStamp;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
