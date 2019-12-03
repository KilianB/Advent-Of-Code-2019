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
		int[] res = new ProgramAlarm("inputDay2Test.dat").compute(0,0);
		assertArrayEquals(expected, res);
	}
	
	@Test
	void test1() {
		int[] expected = {2,3,0,6,99};
		int[] res = new ProgramAlarm("inputDay2Test2.dat").compute(3,0);
		assertArrayEquals(expected, res);
	};
	
	@Test
	void test2() {
		int[] expected = {2,4,4,5,99,9801};
		int[] res = new ProgramAlarm("inputDay2Test3.dat").compute(4,4);
		assertArrayEquals(expected, res);
	};
	
	@Test
	void test3() {
		int[] expected = {30,1,1,4,2,5,6,0,99};
		int[] res = new ProgramAlarm("inputDay2Test4.dat").compute(1,1);
		assertArrayEquals(expected, res);
	};

}
