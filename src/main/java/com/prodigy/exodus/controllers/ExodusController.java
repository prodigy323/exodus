package com.prodigy.exodus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodigy.exodus.config.ExodusConfig;
import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Teams;
import com.prodigy.exodus.services.ExodusService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ExodusController {
	
	@Autowired
	private ExodusConfig exodusConfig;
	
	@Autowired
	private ExodusService exodusService;
	
	@RequestMapping(value = "/foo", method = RequestMethod.POST, consumes = "application/json")
	public ExodusResponse postBody(@RequestBody Teams teams) {
		log.info("App Name is " + exodusConfig.getAppname());
		return exodusService.process(teams);
	}

}
