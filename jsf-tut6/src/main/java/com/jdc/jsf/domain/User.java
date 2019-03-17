package com.jdc.jsf.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String password;
	private Profile profile;
	private Address address;
	
	public User() {
		address = new Address();
		profile = new Profile();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
