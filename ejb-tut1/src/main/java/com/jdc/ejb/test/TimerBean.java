package com.jdc.ejb.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@LocalBean
@Stateful
public class TimerBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> data;
	
	@PostConstruct
	private void init() {
		data = new ArrayList<>();
		System.out.println("Post Construct");
	}
	
	@PrePassivate
	private void prePessivate() {
		System.out.println("Object will be pessivate soon!");
	}
	
	@PostActivate
	private void postActivate() {
		System.out.println("Object has been activated.");
	}
	
	public void add(String message) {
		data.add(message);
	}
	
	public List<String> getData() {
		return data;
	}

}
