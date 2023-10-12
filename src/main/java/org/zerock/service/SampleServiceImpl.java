package org.zerock.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("서비스 임플  doAdd 받음");
		return Integer.parseInt(str1)+Integer.parseInt(str2);
	}

}
