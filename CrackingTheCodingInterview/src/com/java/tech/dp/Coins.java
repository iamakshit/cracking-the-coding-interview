package com.java.tech.dp;

import java.util.ArrayList;
import java.util.LinkedList;

public class Coins {

	/**
	 * Given an infinite numbers of quarters(25 cents), dimes(10 cents), nickels(5
	 * cents) and pennies (1 cent), write code to calculate the number of ways of
	 * representing n cents
	 **/
	// int[] denominations = { 25, 10, 5, 1 };
	int[] denominations = { 3, 1, 2 };

	public int countNumberOfWays(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		list.ensureCapacity(n + 1);
		for (int i = 0; i <= n; i++) {
			list.add(null);
		}
		int totalNoOfWays = countWays(n, list);
		return totalNoOfWays;
	}

	public int countMinNumberOfWays(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		list.ensureCapacity(n + 1);
		for (int i = 0; i <= n; i++) {
			list.add(null);
		}
		LinkedList<Integer> output = new LinkedList<Integer>();
		int minNoOfWays = countMinOfWays(n, list, 0, output);
		return minNoOfWays;
	}

	public int countMinNumberOfWaysOptimal(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		list.ensureCapacity(n + 1);
		for (int i = 0; i <= n; i++) {
			list.add(null);
		}
		LinkedList<Integer> output = new LinkedList<Integer>();
		int minNoOfWays = 0;
		for (int i = 1; i <= n; i++) {
			minNoOfWays = countMinOfWays(i, list, 0, output);
			list.set(i, minNoOfWays);
		}
		return minNoOfWays;
	}

	public int countWays(int n, ArrayList<Integer> list) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (list.get(n) != null) {
			return list.get(n);
		}
		int count = 0;
		for (int denomination : denominations) {
			count += countWays(n - denomination, list);
		}

		list.set(n, count);
		return list.get(n);
	}

	// LESS OPTIMAL WAY
	public int countMinOfWays(int n, ArrayList<Integer> list, int currentCount, LinkedList<Integer> output) {
		if (n < 0) {
			return Integer.MAX_VALUE;
		}
		if (n == 0) {
			return currentCount;
		}
		if (list.get(n) != null) {
			// return list.get(n); //YOU SHOULD BE REALLY CAREFUL AS WHERE TO APPLY
			// MEMOIZATION
		}
		int count = Integer.MAX_VALUE;
		for (int denomination : denominations) {
			output.add(denomination);
			count = Math.min(count, countMinOfWays(n - denomination, list, currentCount + 1, output));
			output.removeLast(); // THERE IS A DIFFERENCE BETWEEN POLL AND REMOVE
		}

		list.set(n, count);
		return list.get(n);
	}

	// MORE OPTIMAL WAY
	public int countMinOfWaysOptimized(int n, ArrayList<Integer> list, int currentCount, LinkedList<Integer> output) {
		if (n < 0) {
			return Integer.MAX_VALUE;
		}
		if (n == 0) {
			return currentCount;
		}
		if (list.get(n) != null) {
			return list.get(n);
		}
		int count = Integer.MAX_VALUE;
		for (int denomination : denominations) {
			output.add(denomination);
			count = Math.min(count, countMinOfWays(n - denomination, list, currentCount + 1, output));
			output.removeLast(); // THERE IS A DIFFERENCE BETWEEN POLL AND REMOVE
		}

		// list.set(n, count);
		return count;
	}

}
