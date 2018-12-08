package com.java.tech.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SortElementByFrequency {

	public static HashMap<Integer, Integer> map = new HashMap<>();

	public static Comparator<Integer> customComparator = new Comparator<Integer>() {

		public int compare(Integer a, Integer b) {

			int aCount = map.get(a);
			int bCount = map.get(b);

			if (aCount < bCount) {
				return 1;
			} else if (aCount == bCount) {
				if(a>b) {return 1;}
				else if(a<b) {return -1;}
				else return 0;
				
			} else {
				return -1;
			}
		}

	};

	public static void main(String args[]) {
		//ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12));
		//ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 3 ,7 ,7, 7, 3, 2, 2, 2 ,7 ,3 ,1, 7 ,1, 6, 3, 5, 5 ,4 ,5 ,6, 2, 1, 2 ,4 ,7 ,3, 1, 3, 5, 4, 1, 7, 2, 6, 1, 2));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(19 ,14 ,15, 8 ,1 ,3 ,6 ,12 ,5 ,7 ,17, 3, 6, 8 ,2, 8 ,18, 10, 15 ,7 ,8 ,20, 8 ,13 ,18, 9, 2, 1, 1 ,10 ,11, 8, 14, 20, 14, 1 ,2 ,15 ,13, 21, 6, 7 ,11, 1, 8, 9 ,18 ,19 ,18, 4, 4 ,19 ,9 ,12 ,17 ,13, 21 ,14 ,13 ,12 ,4 ,13, 1, 12 ,18 ,21 ,15, 5 ,4 ,13 ,7 ,3, 3 ,18 ,19, 4, 21, 17 ,11, 3 ,15 ,7 ,5 ,13, 14, 17, 19 ,21, 2, 8, 13, 20 ,11, 11 ,2, 2 ,13 ,16 ,2, 7 ,3, 21, 10, 9 ,13, 11 ,9 ,12, 5));

		for (int i : list) {

			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		for (int key : map.keySet()) {
			System.out.println(key + " " + map.get(key));
		}

		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		Collections.sort(list, SortElementByFrequency.customComparator);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}
}
