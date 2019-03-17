package com.jdc.jsf.domain;

import java.io.Serializable;

public class Profile implements Serializable{

	private static final long serialVersionUID = 1L;

	private String college;
	private String work;
	private String greeting;

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
