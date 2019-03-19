package com.jdc.registration;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FlowScoped("registration")
public class StudentRegistrationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Student student;

	@Inject
	private StudentListBean listBean;

	@PostConstruct
	private void init() {
		student = new Student();
	}

	public String save() {
		listBean.addStudent(student);
		return "/index";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
