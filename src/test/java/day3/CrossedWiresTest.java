package day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CrossedWiresTest {

	@Test
	void test() {
		assertEquals(159, new CrossedWires().compute("inputDay3Test.dat"));
	}

	@Test
	void test2() {
		assertEquals(135, new CrossedWires().compute("inputDay3Test2.dat"));
	}

}
