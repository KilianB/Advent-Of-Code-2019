package day4;

public class SecureContainer2 {

	private int lowerBound;
	private int upperBound;

	public static void main(String[] args) {
		int validPws = new SecureContainer2(372037, 905157).checkRange();
		System.out.println(validPws);
	}

	public SecureContainer2(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public int checkRange() {
		int validPasswords = 0;
		// Naive approach
		for (int i = lowerBound; i <= upperBound; i++) {
			if (isValidNumber(i)) {
				validPasswords++;
			}
		}

		// Smarter
		/*
		 * If within the first 2 digits we already fail ajacency skip the next couple
		 * number which will fail for sure
		 */

		return validPasswords;

	}

	public boolean isValidNumber(int number) {

		// Preconditions

		// is a 6 digit number
		assert numOfDigits(number) == 6;

		// The value is within the range given in your puzzle input.
		assert number >= lowerBound && number <= upperBound;

		// Conditions

		// Two adjacent digits are the same (like 22 in 122345).
		if (!checkAdjacentEquality(number)) {
			return false;
		}

		// Going from left to right, the digits never decrease
		if (!checkIncreaseValue(number)) {
			return false;
		}

		/*
		 * //Two adjacent bits are the same (like 22 in 122345). int temp = number;
		 * for(int i = 0; i < 6; i++) { int digit = temp & 0x01; temp <<= 1;
		 * System.out.println(i + " " + digit); }
		 */
		return true;
	}

	private boolean checkIncreaseValue(int number) {
		int temp = number;
		byte lastDigit = Byte.MAX_VALUE;

		for (int i = 0; i < 6; i++) {
			byte digit = (byte) (temp % 10);
			temp /= 10;
			if (lastDigit < digit) {
				return false;
			}
			lastDigit = digit;
		}
		return true;
	}


	private boolean checkAdjacentEquality(int number) {
		int temp = number;
		int lastDigit = Integer.MIN_VALUE;	
		int cAdjacentDigits = 0;

		for (int i = 0; i < 6; i++) {
			int digit = temp % 10;
			temp /= 10;
			if (lastDigit == digit) {
				cAdjacentDigits++;
			} else {
				if (cAdjacentDigits == 2) {
					return true;
				}
				cAdjacentDigits = 1;
			}
			lastDigit = digit;
		}

		if (cAdjacentDigits == 2) {
			return true;
		}
		return false;
	}
	
	private int numOfDigits(int input) {
		return (int) Math.log10(input) + 1;
	}

}
