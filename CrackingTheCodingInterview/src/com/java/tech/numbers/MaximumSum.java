package com.java.tech.numbers;

import java.util.LinkedList;

public class MaximumSum {

	public static int computeSum(LinkedList<Integer> list) {
		Integer sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i) * i;
		}
		return sum;
	}

	public static LinkedList<Integer> prepareLinkedList(int[] a) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i : a) {
			list.add(i);
		}
		return list;
	}

	public static int computeMaximumSum(int[] a) {
		LinkedList<Integer> list = prepareLinkedList(a);
		Integer maxSum = Integer.MIN_VALUE;
		for (int i = 1; i <= a.length; i++) {
			list.add(list.pollFirst());
			maxSum = Math.max(maxSum, computeSum(list));
		}
		return maxSum;
	}

	public static void main(String args[]) {
		int[] a = { 8, 3, 1, 2 };
		System.out.println(computeMaximumSum(a));
	}
}
