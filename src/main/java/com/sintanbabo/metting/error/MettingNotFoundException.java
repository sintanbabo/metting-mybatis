package com.sintanbabo.metting.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")
public class MettingNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public MettingNotFoundException() {
		super();
	}
	public MettingNotFoundException(String message) {
		super(message);
	}
}
