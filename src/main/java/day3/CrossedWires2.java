package day3;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.InputReader;

public class CrossedWires2 {

	HashMap<Point, Integer> cable0Location = new HashMap<>();
	List<Point[]> crossings = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println(new CrossedWires2().compute("inputDay3.dat"));
	}

	enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	/**
	 * Compute the minimum manhatten distance for the closest crossing of two cables
	 * 
	 * @param fileName the input file with the instructions
	 * @return the min manhatten distance
	 */
	int compute(String fileName) {
		try (var in = new InputReader(fileName)) {

			// Load instructions
			List<Instruction> cable0 = parseInstruction(in.next());
			List<Instruction> cable1 = parseInstruction(in.next());

			return traceCable(cable0, cable1);
		} catch (IOException io) {
			io.printStackTrace();
			System.exit(-1);
		}

		// Does not happen
		return -1;

	}

	List<Instruction> parseInstruction(String inStr) {
		String[] tokens = inStr.split(",");

		var instructions = new ArrayList<Instruction>();

		for (var token : tokens) {

			Direction dir = null;

			switch (token.charAt(0)) {
			case 'R':
				dir = Direction.RIGHT;
				break;
			case 'U':
				dir = Direction.UP;
				break;
			case 'D':
				dir = Direction.DOWN;
				break;
			case 'L':
				dir = Direction.LEFT;
				break;
			}

			// Amount
			int amount = Integer.parseInt(token.substring(1));
			instructions.add(new Instruction(dir, amount));
		}

		return instructions;
	}

	// TODO we could use mutable integer and make it thread safe ...
	int curX;
	int curY;
	int counter;

	int traceCable(List<Instruction> instructions, List<Instruction> instructions1) {

		curX = 0;
		curY = 0;
		counter = 0;

		// Cable 0
		for (var instruction : instructions) {
			for (int i = 0; i < instruction.amount; i++) {
				cable0Location.put(computePoint(instruction.dir), counter);
			}
		}

		// Cable 1
		curX = 0;
		curY = 0;
		counter = 0;

		int curBestDistance = Integer.MAX_VALUE;

		for (var instruction : instructions1) {
			for (int i = 0; i < instruction.amount; i++) {
				// It's only increasing so we can get away without storing
				Point cable2Location = computePoint(instruction.dir);
				if (cable0Location.containsKey(cable2Location)) {
					int distToCross = cable0Location.get(cable2Location) + counter;
					if (distToCross < curBestDistance) {
						curBestDistance = distToCross;
					}
				}
			}
		}

		/*
		 * java.awt.Point[x=146,y=46] 
		 * java.awt.Point[x=155,y=11]
		 * java.awt.Point[x=155,y=4] 
		 * java.awt.Point[x=158,y=-12] 
		 * Min Dist: 159
		 * java.awt.Point[x=155,y=4]
		 * 
		 */

		return curBestDistance;

	}

	Point computePoint(Direction dir) {
		switch (dir) {
		case UP:
			curY++;
			break;
		case DOWN:
			curY--;
			break;
		case LEFT:
			curX--;
			break;
		case RIGHT:
			curX++;
			break;
		}
		counter++;
		return new Point(curX, curY);
	}

	class Instruction {
		Direction dir;
		int amount;

		public Instruction(Direction dir, int amount) {
			this.dir = dir;
			this.amount = amount;
		}
	}

}
