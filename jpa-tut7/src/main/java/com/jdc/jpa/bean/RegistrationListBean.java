package com.jdc.jpa.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.jpa.entity.Registration;
import com.jdc.jpa.entity.Room;
import com.jdc.jpa.service.RegistrationService;

@Model
public class RegistrationListBean {

	private Room room;
	private String customer;
	private List<Registration> registrations;
	
	@Inject
	private RegistrationService service;

	@PostConstruct
	private void init() {
		search();
	}

	public String search() {
		registrations = service.search(room, customer);
		return null;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public List<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

}
