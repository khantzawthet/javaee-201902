package com.jdc.upload;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.upload.entity.Purchase;

@LocalBean
@Stateless
public class PurchaseService {
	
	@PersistenceContext
	private EntityManager em;

	@Named
	@Produces
	@SuppressWarnings("unchecked")
	public List<Purchase> getPurchaseList() {
		return em.createNativeQuery("select * from Purchase", Purchase.class).getResultList();
	}
}
