package com.jdc.student.utils;

import java.security.MessageDigest;
import java.util.Base64;

public class Sha256Algorithm {
	
	public static void main(String[] args) {
		System.out.println(encrypt("admin"));
	}

	public static String encrypt(String pass) {
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte [] data = digest.digest(pass.getBytes());
			return Base64.getEncoder().encodeToString(data);
			
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
}
