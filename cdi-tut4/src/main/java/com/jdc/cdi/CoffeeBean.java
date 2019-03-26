package com.jdc.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.jdc.cdi.decorator.Coffee;
import com.jdc.cdi.decorator.CoffeeMaker;

@Model
public class CoffeeBean {

	private Coffee coffee;
	
	@Inject
	private CoffeeMaker maker;
	
	@PostConstruct
	private void init() {
		coffee = maker.make();
	}
	
	public Coffee getCoffee() {
		return coffee;
	}
}
