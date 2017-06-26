package com.prodigy.exodus;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddNumbersTest {

	@Test
	public void testAddTwoNumbers() {
		AddNumbers mytest = new AddNumbers();
		assertEquals(15, mytest.addTwoNumbers());
	}

}
