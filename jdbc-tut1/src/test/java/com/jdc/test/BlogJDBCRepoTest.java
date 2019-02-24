package com.jdc.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.blog.enitty.Blog;
import com.jdc.blog.enitty.BlogRepository;
import com.jdc.blog.enitty.JdbcBlogRepository;

class BlogJDBCRepoTest {
	
	BlogRepository repo;

	@BeforeEach
	void setUp() throws Exception {
		repo = new JdbcBlogRepository();
	}

	@Test
	void test() {
		
		Blog b = new Blog();
		b.setTitle("From Java");
		b.setBody("Insert from Java");
		b.setUser("Java");
		
		repo.insert(b);
		
		List<Blog> list = repo.selectAll();
		
		for(Blog blog : list) {
			System.out.println(blog.getTitle());
		}
	}

}
