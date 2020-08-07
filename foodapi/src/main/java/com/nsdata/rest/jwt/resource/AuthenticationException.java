package com.nsdata.rest.jwt.resource;
/**
 * @author nagesh.divatagi
 *
 *@CreateDate 06-Aug-2020 9:33:08 pm
 *@FileNam AuthenticationException.java
 */

public class AuthenticationException extends RuntimeException {
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}
