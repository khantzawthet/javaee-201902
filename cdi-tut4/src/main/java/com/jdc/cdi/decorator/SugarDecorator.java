package com.jdc.cdi.decorator;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Priority(300)
@Decorator
public class SugarDecorator implements CoffeeMaker{
	
	@Inject
	@Delegate
	private CoffeeMaker maker;

	@Override
	public Coffee make() {
		Coffee coffee = maker.make();
		coffee.setSugar(3);
		System.out.println("Sugar Decorator");
		return coffee;
	}

}
