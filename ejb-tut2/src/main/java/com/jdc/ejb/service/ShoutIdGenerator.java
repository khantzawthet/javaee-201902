package com.jdc.ejb.service;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jdc.ejb.entity.NumberTable;
import com.jdc.ejb.entity.ShoutPK;

@Startup
@Singleton
public class ShoutIdGenerator {
	
	private static final String SHOUT = "SHOUT";
	
	private LocalDate refDate;
	private int seqNumber;
	
	@PersistenceContext
	private EntityManager em;
	
	@Lock(LockType.WRITE)
	public ShoutPK generate() {
		
		if(!refDate.equals(LocalDate.now())) {
			refDate = LocalDate.now();
			seqNumber = 0;
		}
		
		return new ShoutPK(refDate, ++ seqNumber);
	}

	@PostConstruct
	private void postConstruct() {
		
		NumberTable number = em.find(NumberTable.class, SHOUT);
		
		if(null == number) {
			refDate = LocalDate.now();
			seqNumber = 0;
		} else {
			refDate = number.getRefDate();
			seqNumber = number.getSeqNumber();
		}
	}
	
	@PreDestroy
	private void preDestroy() {
		
		NumberTable number = new NumberTable();
		number.setName(SHOUT);
		number.setRefDate(refDate);
		number.setSeqNumber(seqNumber);
		
		em.merge(number);
	}
}
