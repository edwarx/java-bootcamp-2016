package com.globant.Topic1;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

	public void test () {
	assertTrue("Test succesfully executed", true);	
	Logger log = LogManager.getLogger(SimpleTest.class);
	log.info("Logged");
	}
}
