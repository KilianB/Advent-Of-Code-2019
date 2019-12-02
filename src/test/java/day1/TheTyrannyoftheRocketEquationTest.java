package day1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TheTyrannyoftheRocketEquationTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testPart1() {
		assertEquals(654,TheTyrannyoftheRocketEquation.convertMass(1969));
	}

	@Test
	void testPart1_2() {
		assertEquals(33583,TheTyrannyoftheRocketEquation.convertMass(100756));
	}
	
	@Test
	void testPart2() {
		assertEquals(2,TheTyrannyoftheRocketEquation.solveMassIterratively(14));
	}

	@Test
	void testPart2_2() {
		assertEquals(966,TheTyrannyoftheRocketEquation.solveMassIterratively(1969));
	}
	
	@Test
	void testPart2_3() {
		assertEquals(50346,TheTyrannyoftheRocketEquation.solveMassIterratively(100756));
	}
	
	
}
