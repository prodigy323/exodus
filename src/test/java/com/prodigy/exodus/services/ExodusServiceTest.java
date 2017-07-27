package com.prodigy.exodus.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.prodigy.exodus.config.ExodusConfig;
import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Heroes;
import com.prodigy.exodus.models.Teams;

@RunWith(MockitoJUnitRunner.class)
public class ExodusServiceTest {

	private @Mock ExodusConfig exodusConfigMock;
	private @Mock Teams teamsMock;
	private @Mock List<Heroes> heroesListMock;
	private @Mock Heroes heroesMock;
	
	@InjectMocks
	private ExodusService sut;
	
	@Test
	public void process_ShouldReturnExodusResponse() {
		// given
		when(exodusConfigMock.getComment()).thenReturn("This is a comment.");
		when(teamsMock.getAvengers()).thenReturn(heroesListMock);
		when(heroesListMock.get(anyInt())).thenReturn(heroesMock);
		when(heroesMock.getName()).thenReturn("Tony Stark");
		when(heroesMock.getCodename()).thenReturn("IronMan");
		
		// when
		ExodusResponse response = sut.process(teamsMock);
		
		// then
		assertEquals("Tony Stark", response.getName());
		assertEquals("IronMan", response.getCodename());
		verify(teamsMock, times(2)).getAvengers();
	}
}
