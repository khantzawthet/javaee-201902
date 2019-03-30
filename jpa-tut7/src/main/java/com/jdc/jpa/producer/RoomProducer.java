package com.jdc.jpa.producer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.jpa.entity.Room;
import com.jdc.jpa.service.RoomService;

@ApplicationScoped
public class RoomProducer {
	
	@Named
	@Produces
	private List<Room> rooms;
	
	@Inject
	private RoomService service;
	
	@PostConstruct
	private void postConstruct() {
		reload(null);
	}
	
	public void reload(@Observes Room room) {
		rooms = service.getAll();
	}

}
