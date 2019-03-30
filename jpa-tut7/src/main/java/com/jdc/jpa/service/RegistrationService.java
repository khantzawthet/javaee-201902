package com.jdc.jpa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.jpa.entity.Registration;
import com.jdc.jpa.entity.Room;

@LocalBean
@Stateless
public class RegistrationService {
	
	@PersistenceContext
	private EntityManager em;

	public Registration findById(int id) {
		return em.find(Registration.class, id);
	}

	public List<Registration> search(Room room, String customer) {
		
		StringBuffer sb = new StringBuffer("select d from Registration d where 1 = 1");
		Map<String, Object> params = new HashMap<>();
		
		if(null != room) {
			sb.append(" and d.room = :room");
			params.put("room", room);
		}
		
		if(null != customer && !customer.isEmpty()) {
			sb.append(" and lower(d.customer) like lower(:customer)");
			params.put("customer", customer.concat("%"));
		}
		
		TypedQuery<Registration> query = em.createQuery(sb.toString(), Registration.class);
		
		for(String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		
		return query.getResultList();
	}

	public void save(Registration registration) {

		if(registration.getCheckOut().isBefore(registration.getCheckIn())) {
			throw new BusinessException("Check In date must be earlier than Check Out date.");
		}
		
		em.merge(registration);
	}

	
}
