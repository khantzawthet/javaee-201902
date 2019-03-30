package com.jdc.jpa.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.jpa.entity.Room;

@LocalBean
@Stateless
public class RoomService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Event<Room> event;

	public List<Room> getAll() {
		return em.createNamedQuery("Room.getAll", Room.class)
				.getResultList();
	}

	public Room findById(int id) {
		return em.find(Room.class, id);
	}

	public void save(Room room) {
		em.merge(room);
		
		event.fire(room);
	}

}
