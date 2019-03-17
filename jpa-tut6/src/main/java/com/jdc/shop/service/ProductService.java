package com.jdc.shop.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.shop.entity.Product;

@Stateless
@LocalBean
public class ProductService {

	@PersistenceContext
	private EntityManager em;

	public List<Product> getAll() {
		return em.createNamedQuery("Product.getAll", Product.class).getResultList();
	}
}
