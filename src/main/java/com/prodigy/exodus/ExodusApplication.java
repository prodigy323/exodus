package com.prodigy.exodus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.prodigy.exodus.config.ExodusConfig;

@EnableEurekaClient
@SpringBootApplication
@EnableConfigurationProperties(ExodusConfig.class)
public class ExodusApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExodusApplication.class, args);
	}

}
