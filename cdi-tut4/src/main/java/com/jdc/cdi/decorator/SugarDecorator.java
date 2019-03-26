package com.jdc.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class SugarDecorator implements CoffeeMaker{
	
	@Inject
	@Delegate
	private CoffeeMaker maker;

	@Override
	public Coffee make() {
		Coffee coffee = maker.make();
		coffee.setSugar(3);
		return coffee;
	}

}
