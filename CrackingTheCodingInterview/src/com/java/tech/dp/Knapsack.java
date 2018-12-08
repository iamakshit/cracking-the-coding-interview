package com.java.tech.dp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Knapsack {

	private static int[] values = { 60, 100, 120 };
	private static int[] weight = { 1, 2, 3 };

	private static final Map<Integer, Integer> weightToValuesMap = new HashMap<Integer, Integer>();
	static {
		weightToValuesMap.put(1, 60);
		weightToValuesMap.put(2, 100);
		weightToValuesMap.put(3, 120);
	}

	//One item used multiple times
	public static int knapSackProblem(int value) {
		int[] a = new int[value + 1];
		for (int i = 1; i <= value; i++) {
			for (Integer weight : weightToValuesMap.keySet()) {
				if (i >= weight) {
					System.out.println(i+" "+weight);
					a[i] = Math.max(a[i], weightToValuesMap.get(weight) + a[i - weight]);
				}
			}
		}
		
		for(int i=0;i<=value;i++)
		{
			System.out.print(a[i]+",");
		}
		return a[value];
	}


	public static void main(String args[]) {
		System.out.println(knapSackProblem(5));

	}

}
