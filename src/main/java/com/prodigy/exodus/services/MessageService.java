package com.prodigy.exodus.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageService {
	
	@Value("${app.exodus.message}")
	private String message;
	
	public String getMessage() {
		log.info("This is INFO: {}", message);
		log.debug("This is DEBUG: {}", message);
		
		return message;
	}

}
