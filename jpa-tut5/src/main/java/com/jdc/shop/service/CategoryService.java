package com.jdc.shop.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.shop.entity.Category;

@Stateless
@LocalBean
public class CategoryService {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Event<Category> event;

	public List<Category> getAll() {
		
		TypedQuery<Category> query = em.createNamedQuery("Category.getAll", Category.class);
		return query.getResultList();
	}

	public void save(Category category) {
		em.persist(category);
		event.fire(category);
	}

	public Category findById(int id) {
		return em.find(Category.class, id);
	}
}
