package com.prodigy.exodus.services;

import org.springframework.stereotype.Service;

import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Teams;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExodusService {
	
	public ExodusResponse process(Teams teams) {
		ExodusResponse exodusResponse = new ExodusResponse();
		
		exodusResponse.setName(teams.getAvengers().get(0).getName());
		exodusResponse.setCodename(teams.getAvengers().get(0).getCodename());
		return exodusResponse;
	}

}
