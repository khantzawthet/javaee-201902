package com.jdc.jpa.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.jpa.entity.Course;
import com.jdc.jpa.service.CourseService;

@Model
public class CourseListBean {

	private List<Course> list;

	@Inject
	private CourseService service;

	@PostConstruct
	private void init() {
		list = service.getAll();
	}

	public List<Course> getList() {
		return list;
	}

	public void setList(List<Course> list) {
		this.list = list;
	}

}
