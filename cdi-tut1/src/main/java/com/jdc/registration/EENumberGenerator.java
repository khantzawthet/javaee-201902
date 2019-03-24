package com.jdc.registration;

@Generator("EE")
public class EENumberGenerator implements NumberGenerator{

	private int id;
	
	@Override
	public String generate() {
		return String.format("EE-%04d", ++id);
	}
}
