package com.jdc.upload.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Summary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String category;
	private long quentity;
	private long total;

	public Summary() {
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Summary(String category, long quentity, long total) {
		super();
		this.category = category;
		this.quentity = quentity;
		this.total = total;
	}

}
