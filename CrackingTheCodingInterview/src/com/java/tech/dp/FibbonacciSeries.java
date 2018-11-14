package com.java.tech.dp;

import java.util.ArrayList;

public class FibbonacciSeries {

	private ArrayList<Integer> list;
	private int size;

	public FibbonacciSeries(int n) {
		list = new ArrayList<>();
		list.ensureCapacity(n);
		this.size = n;
		initializeList();
	}

	private void initializeList() {
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
	}

	// This is top down approach
	public Integer computeFibbonacci(int index) {

		if (list.get(index) != null) {
			return list.get(index);
		}

		if (index == 0) {
			list.set(0, 1);
		} else if (index == 1) {
			list.set(1, 1);
		} else {
			int element = computeFibbonacci(index - 1) + computeFibbonacci(index - 2);
			list.set(index, element);
		}
		return list.get(index);
	}

	public Integer computeFibbonacciBottom(int n) {
		int[] list = new int[size + 1];
		list[0] = 1;
		list[1] = 1;

		for (int index = 2; index <= n; index++) {
			list[index] = list[index - 1] + list[index - 2];
		}
		return list[n];
	}

}
