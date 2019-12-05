package day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecureContainerTest {

	@Test
	void test() {
		assertTrue(new SecureContainer(0,9999999).isValidNumber(111111));
	}
	
	@Test
	void testFailIncrease() {
		assertFalse(new SecureContainer(0,9999999).isValidNumber(223450));
	}
	
	@Test
	void testFailNoDouble() {
		assertFalse(new SecureContainer(0,9999999).isValidNumber(123789));
	}
	
	
}
