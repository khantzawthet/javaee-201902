package com.jdc.shop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import static javax.persistence.FetchType.EAGER;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
	private Category category;
	
	@ElementCollection(fetch = EAGER)
	private List<String> tags;
	private int price;
	
	private LocalDateTime creation;
	private LocalDateTime modification;
	
	public Item() {
		tags = new ArrayList<>();
	}
	
	@PrePersist
	private void prePersist() {
		creation = LocalDateTime.now();
		modification = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
		modification = LocalDateTime.now();
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public LocalDateTime getModification() {
		return modification;
	}

	public void setModification(LocalDateTime modification) {
		this.modification = modification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
