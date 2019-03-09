package com.jdc.jpa.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jdc.jpa.entity.Course;

@LocalBean
@Stateless
public class CourseService {

	@PersistenceContext
	private EntityManager em;

	public void save(Course course) {
		em.persist(course);
	}

	public List<Course> getAll() {
		TypedQuery<Course> query = em.createQuery("select c from Course c", Course.class);
		return query.getResultList();
	}
}
