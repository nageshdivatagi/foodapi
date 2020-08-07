package com.nsdata.rest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * @author nagesh.divatagi
 *
 *@CreateDate 06-Aug-2020 9:32:08 pm
 *@FileNam BcryptEncoder.java
 */

public class BcryptEncoder {
/*
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
System.out.println("Pass : $2a$10$TE82eA7wkDSM0MqHiSK2nOs44jcMSMRZNVx9zBxBZRVJ/xISQN9xK");
//"$2a$10$5BVTCuCwseXNWKUkriLj6ujTiiSo61O0RFQBBkOff1zri66gtaZe2"
		for (int i = 1; i <= 10; i++) {
			String encodedString = encoder.encode("admin@143");
			System.out.println(encodedString);
		}

		// TODO Auto-generated method stub

	}
*/
	public String getBcryptEncoderPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedString = "";
		for (int i = 1; i <= 10; i++) {
			encodedString = encoder.encode(password);
		}
		return encodedString;
	}
	
}
