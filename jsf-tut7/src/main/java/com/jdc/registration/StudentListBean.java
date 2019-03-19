package com.jdc.registration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named
public class StudentListBean {

	private List<Student> list;
	
	@PostConstruct
	private void init() {
		list = new ArrayList<>();
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
	
	public void addStudent(Student student) {
		list.add(student);
	}
}
