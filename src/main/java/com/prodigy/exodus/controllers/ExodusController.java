package com.prodigy.exodus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Teams;
import com.prodigy.exodus.rabbitmq.RabbitService;
import com.prodigy.exodus.services.ExodusService;
import com.prodigy.exodus.services.MessageService;

@RefreshScope
@RestController
@RequestMapping("/api")
public class ExodusController {
	
	@Autowired
	private ExodusService exodusService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private RabbitService rabbitService;
	
	@RequestMapping(value = "/postTeams", method = RequestMethod.POST, consumes = "application/json")
	public ExodusResponse postBody(@RequestBody Teams teams) {
		return exodusService.process(teams);
	}

    @RequestMapping("/message")
    public String getMessage() {
        return messageService.getMessage();
    }
    
    @RequestMapping(value = "/publishToRabbit", method = RequestMethod.POST)
    public String publishToRabbit(@RequestBody String request) {
        return rabbitService.sendToQueue(request);
    }
    
    @RequestMapping("/redis")
    public void getRedisService() {
        // TODO
    }

    @RequestMapping("/neo4j")
    public void getNeo4jService() {
        // TODO
    }

}
