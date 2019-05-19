package com.jdc.student.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Student extends Member {

	private static final long serialVersionUID = 1L;

	private LocalDate dob;
	private Education education;
	private boolean itFields;
	private boolean itWork;

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public boolean isItFields() {
		return itFields;
	}

	public void setItFields(boolean itFields) {
		this.itFields = itFields;
	}

	public boolean isItWork() {
		return itWork;
	}

	public void setItWork(boolean itWork) {
		this.itWork = itWork;
	}

	public enum Education {
		BEHS, College, Master, Others
	}
}
