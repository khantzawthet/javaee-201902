package com.jdc.shop.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.jdc.shop.entity.OrderDetails;
import com.jdc.shop.entity.Product;

@Named
@SessionScoped
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<OrderDetails> orders;

	@PostConstruct
	private void init() {
		orders = new ArrayList<>();
	}

	public String clearItems() {
		clear();
		return "/index";
	}

	public void clear() {
		this.orders.clear();
	}

	public void add(Product p) {
		OrderDetails od = orders.stream()
				.filter(o -> o.getProduct().getId() == p.getId())
				.findFirst().orElse(null);
		
		if(null == od) {
			od = new OrderDetails();
			od.setProduct(p);
			od.setQuentity(1);
			od.setUnitPrice(p.getPrice());
			orders.add(od);
		} else {
			od.countUp();
		}
	}
	
	public void countDown(OrderDetails od) {
		od.countDown();
		if(od.getQuentity() == 0) {
			orders.remove(od);
		}
	}
	
	public int getCount() {
		return orders.stream()
				.mapToInt(od -> od.getQuentity()).sum();
	}
	
	public List<OrderDetails> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}
	
	public int getSubTotal() {
		return orders.stream().mapToInt(a -> a.getQuentity() * a.getUnitPrice()).sum();
	}
	
	public double getTax() {
		return getSubTotal() * 0.05;
	}
	
	public double getTotal() {
		return getSubTotal() * getTax();
	}

}
