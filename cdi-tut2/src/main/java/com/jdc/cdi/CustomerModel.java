package com.jdc.cdi;

import java.util.List;

public interface CustomerModel {

	List<Customer> findAll();
	List<Customer> findByName(String name);
	
}
