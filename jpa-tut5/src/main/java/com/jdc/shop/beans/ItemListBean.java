package com.jdc.shop.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.shop.entity.Category;
import com.jdc.shop.entity.Item;
import com.jdc.shop.service.CategoryService;
import com.jdc.shop.service.ItemService;

@Model
public class ItemListBean {

	private Category category;
	private String name;
	private String tag;
	
	private List<Item> items;
	private List<Category> categories;
	
	@Inject
	private CategoryService catService;
	@Inject
	private ItemService itemService;

	@PostConstruct
	private void init() {
		categories = catService.getAll();
	}

	public String search() {
		items = itemService.search(category, name, tag);
		return "/items";
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public List<Category> getCategories() {
		return categories;
	}

}
