package com.nnk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut(" execution(* com.nnk.*.*(..))")
	public void logMethodBefore(JoinPoint joinPoint){
		
		log.info("Before Executing Method:"+joinPoint.toString());
		
	}
	
	@After(value = "execution(* com.nnk.*.*(..))")
	public void logMethodAfter(JoinPoint joinPoint){
		
		log.info("AFter Executing Method:"+joinPoint.toString());
		
	}
}
