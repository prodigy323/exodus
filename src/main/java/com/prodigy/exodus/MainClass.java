package com.prodigy.exodus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainClass {
	
	private MainClass() {
		throw new AssertionError("Instantiating utility class...");
	}

	public static void main(String[] args) {
		log.info("this is the main class");
	}

}
