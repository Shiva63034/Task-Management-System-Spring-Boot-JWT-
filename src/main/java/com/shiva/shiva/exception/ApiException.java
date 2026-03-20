package com.shiva.shiva.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ApiException extends RuntimeException {
private String messege;
public ApiException(String messege) {
	super(messege);
	this.messege=messege;
}
}
