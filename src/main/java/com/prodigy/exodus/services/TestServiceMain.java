package com.prodigy.exodus.services;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestServiceMain {
	
	@Autowired
	TestServiceToInject mock1;
	
	@Autowired
	TestServiceToInject2 mock2;
	
	public void mainService() {
		log.info("In the TestServiceMain");
		
		String mock1String = mock1.getString();
		String mock2String = mock2.getString();
		
		log.info(mock1String);
		log.info(mock2String);
	}
	
	

}
