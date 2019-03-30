package com.jdc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApplicationTest {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("mydatabase");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}
	
	@Test
	void test() {
		
		EntityManager em  = emf.createEntityManager();
		
		EntityTransaction trans = em.getTransaction();
		
		try {
			
			trans.begin();
			
			// business logics
			
			trans.commit();
			
			
		} catch (Exception e) {
			trans.rollback();
		}
		
		em.close();
		
	}

}
