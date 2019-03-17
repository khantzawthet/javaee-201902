package com.jdc.shop.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jdc.shop.entity.Invoice;
import com.jdc.shop.service.InvoiceService;

@Named
@ConversationScoped
public class CheckOutBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ShoppingCart cart;
	private Invoice invoice;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private InvoiceService service;
	
	@PostConstruct
	private void init() {
		invoice = new Invoice();
		
		if(conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public String checkOut() {
		
		// set orders to invoice
		invoice.setOrders(cart.getOrders());
		
		// insert invoice to db
		service.save(invoice);
		
		// clear cart
		cart.clear();
		
		if(!conversation.isTransient()) {
			conversation.end();
		}
		
		return "/invoices";
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
}
