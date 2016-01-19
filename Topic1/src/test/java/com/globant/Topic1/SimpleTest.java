package com.globant.Topic1;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

	public void test () {
	Person p = new Person("Cristiano", "Ronaldo", 31);
	assertNotNull(p);
	assertEquals(p.getName(), "Cristiano");
	assertEquals(p.getSurname(), "Ronaldo");
	assertEquals(p.getAge(), 31);
	}
}
