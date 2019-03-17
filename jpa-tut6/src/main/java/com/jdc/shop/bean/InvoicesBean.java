package com.jdc.shop.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.shop.entity.Invoice;
import com.jdc.shop.service.InvoiceService;

@Model
public class InvoicesBean {

	private List<Invoice> list;

	@Inject
	private InvoiceService service;

	@PostConstruct
	private void init() {
		list = service.getAll();
	}

	public List<Invoice> getList() {
		return list;
	}

	public void setList(List<Invoice> list) {
		this.list = list;
	}

}
