package com.jdc.timer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@LocalBean
@Singleton
public class MessageBean {

	private List<String> messages;

	@PostConstruct
	private void init() {
		messages = new ArrayList<>();
	}
	
	public void add(String message) {
		messages.add(message);
	}
	
	@Named
	@Produces
	public List<String> getMessages() {
		return messages;
	}
}
