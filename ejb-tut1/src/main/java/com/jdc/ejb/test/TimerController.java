package com.jdc.ejb.test;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TimerController implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	private TimerBean bean;
	
	private List<String> data;
	
	private String message;
	
	@PostConstruct
	private void init() {
		data = bean.getData();
	}
	
	public String save() {
		bean.add(message);
		message = null;
		return null;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getData() {
		return data;
	}
	
}
