package com.prodigy.exodus.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Teams;
import com.prodigy.exodus.rabbitmq.RabbitService;
import com.prodigy.exodus.services.ExodusService;
import com.prodigy.exodus.services.MessageService;

@RunWith(MockitoJUnitRunner.class)
public class ExodusControllerTest {

	@Mock private ExodusService exodusServiceMock;
	@Mock private MessageService messageServiceMock;
	@Mock private Teams teamsMock;
	@Mock private ExodusResponse exodusResponseMock;
	@Mock private RabbitService rabbitServiceMock;
	
	@InjectMocks
	private ExodusController underTest;
	
	@Before
	public void setup() throws Exception {
		// do nothing for now
	}
	
	@Test
	public void testPostBody() throws Exception {
		when(exodusServiceMock.process(teamsMock)).thenReturn(exodusResponseMock);
		assertEquals(underTest.postBody(teamsMock), exodusResponseMock);
		verify(exodusServiceMock, times(1)).process(teamsMock);
	}
	
	@Test
	public void testMessage() throws Exception {
		underTest.getMessage();
		verify(messageServiceMock, times(1)).getMessage();
	}
	
	@Test
	public void testPublishToRabbit() throws Exception {
		when(rabbitServiceMock.sendToQueue("test")).thenReturn("SendToQueue");
		assertEquals(underTest.publishToRabbit("test"), "SendToQueue");
		verify(rabbitServiceMock, times(1)).sendToQueue("test");
	}
	
}
