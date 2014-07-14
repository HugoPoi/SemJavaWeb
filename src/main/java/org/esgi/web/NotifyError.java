package org.esgi.web;

public class NotifyError {
	
	String message;
	NotifyType type;
	
	public NotifyError(String message, NotifyType type) {
		super();
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public NotifyType getType() {
		return type;
	}
	
	
	
}
