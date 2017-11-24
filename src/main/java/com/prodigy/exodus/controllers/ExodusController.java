package com.prodigy.exodus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Teams;
import com.prodigy.exodus.services.ExodusService;
import com.prodigy.exodus.services.MessageService;

@RefreshScope
@RestController
@RequestMapping("/api")
public class ExodusController {
	
	@Autowired
	private ExodusService exodusService;
	
	@Autowired
	private MessageService msgSvc;
	
	@RequestMapping(value = "/foo", method = RequestMethod.POST, consumes = "application/json")
	public ExodusResponse postBody(@RequestBody Teams teams) {
		return exodusService.process(teams);
	}

    @RequestMapping("/message")
    public String getMessage() {
        return msgSvc.getMessage();
    }

}
