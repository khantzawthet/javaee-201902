package com.jdc.jpa2.entity;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.OneToOne;

@Entity
@Table(name = "STUDENT")
public class Student extends Account {

	public enum Gender {
		Male, Female
	}

	@Enumerated(STRING)
	private Gender gender;

	@Temporal(DATE)
	private Date dob;
	
	@OneToOne(mappedBy = "student")
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
