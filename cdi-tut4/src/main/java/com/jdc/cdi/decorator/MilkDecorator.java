package com.jdc.cdi.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Priority(400)
@Decorator
public class MilkDecorator implements CoffeeMaker{
	
	@Inject
	@Delegate
	private CoffeeMaker maker;

	@Override
	public Coffee make() {
		Coffee coffee = maker.make();
		coffee.setMilk(2);
		System.out.println("Milk Decorator");
		return coffee;
	}

}
