package com.prodigy.exodus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodigy.exodus.config.ExodusConfig;
import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Teams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExodusService {
	
	@Autowired
	private ExodusConfig exodusConfig;
	
	public ExodusResponse process(Teams teams) {
		ExodusResponse exodusResponse = new ExodusResponse();
		
		// Testing @ConfigurationProperties
		log.info("inside service: comment ==> " + exodusConfig.getComment());
		
		exodusResponse.setName(teams.getAvengers().get(0).getName());
		exodusResponse.setCodename(teams.getAvengers().get(0).getCodename());
		return exodusResponse;
	}

}
