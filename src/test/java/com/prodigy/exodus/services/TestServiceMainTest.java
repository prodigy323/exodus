package com.prodigy.exodus.services;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class TestServiceMainTest {
	
	@Mock
	private TestServiceToInject mock1;
	
	@Mock
	private TestServiceToInject2 mock2;
	
	@InjectMocks
	private TestServiceMain classUnderTest;

	@Test
	public void testGetString() {
		
		when(mock1.getString()).thenReturn("aaaaa");
		when(mock2.getString()).thenReturn("bbbbb");
		
		classUnderTest.mainService();
	}

}
