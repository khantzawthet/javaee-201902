package com.jdc.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jdc.jsf.Student.Education;

@Named("sr")
@RequestScoped
public class StudentRegistration {

	private Student student;
	
	@PostConstruct
	public void init() {
		student = new Student();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String save() {
		return "details";
	}
	
	public Education[] getEducations() {
		return Education.values();
	}
	
	public String[] getInterests() {
		return new String[]{"Java SE", "Java EE", "Java Web", "Spring", "Android"};
	}

}
