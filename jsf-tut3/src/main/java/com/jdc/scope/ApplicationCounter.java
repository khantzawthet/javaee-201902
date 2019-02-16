package com.jdc.scope;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ApplicationCounter {

	private int count;
	
	public int getCount() {
		return ++ count;
	}

}
