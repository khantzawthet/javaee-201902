package com.jdc.scope;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RequestCounter {

	private int count;
	
	public int getCount() {
		return ++ count;
	}

}
