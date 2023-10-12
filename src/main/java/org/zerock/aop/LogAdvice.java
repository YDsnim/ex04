package org.zerock.aop;

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


}
