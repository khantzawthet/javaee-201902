package com.jdc.shop.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shop.entity.Category;
import com.jdc.shop.service.CategoryService;

@ApplicationScoped
public class CategoryProducer {
	
	@Inject
	private CategoryService service;

	@Named
	@Produces
	private List<Category> categories;

	@PostConstruct
	private void init() {
		reaload(null);
	}
	
	public void reaload(@Observes Category c) {
		categories = service.getAll();
	}
}
