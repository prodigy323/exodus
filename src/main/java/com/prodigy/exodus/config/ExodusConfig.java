package com.prodigy.exodus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "app.exodus")
public class ExodusConfig {
	
	private String appname;
	private String comment;
	private String message;

}
