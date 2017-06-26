package com.prodigy.exodus;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
@PrepareForTest({Puppy.class})
@RunWith(PowerMockRunner.class)
public class PuppyTest {
	
	@Test
	public void testCreatPuppy() throws Exception {
		Human human = new Human("John");
		Puppy puppy = PowerMockito.mock(Puppy.class);
		
		
		Mockito.when(puppy.getName()).thenReturn("John");
		
		PowerMockito.verifyStatic(Mockito.times(1));
		String name = puppy.getName();
		
		assertEquals(name, "John");
	}
}
