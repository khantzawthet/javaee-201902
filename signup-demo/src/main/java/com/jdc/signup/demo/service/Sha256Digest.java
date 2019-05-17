package com.jdc.signup.demo.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Sha256Digest {
	
	public static void main(String[] args) {
		System.out.println(digest("admin"));
	}
	
	public static String digest(String raw) {
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte [] data = digest.digest(raw.getBytes());
			return Base64.getEncoder().encodeToString(data);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
