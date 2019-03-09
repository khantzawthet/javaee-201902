package com.jdc.jpa.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.jpa.entity.Course;
import com.jdc.jpa.entity.Course.Level;
import com.jdc.jpa.service.CourseService;

@Model
public class CourseEditBean {

	private Course course;
	
	@PostConstruct
	private void init() {
		course = new Course();
	}

	@Inject
	private CourseService service;

	public String save() {
		service.save(course);
		return "/index?faces-redirect=true";
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Level[] getLevels() {
		return Level.values();
	}

}
