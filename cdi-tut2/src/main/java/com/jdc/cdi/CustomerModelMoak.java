package com.jdc.cdi;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Alternative;

@Alternative
public class CustomerModelMoak implements CustomerModel{
	
	private List<Customer> list;
	
	@PostConstruct
	private void init() {
		list = Arrays.asList(
				new Customer(1, "Cust1", "Email1", "Phone1"),
				new Customer(2, "Cust2", "Email2", "Phone2"),
				new Customer(3, "Cust3", "Email3", "Phone3"),
				new Customer(4, "Cust4", "Email4", "Phone4"),
				new Customer(5, "Cust5", "Email5", "Phone5")
		);
	}

	@Override
	public List<Customer> findAll() {
		return list;
	}

	@Override
	public List<Customer> findByName(String name) {
		System.out.println(name);
		return list;
	}

}
