package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class SampleServiceTests {
	@Autowired
	private	SampleService service;
	@Test
	public void TestDoadd() {
		try {
			log.info("결과값 "+service.doAdd("1", "2"));
		} catch (Exception e) {
			log.info("오류발생 "+ e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void TestBefore() {
		
		try {
			log.info("결과값 "+ service.doAdd("3","4"));
		} catch (Exception e) {
			log.info("TestBefore 에러");
			e.printStackTrace();
		}
		
	}
	@Test
	public void TestAfterThrowing() {
		
		try {
			log.info("결과값 "+ service.doAdd("ㄱ","4"));
		} catch (Exception e) {
			log.info("TestBefore 에러");
			e.printStackTrace();
		}
		
	}
	
}
