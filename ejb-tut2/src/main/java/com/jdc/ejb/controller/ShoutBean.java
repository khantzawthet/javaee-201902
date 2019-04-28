package com.jdc.ejb.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.ejb.entity.Shout;
import com.jdc.ejb.service.ShoutService;

@Model
public class ShoutBean {

	private String message;
	private List<Shout> shouts;
	
	@Inject
	private ShoutService service;
	
	@PostConstruct
	private void init() {
		shouts = service.findAll();
	}
	
	public String save() {
		service.shout(message);
		return "index?faces-redirect=true";
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Shout> getShouts() {
		return shouts;
	}
	public void setShouts(List<Shout> shouts) {
		this.shouts = shouts;
	}
	
	
}
