package com.jdc.registration;

@Generator
public class NumberGeneratorImpl implements NumberGenerator{

	private int id;
	
	@Override
	public String generate() {
		return String.format("SE-%03d", ++id);
	}
}
