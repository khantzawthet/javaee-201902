package com.jdc.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CounterBean {
	
	@Named
	@Produces
	private int count;
	
	@Log
	public String countUp() {
		count ++;
		return null;
	}
	
	public int getCount() {
		return count;
	}
}
