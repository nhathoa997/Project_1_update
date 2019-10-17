package com.ex.event;

import org.springframework.stereotype.Component;

@Component(value="awesomeBean")
public class EventService {
	
	public void runLongTimer(){
		System.out.println("---------------------");
		System.out.println("Hello World");
		System.out.println("---------------------");
	}
	
	public void runMediumTimer(){
		System.out.println("---------------------");
		System.out.println("Timer is running");
		System.out.println("---------------------");
	}
	
	public void runShortTimer(){
		System.out.println("---------------------");
		System.out.println("Timer is running");
		System.out.println("---------------------");
	}
	
}
