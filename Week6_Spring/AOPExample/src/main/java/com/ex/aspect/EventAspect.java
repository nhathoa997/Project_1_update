package com.ex.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;

@Aspect
@Component
public class EventAspect {
	
//	@Before("execution(* com.ex.event.EventService.play*(..))")
//	public void setup(JoinPoint jp){
//		System.out.println("Customers sit down");
//	}
	
	@Around("execution(* com.ex.event.EventService.runShortTimer(..))")
	public void shorttimer(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("Timer is set for 5 seconds");
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;

		while (elapsedTime < 5000) {
			//perform db poll/check
			elapsedTime = (new Date()).getTime() - startTime;
		}
		
		pjp.proceed(); //method runs
		
		System.out.println("Finished running: " + elapsedTime/1000 + " seconds");
		
	}
	@Around("execution(* com.ex.event.EventService.runMediumTimer(..))")
	public void mediumTimer(ProceedingJoinPoint pjp) throws Throwable{
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;

		while (elapsedTime < 10000) {
			//perform db poll/check
			elapsedTime = (new Date()).getTime() - startTime;
		}


		System.out.println("Timer set for: 10 seconds");

		pjp.proceed(); //method runs

		System.out.println("Finished running: " + elapsedTime/1000 + " seconds");

	}
	@Around("execution(* com.ex.event.EventService.runLongTimer(..))")
	public void longTimer(ProceedingJoinPoint pjp) throws Throwable{
		long startTime = System.currentTimeMillis();
		long elapsedTime = 0L;

		while (elapsedTime < 20000) {
			//perform db poll/check
			elapsedTime = (new Date()).getTime() - startTime;
		}


		System.out.println("Timer set for: 20 seconds");

		pjp.proceed(); //method runs

		System.out.println("Finished running: " + elapsedTime/1000 + " seconds");

	}
	
	
	
}
