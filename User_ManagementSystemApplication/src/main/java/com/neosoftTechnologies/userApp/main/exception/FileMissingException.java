package com.neosoftTechnologies.userApp.main.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FileMissingException extends UserManagementAppModuleException{

	private static final long serialVersionUID = 1L;
	public FileMissingException() {
	}
	public FileMissingException(String msg) {
		super(msg);
	}

}
