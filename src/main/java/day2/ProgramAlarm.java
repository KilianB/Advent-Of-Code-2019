package day2;

import java.io.IOException;
import java.util.Arrays;

import util.InputReader;

public class ProgramAlarm {

	private static final int HALT = 99;
	private static final int ADD = 0x01;
	private static final int MULT = 0x02;

	private int[] initialProgMem;
	private int[] progMem;

	private int pointer = 0;

	public static void main(String[] args) {
		// part1();
		part2();
	}

	private static void part2() {
		// Part 2
		ProgramAlarm prog = new ProgramAlarm("inputDay2.dat");

		for (int noun = lowerRange; noun < upperRange; noun++) {
			for (int verb = lowerRange; verb < upperRange; verb++) {
				int[] res = prog.compute(noun, verb);
				if (res[0] == expectedOutput) {
					System.out.println("Solution found: " + noun + " " + verb + " " + (noun*100 + verb));
				}
			}
		}
	}
	
	private static void part1() {
		// Part 1
		System.out.println(Arrays.toString(new ProgramAlarm("inputDay2.dat").compute(0, 2)));
	}

	public ProgramAlarm(String fileName) {
		// Load input
		try (var input = new InputReader(fileName)) {
			initialProgMem = input.asInt(",");
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public int[] compute(int noun, int verb) {
		pointer = 0;
		progMem = initialProgMem.clone();

		progMem[1] = noun;
		progMem[2] = verb;

		run();
		// System.out.println("Result: " + progMem[0]);
		// System.out.println("Dump: " + Arrays.toString(progMem));
		return progMem;
	}

	private void run() {
		while (true) {
			int opCode = progMem[pointer];
			switch (opCode) {
			case HALT:
				return;
			case ADD:
				add(progMem[pointer + 1], progMem[pointer + 2], progMem[pointer + 3]);
				break;
			case MULT:
				mult(progMem[pointer + 1], progMem[pointer + 2], progMem[pointer + 3]);
				break;
			}
			pointer += 4;
		}
	}

	private void add(int x, int y, int storeLoc) {
		progMem[storeLoc] = progMem[x] + progMem[y];
	}

	private void mult(int x, int y, int storeLoc) {
		progMem[storeLoc] = progMem[x] * progMem[y];
	}

	// Part 2

	private final static int expectedOutput = 19690720;

	private static final int lowerRange = 0;
	private static final int upperRange = 99;

	// 0 , 2



}
