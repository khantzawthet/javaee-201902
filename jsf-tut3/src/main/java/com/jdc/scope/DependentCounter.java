package com.jdc.scope;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class DependentCounter {
	
	private int count;
	
	public int getCount() {
		return ++ count;
	}

}
