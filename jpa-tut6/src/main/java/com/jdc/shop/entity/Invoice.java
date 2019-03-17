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
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.OneToMany;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;

@Entity
@NamedQuery(name = "Invoice.getAll", query = "select i from Invoice i")
public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime invoiceTime;
	@ManyToOne(cascade = { PERSIST, MERGE })
	private Member customer;
	@OneToOne(cascade = { PERSIST, MERGE })
	private Address address;

	@OneToOne(cascade = { PERSIST, MERGE })
	private BillingInformation billingInfo;
	@OneToMany(mappedBy = "invoice", cascade = { PERSIST, MERGE })
	private List<OrderDetails> orders;
	
	public Integer getSubTotal() {
		return orders.stream().mapToInt(a -> a.getQuentity() * a.getUnitPrice()).sum();
	}
	
	public Integer getTax() {
		Double tax = getSubTotal() * 0.05;
		return tax.intValue();
	}
	
	public Integer getTotal() {
		return getSubTotal() + getTax();
	}
	
	public Invoice() {
		orders = new ArrayList<>();
		customer = new Member();
		address = new Address();
		billingInfo = new BillingInformation();
	}
	
	@PrePersist
	private void prePersit() {
		invoiceTime = LocalDateTime.now();
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
		
		for(OrderDetails od : orders) {
			od.setInvoice(this);
		}
	}

}
