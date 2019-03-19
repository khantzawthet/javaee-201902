package com.jdc.registration;

import java.io.Serializable;

public class Education implements Serializable {

	private static final long serialVersionUID = 1L;

	private String major;
	private String college;
	private String year;
	
	@Override
	public String toString() {
		return String.format("%s, %s, %s", major, year, college);
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
