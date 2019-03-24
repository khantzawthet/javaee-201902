package com.jdc.shop.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.shop.entity.Category;
import com.jdc.shop.service.CategoryService;

@Model
public class CategoryManagementBean {

	private Category category;

	@Inject
	private CategoryService service;
	
	@PostConstruct
	private void init() {
		category = new Category();
	}

	public String addNew() {
		service.save(category);
		return "/categories?faces-redirect=true";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
