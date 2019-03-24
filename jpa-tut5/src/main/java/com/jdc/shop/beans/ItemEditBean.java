package com.jdc.shop.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shop.beans.dto.Tag;
import com.jdc.shop.entity.Item;
import com.jdc.shop.service.ItemService;

@Named
@ViewScoped
public class ItemEditBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Item item;

	private List<Tag> tags;

	@Inject
	private ItemService itemService;

	@PostConstruct
	private void init() {

		item = new Item();
		tags = new ArrayList<>();
		tags.add(new Tag());
		
	}

	public String save() {
		List<String> list = tags.stream().filter(a -> null != a.getValue() && !a.getValue().isEmpty())
			.map(a -> a.getValue())
			.collect(Collectors.toList());

		item.setTags(list);

		itemService.save(item);
		return "/items?faces-redirect=true";
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void addTag() {
		tags.add(new Tag());
	}

	public void removeTag() {
		tags.remove(tags.size() - 1);
		if (tags.size() == 0) {
			addTag();
		}
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
