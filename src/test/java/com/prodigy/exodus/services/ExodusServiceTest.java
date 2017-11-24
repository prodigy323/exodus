package com.prodigy.exodus.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.ImmutableList;
import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.models.Heroes;
import com.prodigy.exodus.models.Teams;

@RunWith(MockitoJUnitRunner.class)
public class ExodusServiceTest {
	
	private Teams team;

	@InjectMocks
	private ExodusService underTest;
	
	@Before
	public void setUp() throws Exception {
		Heroes ironman = Heroes.builder()
				.name("Tony Stark")
				.codename("Ironman")
				.build();
		
		Heroes captain = Heroes.builder()
				.name("Steve Rogers")
				.codename("Captain America")
				.build();
		
		Heroes wolverine = Heroes.builder()
				.name("James Logan")
				.codename("Wolverine")
				.build();
		
		Heroes cyclops = Heroes.builder()
				.name("Scott Summers")
				.codename("Cyclops")
				.build();
		
		List<Heroes> avengersList = ImmutableList.of(ironman, captain);
		List<Heroes> xmenList = ImmutableList.of(wolverine, cyclops);
		
		team = Teams.builder()
				.avengers(avengersList)
				.xmen(xmenList)
				.build();
	}
	
	@Test
	public void process_ShouldReturnExodusResponse() {
		// given
		
		// when
		ExodusResponse response = underTest.process(team);
		
		// then
		assertEquals("Tony Stark", response.getName());
		assertEquals("Ironman", response.getCodename());
	}
}
