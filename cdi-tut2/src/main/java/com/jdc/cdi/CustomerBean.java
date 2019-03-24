package com.jdc.cdi;

import java.time.DayOfWeek;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class CustomerBean {

	private List<Customer> list;
	private String name;
	
	@Inject
	private DayOfWeek[] days;
	
	private DayOfWeek day;
	
	@Inject
	private CustomerModel model;
	
	@PostConstruct
	private void init() {
		list = model.findAll();
	}
	
	public String search() {
		list = model.findByName(name);
		return null;
	}

	public DayOfWeek[] getDays() {
		return days;
	}

	public void setDays(DayOfWeek[] days) {
		this.days = days;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
