package com.jdc.blog.enitty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class JpaBlogRepository implements BlogRepository {

	private EntityManager em;

	public JpaBlogRepository(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insert(Blog blog) {
		em.getTransaction().begin();
		em.persist(blog);
		em.getTransaction().commit();
	}

	@Override
	public List<Blog> selectAll() {
		TypedQuery<Blog> query = em.createQuery("select b from Blog b", Blog.class);
		return query.getResultList();
	}

}
