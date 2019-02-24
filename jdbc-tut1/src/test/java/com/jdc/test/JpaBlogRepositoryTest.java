package com.jdc.test;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.blog.enitty.Blog;
import com.jdc.blog.enitty.JpaBlogRepository;

class JpaBlogRepositoryTest {
	
	static EntityManagerFactory emf;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jdbc-tut1");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@Test
	void test() {
		JpaBlogRepository repo = new JpaBlogRepository(emf.createEntityManager());

		Blog b = new Blog();
		b.setTitle("From JPA");
		b.setBody("Insert from JPA");
		b.setUser("JPA");
		
		repo.insert(b);
		
		List<Blog> list = repo.selectAll();
		
		for(Blog blog : list) {
			System.out.println(blog.getTitle());
		}

	}

}
