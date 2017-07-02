package com.prodigy.exodus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app.exodus")
public class ExodusConfig {
	
	private String appname;
	private String comment;

}
