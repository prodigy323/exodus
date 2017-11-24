package com.prodigy.exodus.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {
	
	@InjectMocks
	private MessageService underTest;
	
	@Test
	public void getMessage() {
		ReflectionTestUtils.setField(underTest, "message", "foobar");
		underTest.getMessage();
	}

}
