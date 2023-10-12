package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect //Aspect를 구현한 클래스다.
@Component // 스프링에서 관리되는 객체다.
@Log4j
public class LogAdvice {
//p.454
	//*: 모든 값을 표현 , ...:0개 이상
						// 맨앞 * 접근제한자
	//									SampleService* = 대상* 포함 모든 하위객체
	//										(..) :~ 개 이상
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("========aop를 이용한 로그 출력=======");
	}
	
	 @Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	  public void logBeforeWithParam(String str1, String str2) {

	    log.info("str1: " + str1);
	    log.info("str2: " + str2);
	  }  
	 //오류(예외가 발생되었을때만 실행)
	 @AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
	  public void logException(Exception exception) {
	    
	    log.info("Exception....!!!!");
	    log.info("exception: "+ exception);
	  
	  }

	 //메소드의 실행자체를 제어(@Around 사용할때는 void타입 불가) 
	 @Around("execution(* org.zerock.service.SampleService*.*(..))")
	  public Object logTime( ProceedingJoinPoint pjp) {
	    
	    long start = System.currentTimeMillis(); //현재 시간을 ms(밀리세컨드) 값으로 가져오기
	    
	    log.info("Target: " + pjp.getTarget()); 
	    log.info("Param: " + Arrays.toString(pjp.getArgs()));
	    
	    
	    //invoke method 
	    Object result = null;
	    
	    try {
	      result = pjp.proceed(); //해당 메소드 실행
	    } catch (Throwable e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    long end = System.currentTimeMillis();
	    
	    log.info("TIME: "  + (end - start)); //
	    
	    return result;
	  }

}
