package com.java.tech.sort;

import java.util.ArrayList;
import java.util.LinkedList;

public class CountingSort {

	int[] list;
	int maxInteger;

	public CountingSort(int maxInteger) {
		this.maxInteger = maxInteger;
		list = new int[maxInteger + 1];

	}

	public LinkedList<Integer> countingSort(int[] input) {
		for (Integer num : input) {
			list[num] += 1;
		}

		LinkedList<Integer> output = new LinkedList<Integer>();
		for (int i = 0; i <= maxInteger; i++) {
			if (list[i] > 0) {
				int count = list[i];
				while (count > 0) {
					output.add(i); //note: PUSH ACTS LIKE STACK KEEPS INDEX AT 0 WHEREAS ADD
					// METHOD INCREASES THE INDEX 
					--count;
				}
			}
		}
		return output;
	}

	public void displaySortedList(LinkedList<Integer> output) {
		for (Integer i : output) {
			System.out.print(i + " ");
		}
	}
}
