package com.jdc.blog.repo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.jdc.blog.entity.Blog;

@ApplicationScoped
public class BlogRepository {

	private List<Blog> blogs;
	
	@PostConstruct
	private void init() {
		blogs = new ArrayList<>();
	}
	
	public void add(Blog blog) {
		blogs.add(blog);
		blog.setPostTime(LocalDateTime.now());
		
		if(blogs.isEmpty()) {
			blog.setId(1);
		} else {
			blog.setId(blogs.get(blogs.size() - 1).getId() + 1);
		}
	}
	
	public Blog findById(int id) {
		return blogs.stream()
				.filter(blog -> blog.getId() == id)
				.findFirst().orElse(null);
	}
	
	public void delete(int id) {
		Blog blog = findById(id);
		blogs.remove(blog);
	}
	
	public List<Blog> search(String title, String user) {
		
		Predicate<Blog> filter = a -> true;
		
		if(null != title && !title.isEmpty()) {
			filter = filter.and(blog -> blog.getTitle().toLowerCase().contains(title.toLowerCase()));
		}
		
		if(null != user && !user.isEmpty()) {
			filter = filter.and(blog -> blog.getUser().toLowerCase().contains(user.toLowerCase()));
		}
		
		return blogs.stream().filter(filter).collect(Collectors.toList());
	}
}
