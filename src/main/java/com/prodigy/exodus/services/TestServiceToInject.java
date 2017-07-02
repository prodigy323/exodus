package com.prodigy.exodus.services;

public class TestServiceToInject {
	
	private static final String FOOBAR = "foobar";
	
	public String getString() {
		return getAnotherString();
	}

	public String getAnotherString() {
		return FOOBAR;
	}
}
