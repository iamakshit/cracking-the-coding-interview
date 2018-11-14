package com.java.tech.dp;

import java.util.ArrayList;

public class TripleStep {

	ArrayList<Integer> list;
	int maxStep = 0;

	public TripleStep(int maxStep) {
		list = new ArrayList<>();
		initializeList();
	}

	private void initializeList() {
		list.ensureCapacity(maxStep + 1);
		for (int i = 0; i <= maxStep; i++) {
			list.add(null);
		}
	}

	public int countNoOfWays(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		if (list.get(n) != null) {
			int ways = countNoOfWays(n - 1) + countNoOfWays(n - 2) + countNoOfWays(n - 3);
			list.set(n, ways);
		}
		return list.get(n);
	}

}
