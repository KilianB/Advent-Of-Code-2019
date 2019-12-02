package day1;

import java.io.IOException;
import java.util.function.IntUnaryOperator;

import util.InputReader;

public class TheTyrannyoftheRocketEquation {

	/**
	 * Compute the required mass of rocket fuel for every single module
	 * 
	 * @param fileName file containing the module weights
	 * @return the amount of fuel needed
	 */
	public static int solveMass(String fileName, IntUnaryOperator intFunction) {
		// No overflow protection
		int totalMass = 0;
		try (var input = new InputReader(fileName)) {
			totalMass = input.asIntStream().map(intFunction).sum();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return totalMass;
	}

	/**
	 * Iteratively compute the required amount of fuel for a given input weight
	 * 
	 * @param totalMass the input weight
	 * @return the required fuel
	 */
	static int solveMassIterratively(int totalMass) {
		int notAccountedFor = totalMass;
		totalMass = 0;
		while (true) {
			notAccountedFor = convertMass(notAccountedFor);
			if (notAccountedFor >= 0) {
				totalMass += notAccountedFor;
			} else {
				break;
			}
		}
		return totalMass;
	}

	/**
	 * Convert input weight to required amount of fuel
	 * 
	 * @param inMass the amount of mass fuel is required for
	 * @return the weight of fuel needed
	 */
	static int convertMass(int inMass) {
		// (Round down done implicitly by casting)
		return inMass / 3 - 2;
	}

	public static void main(String[] args) {

		String moduleWeights = "inputDay1.dat";

		System.out.println("Part1: " + solveMass(moduleWeights, i -> convertMass(i)));
		System.out.println("Part2: " + solveMass(moduleWeights, i -> solveMassIterratively(i)));
	}

}
