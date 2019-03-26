package com.jdc.cdi.decorator;

public class DefaultMaker implements CoffeeMaker{

	@Override
	public Coffee make() {
		
		Coffee coffee = new Coffee();
		coffee.setCoffee("Java Coffee");
		return coffee;
	}
	
}
