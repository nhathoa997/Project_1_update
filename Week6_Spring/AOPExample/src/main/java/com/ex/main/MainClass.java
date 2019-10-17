package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.event.EventService;

import java.util.Date;

public class MainClass {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");

		EventService eventService = (EventService) applicationContext.getBean("awesomeBean");

		eventService.runShortTimer();
//		System.out.println();
//		eventService.runMediumTimer();
//		System.out.println();
//		eventService.runLongTimer();

	}
}
