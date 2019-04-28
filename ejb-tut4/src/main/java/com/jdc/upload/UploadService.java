package com.jdc.upload;

import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.upload.entity.Purchase;

@LocalBean
@Stateless
public class UploadService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private SummaryService service;

	@Asynchronous
	public void upload(List<String> lines) {
		
		for(String str : lines) {
			Purchase p = new Purchase(str.split("\t"));
			em.persist(p);
		}
		
		service.createTimer();
	}
}
