package com.prodigy.exodus.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.prodigy.exodus.config.ExodusConfig;
import com.prodigy.exodus.models.Teams;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Configuration
@PropertySource("classpath:application.properties")
public class ExodusService {
	
	private ExodusConfig config;

	public ExodusResponse process(Teams teams) {
		ExodusResponse exodusResponse = new ExodusResponse();
		
		// Testing @ConfigurationProperties
		//String prop = config.getMyprop();
		//log.info("inside service: " + myprop);
		
		exodusResponse.setName(teams.getAvengers().get(0).getName());
		exodusResponse.setCodename(teams.getAvengers().get(0).getCodename());
		return exodusResponse;
	}

}
