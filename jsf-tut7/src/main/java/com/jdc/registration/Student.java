package com.jdc.registration;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String gender;
	private LocalDate dob;

	private Contact contact;
	private Education eduction;
	
	public Student() {
		contact = new Contact();
		eduction = new Education();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Education getEduction() {
		return eduction;
	}

	public void setEduction(Education eduction) {
		this.eduction = eduction;
	}

}
