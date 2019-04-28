package com.jdc.timer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DependsOn("MessageBean")
public class MessageGenerator {

	private int times;
	
	@EJB
	private MessageBean bean;
	
	@Schedule(hour = "*", minute = "*", second = "*/30")
	public void geneate() {
		times++;

		String message = String.format("%d - %s Message", times, 
				LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		
		bean.add(message);
		
		System.out.println(message);
	}
}
