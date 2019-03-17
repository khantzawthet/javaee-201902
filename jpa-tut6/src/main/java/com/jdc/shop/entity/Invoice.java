package com.jdc.shop.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Member customer;
	@OneToOne
	private Address address;
	private LocalDateTime invoiceTime;

	@OneToOne
	private BillingInformation billingInfo;
	@OneToMany(mappedBy = "invoice", cascade = { PERSIST, MERGE })
	private List<OrderDetails> orders;
	
	public Invoice() {
		orders = new ArrayList<>();
	}
	
	public void add(OrderDetails od) {
		od.setInvoice(this);
		orders.add(od);
	}

	public LocalDateTime getInvoiceTime() {
		return invoiceTime;
	}

	public void setInvoiceTime(LocalDateTime invoiceTime) {
		this.invoiceTime = invoiceTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getCustomer() {
		return customer;
	}

	public void setCustomer(Member customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BillingInformation getBillingInfo() {
		return billingInfo;
	}

	public void setBillingInfo(BillingInformation billingInfo) {
		this.billingInfo = billingInfo;
	}

	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}

}
