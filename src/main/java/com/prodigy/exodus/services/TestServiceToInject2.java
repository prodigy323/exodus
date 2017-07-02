package com.prodigy.exodus.services;

public class TestServiceToInject2 {
	
private static final String OXY = "oxygen";
	
	public String getString() {
		return getAnotherString();
	}

	public String getAnotherString() {
		return OXY;
	}

}
