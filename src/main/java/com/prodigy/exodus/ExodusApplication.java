package com.prodigy.exodus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.prodigy.exodus.config.ExodusConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(ExodusConfig.class)
public class ExodusApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExodusApplication.class, args);
	}

}
