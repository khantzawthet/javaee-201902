package com.jdc.shop.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shop.entity.Product;
import com.jdc.shop.service.ProductService;

@Named
@ApplicationScoped
public class ProductsBean {

	private List<Product> list;
	
	@Inject
	private ProductService service;
	
	@PostConstruct
	private void init() {
		list = service.getAll();
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
	
}
