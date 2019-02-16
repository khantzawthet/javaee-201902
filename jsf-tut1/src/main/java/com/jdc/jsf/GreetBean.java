package com.jdc.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class GreetBean {

	private User user;
	private String message;

	@PostConstruct
	public void init() {
		user = new User();
	}

	public String greet() {
		message = user.greet();
		return "/greet";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

}
