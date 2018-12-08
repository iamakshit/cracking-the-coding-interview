package com.java.tech.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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

	/******************************************************************************************/

	public int sumOfDigits(int number) {
		if (number <= 0) {
			return 0;
		}

		int sum = number % 10;
		sum += sumOfDigits(number / 10);
		return sum;
	}

	/******************************************************************************************/

	public int powerFunction(int x, int N) {
		int output = 0;
		if (N == 0) {
			return 1;
		} else if (N == 1) {
			return x;
		} else {
			output = powerFunction(x, N / 2);
			output *= output;
			if (N % 2 != 0) {
				output *= x;
			}
		}
		return output;
	}

	/******************************************************************************************/

	// MAJOR LESSONS, TAKING THE ARRAY IN REVERSE WORKS, NOT IN THE FORWARD
	// DIRECTION
	// TAKING THE ARRAY IN SORTED WAY IS THE SOLUTION.
	public void divideArrayInMinDifference(int[] a) {
		Arrays.sort(a);
		int rightSum = 0, leftSum = 0;
		LinkedList<Integer> rightList = new LinkedList<>();
		LinkedList<Integer> leftList = new LinkedList<>();
		for (int i = a.length - 1; i >= 0; i--) {
			if (Math.abs(rightSum - leftSum + a[i]) >= Math.abs(Math.abs(rightSum - leftSum - a[i]))) {
				leftSum += a[i];
				leftList.add(a[i]);
			} else {
				rightSum += a[i];
				rightList.add(a[i]);
			}
		}
		for (int i : rightList) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : leftList) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(Math.abs(rightSum - leftSum));
	}

	/******************************************************************************************/

	// https://www.geeksforgeeks.org/reduce-a-number-to-1-by-performing-given-operations/
	public static int operationsToReduceToOne(int number) {
		if (number <= 1) {
			return 0;
		} else if (number % 2 == 0) {
			return (1 + operationsToReduceToOne(number / 2));
		} else {
			return Math.min((1 + operationsToReduceToOne(number - 1)), (1 + operationsToReduceToOne(number + 1)));
		}
	}

	/******************************************************************************************/

	// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0
	public static String formLargestNumber(List<String> list) {

		Collections.sort(list, customComparator);
		StringBuilder output = new StringBuilder();
		for (String i : list) {
			output.append(i);
		}
		return output.toString();
	}

	public static Comparator<String> customComparator = new Comparator<String>() {

		@Override
		public int compare(String a, String b) {
			String firstString = a + b;
			String secondString = b + a;
			return (-1 *firstString.compareTo(secondString));
		}

	};

	/******************************************************************************************/

	public static void main(String args[]) {

		// System.out.println(operationsToReduceToOne(7));
		Integer a, b, c; // This is a valid syntax
		String[] list = { "5", "9", "3", "30", "34" };
		// String[] list = {"33","34"};

		Arrays.sort(list);
		System.out.println(formLargestNumber(Arrays.asList(list))); // VERY GOOD COMMAND

	}

}
