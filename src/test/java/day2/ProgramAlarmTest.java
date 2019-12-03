package day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProgramAlarmTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		int[] expected = {2,0,0,0,99};
		int[] res = new ProgramAlarm().compute("inputDay2Test.dat");
		assertArrayEquals(expected, res);
	}
	
	@Test
	void test1() {
		int[] expected = {2,3,0,6,99};
		int[] res = new ProgramAlarm().compute("inputDay2Test2.dat");
		assertArrayEquals(expected, res);
	};
	
	@Test
	void test2() {
		int[] expected = {2,4,4,5,99,9801};
		int[] res = new ProgramAlarm().compute("inputDay2Test3.dat");
		assertArrayEquals(expected, res);
	};
	
	@Test
	void test3() {
		int[] expected = {30,1,1,4,2,5,6,0,99};
		int[] res = new ProgramAlarm().compute("inputDay2Test4.dat");
		assertArrayEquals(expected, res);
	};

}
