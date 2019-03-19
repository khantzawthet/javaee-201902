package com.jdc.registration;

import java.io.Serializable;

public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;

	private String phone;
	private String email;
	private String street;
	private String township;
	private String city;
	
	public String getAddress() {
		return String.format("%s, %s, %s", street, township, city);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
