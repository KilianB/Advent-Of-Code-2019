package day3;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import util.InputReader;

public class CrossedWires {

	HashSet<Point> cable0Location = new HashSet<>();
	List<Point> crossings = new ArrayList<>();

	public static void main(String[] args) {
		new CrossedWires().compute("inputDay3.dat");
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
		
		//Does not happen
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

	int traceCable(List<Instruction> instructions, List<Instruction> instructions1) {

		int curX = 0;
		int curY = 0;

		// Cable 0
		for (var instruction : instructions) {
			for (int i = 0; i < instruction.amount; i++) {
				switch (instruction.dir) {
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
				cable0Location.add(new Point(curX, curY));
			}
		}

		// Cable 1
		curX = 0;
		curY = 0;
		for (var instruction : instructions1) {
			for (int i = 0; i < instruction.amount; i++) {
				switch (instruction.dir) {
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
				Point cable2Location = new Point(curX, curY);
				if (cable0Location.contains(cable2Location)) {
					crossings.add(cable2Location);
				}
			}
		}

		// Point start = new Point(0,0);
		int curMinDist = Integer.MAX_VALUE;
		Point closestCrossing = null;
		// Compute the manhatten distance or each crossing
		for (Point crossing : crossings) {

			int dist = Math.abs(crossing.x) + Math.abs(crossing.y);
			if (dist < curMinDist) {
				curMinDist = dist;
				closestCrossing = crossing;
			}
			// System.out.println(crossing);
		}

		System.out.println("Min Dist: " + curMinDist + " " + closestCrossing);
		return curMinDist;

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
