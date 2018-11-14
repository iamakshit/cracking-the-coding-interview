package com.java.tech.bit;

public class BitManipulationOperations {

	public boolean checkIfPowerOfTwo(int num) {
		while (num >= 0) {
			if (num % 2 == 0) {
				num = num << 1;  //LOOK AT THIS BITWISE OPERATOR DIRECTION
								// n&(n-1) ==0
			} else {
				return false;
			}
		}
		return true;
	}
}
