package com.jdc.jpa.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jpa.entity.Registration;
import com.jdc.jpa.interceptor.ErrorHandler;
import com.jdc.jpa.producer.ParameterMap;
import com.jdc.jpa.service.RegistrationService;

@Named
@ViewScoped
public class RegistrationEditBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Registration registration;
	
	@Inject
	private RegistrationService service;
	
	@Inject
	@ParameterMap
	private Map<String, String> params;
		
	@PostConstruct
	private void postConstruct() {
		String id = params.get("id");

		if(null != id) {
			registration = service.findById(Integer.parseInt(id));
		} else {
			registration = new Registration();
		}
	}
	
	@ErrorHandler
	public String save() {
		service.save(registration);
		return "/registration-list?faces-redirect=true";
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
	public String getTile() {
		return registration.getId() == 0 ? "New Registration" : "Edit Registration";
	}
}
