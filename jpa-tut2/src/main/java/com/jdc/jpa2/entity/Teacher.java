package com.jdc.jpa2.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "TEACHER")
public class Teacher extends Account {

	@OneToMany(mappedBy = "teacher")
	private List<ClassRoom> classes;

	public List<ClassRoom> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassRoom> classes) {
		this.classes = classes;
	}

}
