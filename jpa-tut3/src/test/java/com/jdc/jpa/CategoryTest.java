package com.jdc.jpa;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
	
	static EntityManagerFactory emf;
	EntityManager em;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut3");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@Test
	void test() {
		
		// transient state (new state)
		Category c = new Category();

		em.getTransaction().begin();
		
		// managed state
		em.persist(c);

		// detached state
		em.clear();

		c.setName("Foods");
		
		// managed state
		c = em.merge(c);
		
		em.merge(new Category());
		
		// managed state
		Category c2 = em.find(Category.class, 2);
		c2.setName("Drinks");
		
		em.remove(c);
		
		em.getTransaction().commit();
	}

}
