package com.jdc.ejb.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.ejb.entity.Shout;

@LocalBean
@Stateless
public class ShoutService {

	@Inject
	private ShoutIdGenerator generator;
	
	@PersistenceContext
	private EntityManager em;
	
	public void shout(String message) {
		
		Shout shout = new Shout();
		shout.setMessage(message);
		shout.setId(generator.generate());
		
		em.merge(shout);
	}
	
	public List<Shout> findAll() {
		return em.createNamedQuery("Shout.findAll", Shout.class)
				.getResultList();
	}
}
