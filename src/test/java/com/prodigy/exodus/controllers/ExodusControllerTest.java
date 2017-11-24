package com.prodigy.exodus.controllers;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Teams;
import com.prodigy.exodus.services.ExodusService;
import com.prodigy.exodus.services.MessageService;

@RunWith(MockitoJUnitRunner.class)
public class ExodusControllerTest {

	@Mock private ExodusService exodusServiceMock;
	@Mock private MessageService msgServiceMock;
	@Mock private Teams teamsMock;
	@Mock private ExodusResponse exodusResponseMock;
	
	@InjectMocks
	private ExodusController underTest;
	
	@Before
	public void setup() throws Exception {
		// do nothing for now
	}
	
	@Test
	public void testPostBody() throws Exception {
		when(exodusServiceMock.process(teamsMock)).thenReturn(exodusResponseMock);
		underTest.postBody(teamsMock);
	}
	
	@Test
	public void testMessage() throws Exception {
		underTest.getMessage();
	}
	
}
