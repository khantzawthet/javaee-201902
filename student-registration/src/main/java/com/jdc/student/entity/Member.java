package com.jdc.student.entity;

public abstract class Member extends Account{

	private static final long serialVersionUID = 1L;
	
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
