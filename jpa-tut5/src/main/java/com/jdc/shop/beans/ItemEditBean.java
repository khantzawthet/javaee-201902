package com.jdc.shop.beans;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shop.entity.Category;
import com.jdc.shop.entity.Item;
import com.jdc.shop.service.CategoryService;
import com.jdc.shop.service.ItemService;

@Named
@ViewScoped
public class ItemEditBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;
	private List<Category> categories;

	@Inject
	private CategoryService catService;
	@Inject
	private ItemService itemService;
	
	@PostConstruct
	private void init() {

		item = new Item();
		item.getTags().add("");
		categories = catService.getAll();
	}

	public String save() {
		List<String> tags = item.getTags().stream()
				.filter(a -> a != null && !a.isEmpty())
				.collect(Collectors.toList());
		
		item.setTags(tags);
		
		itemService.save(item);
		return "/items?faces-redirect=true";
	}

	public void addTag() {
		item.getTags().add("");
	}

	public void removeTag() {
		item.getTags().remove(item.getTags().size() - 1);
		if(item.getTags().size() == 0) {
			addTag();
		}
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Category> getCategories() {
		return categories;
	}

}
