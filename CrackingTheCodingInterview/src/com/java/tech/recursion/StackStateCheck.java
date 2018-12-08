package com.java.tech.recursion;

import java.util.Stack;

public class StackStateCheck {

	/*
	 * Check if an object persists its state being in and out of the stack
	 */

	public static void recursionCounter(int i, int max, Stack<Integer> stack) {
		if (i == max) {
			return;
		}
		recursionCounter(i + 1, max, stack);
		stack.push(1);

	}

	public static void main(String args[]) {
		Stack<Integer> stack = new Stack<>();
		recursionCounter(0, 5, stack);
		System.out.println(stack.size());
	}
}
