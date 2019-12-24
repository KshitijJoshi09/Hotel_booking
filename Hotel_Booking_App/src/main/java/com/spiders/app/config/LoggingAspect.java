package com.spiders.app.config;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {

	Logger log = Logger.getLogger(LoggingAspect.class);

	// @After("within(com.spiders.app.controller..*) ")
	// @Before("within(com.spiders.app.controller..*) ")
	
	// more expression 
	
	// this will execute for all methods in the clss
	// "execution(* com.test.ClassName.*(..))"
	
	// this will execute for particular method 
	// "execution(* com.test.ClassName.MehtodName(..))"
	
	// this will exicute for all the methods with name stating with 
	// "execution(* com.test.ClassName.PartialMethdName*(..))"
	
	
	// "execution(* com.test.ClassName.*(..))"
	// "execution(* com.test.ClassName.*(..))"
	
	// this will execute for all the public methods in project
	// "execution(public * *(..))"
	
	// this will execute for the last package and .. means all the packages iside it
	// "within(com.spiders.app.controller..*)"
	
	
	// logical operation can be applied on it
	// anyPublicOperation() && inTrading()
	
	
	@Around("within(com.spiders.app.controller..*) ")
	//@Around("execution(public * *(..))")
	//@Around("execution(* set*(..))")
	public Object Advice(ProceedingJoinPoint point) throws Throwable {

		Signature signature = point.getSignature();
		//log.trace(signature.toString());
		Object obj = point.proceed();
		
		/*
		 * System.out.println("naem " +signature.getName());;
		 * System.out.println("modifier "+Modifier.toString(signature.getModifiers()));
		 * System.out.println(obj);
		 * System.out.println(Arrays.toString(point.getArgs()));
		 */
		
		log.info(signature +" args ->"+Arrays.toString(point.getArgs()) + " result->"+obj.toString() );
		return obj;
	}
	
	

}
