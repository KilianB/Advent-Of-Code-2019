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
	
	//Part2
	
	@Test
	void testPart2() {
		//Part 2 
		assertFalse(new SecureContainer2(0,9999999).isValidNumber(111111));
	}
	
	@Test
	void testFailIncreasePart2() {
		assertFalse(new SecureContainer2(0,9999999).isValidNumber(223450));
	}
	
	@Test
	void testFailNoDoublePart2() {
		assertFalse(new SecureContainer2(0,9999999).isValidNumber(123789));
	}
	
	@Test
	void testSucessPart2() {
		assertTrue(new SecureContainer2(0,9999999).isValidNumber(112233));
	}
	
	@Test
	void testFailLargerGroupPart2() {
		assertFalse(new SecureContainer2(0,9999999).isValidNumber(123444));
	}
	
	@Test
	void testSucessRepeatedPart2() {
		assertTrue(new SecureContainer2(0,9999999).isValidNumber(111122));
	}
	
}
