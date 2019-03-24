package com.jdc.cdi;

import java.time.DayOfWeek;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class DaysProducer {

	@Named
	@Produces
	public DayOfWeek[] getDays() {
		return DayOfWeek.values();
	}
}
