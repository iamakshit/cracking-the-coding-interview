package com.java.tech.common.data.structures.variations;

public class ThreeStacksInOne {

	/*
	 * Ques. Use a single array to implement three stacks.
	 */

	public int[] array; // This is the syntax
	public int[] tops;

	public ThreeStacksInOne(int size, int stacksNumber) {
		this.array = new int[size];
		this.tops = new int[stacksNumber + 1];
	}

	public void add(int element, int stacksNumber) {

		if (stacksNumber <= 0 && stacksNumber >= tops.length) {
			return;
		}

		int top = tops[stacksNumber];
		int maxSize = (stacksNumber) * (array.length / stacksNumber);
		if (top >= maxSize) {
			return;
		}

		array[top++] = element;
		tops[stacksNumber] = top;

	}

	public int pop(int stacksNumber) {

		int top = tops[stacksNumber];
		int minSize = (stacksNumber - 1) * (array.length / stacksNumber);
		if (top <= minSize) {
			return -1;
		}

		int element = array[top--];
		tops[stacksNumber] = top;
		return element;
	}

}
