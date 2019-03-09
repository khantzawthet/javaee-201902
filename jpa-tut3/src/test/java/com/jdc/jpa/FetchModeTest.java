package com.jdc.jpa;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FetchModeTest {
	
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
	void test1() {
		em.getTransaction().begin();
		
		Category c = new Category();
		c.setName("Foods");
		
		Item i1 = new Item();
		i1.setPrice(3000);
		i1.setName("Humberger");
		c.add(i1);
		
		Item i2 = new Item();
		i2.setPrice(2000);
		i2.setName("Hotdog");
		c.add(i2);

		em.persist(c);
		
		em.getTransaction().commit();
	}
	
	@Test
	void test2() {
		
		Category c = em.getReference(Category.class, 1);
		assertEquals("Foods", c.getName());

		Item item = em.find(Item.class, 1);
		assertEquals("Foods", item.getCategory().getName());
		
	}
	
	

}
