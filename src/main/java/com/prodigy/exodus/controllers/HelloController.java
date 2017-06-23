package com.prodigy.exodus.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodigy.exodus.config.ExodusConfig;
import com.prodigy.exodus.models.Teams;
import com.prodigy.exodus.services.ExodusResponse;
import com.prodigy.exodus.services.ExodusService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class HelloController {
	
	// Testing @Value properties - works here
	@Value("${app.myprop}")
	private String myprop;
	
	ExodusService exodusService = new ExodusService();
	
	@RequestMapping(value = "/foo", method = RequestMethod.POST, consumes = "application/json")
	public ExodusResponse postBody(@RequestBody Teams teams) {
		log.info(myprop);
		return exodusService.process(teams);
	}

}
