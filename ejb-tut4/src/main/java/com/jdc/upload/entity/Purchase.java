package com.jdc.upload.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Purchase.getSummary", query = "select new com.jdc.upload.entity.Summary(p.category, sum(p.quentity), sum(p.total)) from Purchase p group by p.category")
public class Purchase implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String category;
	private String item;
	private long quentity;
	private long total;
	
	public Purchase() {
	}

	public Purchase(String ... data) {
		super();
		this.category = data[0];
		this.item = data[1];
		this.quentity = Long.parseLong(data[2]);
		this.total = Long.parseLong(data[3]);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public long getQuentity() {
		return quentity;
	}

	public void setQuentity(long quentity) {
		this.quentity = quentity;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
