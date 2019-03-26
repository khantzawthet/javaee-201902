package com.jdc.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class MilkDecorator implements CoffeeMaker{
	
	@Inject
	@Delegate
	private CoffeeMaker maker;

	@Override
	public Coffee make() {
		Coffee coffee = maker.make();
		coffee.setMilk(2);
		return coffee;
	}

}
