package com.jdc.registration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class StudentRepository {
	
	private Student student;
	private List<Student> students;
	
	@Inject
	@Generator
	private NumberGenerator gen;
	
	@PostConstruct
	private void init() {
		student = new Student();
		students = new ArrayList<>();
	}
	
	public String save() {
		student.setId(gen.generate());
		students.add(student);
		
		student = new Student();
		return null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
}
