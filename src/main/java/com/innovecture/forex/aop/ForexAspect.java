package com.innovecture.forex.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ForexAspect {
	
	

		private Logger logger=LoggerFactory.getLogger(this.getClass());
		@AfterReturning(value = "execution(* com.innovecture.forex.*.*.*(..))",
		        returning = "result")
		    public void afterReturning(JoinPoint joinPoint, Object result) {
		        logger.info("{} returned with value {}", joinPoint, result);
		    }
		
		 @Before("execution(* com.innovecture.forex.*.*.*(..))")
		    public void before(JoinPoint joinPoint) {
		        logger.info(" Enter into method "+joinPoint.getSignature());
		    }
	
}
