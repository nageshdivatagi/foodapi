package com.nsdata.rest.jwt.resource;

import java.io.Serializable;
/**
 * @author nagesh.divatagi
 *
 *@CreateDate 06-Aug-2020 9:22:23 pm
 *@FileNam JwtTokenRequest.java
 */
public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
