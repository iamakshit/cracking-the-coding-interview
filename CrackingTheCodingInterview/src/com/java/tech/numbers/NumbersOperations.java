package com.java.tech.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import com.java.tech.common.CustomException;
import com.java.tech.common.ErrorCodes;
import com.java.tech.common.data.structures.Combination;

public class NumbersOperations {

	/***
	 * 
	 * 
	 * Potential Question 1. Does the set contains positive integer
	 * 
	 * 
	 * LESSONS LEARNT 1> Always look for the corner case 2> Collections don't have
	 * isEmpty method. 3> You were using the internal method 4> Variable's
	 * definition needs to be there 5> Remember if you want to avoid the repetition,
	 * always do i=0 and j=i+1.
	 * 
	 * 6> We can make an array of the dynamic length 7> int x = 5/2;
	 * System.out.println(x); nextLine() provides string always String to Integer
	 * typecasting does not work Use Integer.parseInt()
	 * 
	 * while(1) does not work but while(true) does work to exit you need to use
	 * System.exit(0)
	 * 
	 */

	/*
	 * Ques. Find all the positive integers solutions between 1 to K to the equation
	 * a^3+b^3 = c^3+ d^3. Print only one distinct combination
	 */

	public void printIntegerSolutions(int maxNum) throws CustomException {
		if (maxNum <= 0) {
			throw new CustomException(ErrorCodes.ONLY_POSITIVE_INPUT.getMessage());
		}

		HashMap<Integer, ArrayList<Combination>> sumToCombinationMap = new HashMap<Integer, ArrayList<Combination>>();
		for (int i = 1; i < maxNum; i++) {
			for (int j = i + 1; j < maxNum; j++) {
				int sum = (int) (Math.pow(i, 3) + Math.pow(j, 3));
				ArrayList<Combination> list;
				if (sumToCombinationMap.containsKey(sum)) {
					list = sumToCombinationMap.get(sum);
				} else {
					list = new ArrayList<>();
				}

				list.add(new Combination<Integer, Integer>(i, j));
				sumToCombinationMap.put(sum, list);
			}
		}

		for (int key : sumToCombinationMap.keySet()) {
			if (sumToCombinationMap.get(key).size() <= 1) {
				continue;
			}

			// System.out.println(sumToCombinationMap.get(key));
			ArrayList<Combination> list = sumToCombinationMap.get(key);
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					Combination a = list.get(i);
					Combination b = list.get(j);
					if (!(a.getA() == b.getA() || a.getA() == b.getB())) {
						System.out.println("A=" + a.getA() + " B=" + a.getB() + " C=" + b.getA() + " D=" + b.getB());
					}
				}
			}

		}

	}

	/******************************************************************************************/

	/*
	 * Ques. Find all the combinations having the difference K
	 */

	public ArrayList<Combination<Integer, Integer>> findCombinations(Integer K, ArrayList<Integer> dataSet) {
		ArrayList<Combination<Integer, Integer>> combinations = new ArrayList<Combination<Integer, Integer>>();
		HashSet<Integer> set = new HashSet<Integer>();
		if (dataSet == null || dataSet.isEmpty()) {
			return combinations;
		}

		for (Integer num : dataSet) {
			set.add(num);
		}

		for (Integer num : dataSet) {
			Integer difference = Math.abs(num + K);
			if (set.contains(difference)) {
				Combination<Integer, Integer> combination = new Combination<Integer, Integer>(difference, num);
				combinations.add(combination);
			}
		}

		return combinations;
	}

	/******************************************************************************************/

	public int multiplicationMinComputation(int a, int b) {
		int smaller = b < a ? b : a;
		int bigger = b < a ? a : b;
		return multiply(smaller, bigger);
	}

	public int multiply(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}

		boolean isEven = ((smaller % 2) == 0);
		smaller = smaller >> 1;
		int output = multiply(smaller, bigger);
		if (isEven) {
			output = output + output;
		} else {
			output = output + output + bigger;
		}
		return output;
	}

	/******************************************************************************************/

	public void findElementInSortedMatrix(int[][] matrix, int element) {
		int row = 0;
		int column = matrix[0].length - 1;

		while (row < matrix.length && column >= 0 && matrix[row][column] != element) {
			if (matrix[row][column] < element) {
				row += 1;
			} else if (matrix[row][column] > element) {
				column -= 1;
			}
		}

		if (matrix[row][column] == element) {
			System.out.println("Element Found at Row = " + row + " Column = " + column);
		} else {
			System.out.println("Element not found");
		}
	}

	/******************************************************************************************/

	public void peakValleyPeak(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int biggestIndex = findBiggestIndex(list, i, i - 1, i + 1);
			if (i != biggestIndex) {
				swap(list, i, biggestIndex);
			}
		}
	}

	private void swap(int[] list, int i, int biggestIndex) {
		// TODO Auto-generated method stub
		int temp = list[i];
		list[i] = list[biggestIndex];
		list[biggestIndex] = temp;
	}

	private int findBiggestIndex(int[] list, int a, int b, int c) {
		int aValue = 1;
		int bValue = 1;
		int cValue = 1;

		int maxValue = Math.max(aValue, Math.max(bValue, cValue));
		if (maxValue == aValue) {
			return a;
		} else if (maxValue == bValue) {
			return b;
		} else {
			return c;
		}
	}

	/******************************************************************************************/

	public void sumOfSubsets(int[] list, int sum) {
		boolean[] used = new boolean[list.length + 1];
		LinkedList<Integer> subset = new LinkedList<Integer>();
		for (int i = 0; i < list.length; i++) {
			findSubset(list, used, subset, sum, i);
		}

	}

	public void findSubset(int[] list, boolean[] used, LinkedList<Integer> subset, int sum, int index) {
		if (used[index] || index >= (list.length) || sum < 0) {
			return;
		}

		if (sum == 0) {
			printSubSet(subset);
		}

		used[index] = true;
		subset.add(list[index]);

		for (int i = index + 1; i < list.length; i++) {
			findSubset(list, used, subset, sum - list[index], i);
		}

		used[index] = false;
		subset.removeLast();

	}

	private void printSubSet(LinkedList<Integer> subset) {
		for (Integer n : subset) {
			System.out.print(n + ",");
		}
		System.out.println();
	}
}
