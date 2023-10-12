package org.zerock.service;

public interface SampleService {
//public 생략 가능 인터페이스는 배포되어야 하니까!
	public Integer doAdd(String str1, String str2) throws Exception;
}
