package com.nsdata.rest.jwt.resource;

import java.io.Serializable;

/**
 * @author nagesh.divatagi
 *
 * @CreateDate 06-Aug-2020 9:22:56 pm
 * @FileNam JwtTokenResponse.java
 */
public class JwtTokenResponse implements Serializable {

	private static final long serialVersionUID = 8317676219297719109L;

	private final String token;

	public JwtTokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}