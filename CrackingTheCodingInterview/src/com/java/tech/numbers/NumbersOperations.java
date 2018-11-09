package com.java.tech.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	 * LESSONS LEARNT 
	 * 1> Always look for the corner case
	 * 2> Collections don't have isEmpty method. 
	 * 3> You were using the internal method
	 * 4> Variable's definition
	 * needs to be there 
	 * 5> Remember if you want to avoid the repetition, always do
	 * i=0 and j=i+1.
	 * 
	 * 6> We can make an array of the dynamic length
	 * 7> int x = 5/2;  System.out.println(x);
	 * nextLine() provides string always
	 * String to Integer typecasting does not work
	 * Use Integer.parseInt()
	 * 
	 * while(1) does not work but while(true) does work
	 * to exit you need to use System.exit(0)
		
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
}
