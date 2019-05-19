package com.jdc.student.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class OfficeStaff extends Member {

	private static final long serialVersionUID = 1L;

	private LocalDate entrance;

	public LocalDate getEntrance() {
		return entrance;
	}

	public void setEntrance(LocalDate entrance) {
		this.entrance = entrance;
	}

}
