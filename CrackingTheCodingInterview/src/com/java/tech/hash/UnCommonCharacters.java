package com.java.tech.hash;

import java.util.HashSet;
import java.util.TreeSet;

class UnCommonCharacters {
	public static void findUnCommonCharacters(String a, String b) {
		HashSet<Character> aSet = new HashSet<Character>();
		HashSet<Character> bSet = new HashSet<Character>();
		for (Character ch : a.toCharArray()) {
			aSet.add(ch);
		}
		for (Character ch : b.toCharArray()) {
			bSet.add(ch);
		}
		HashSet<Character> cSet = new HashSet<Character>();
		for (Character ch : aSet) {
			if (bSet.contains(ch)) {
				cSet.add(ch);
			}
		}
		TreeSet<Character> set = new TreeSet<Character>();
		for (Character ch : aSet) {
			if (!cSet.contains(ch)) {
				set.add(ch);

			}
		}
		for (Character ch : bSet) {
			if (!cSet.contains(ch)) {
				set.add(ch);
			}
		}
		
		for(Character ch: set)
		{
			System.out.print(ch);
		}

	}

	public static void main(String[] args) {
		findUnCommonCharacters("characters", "alphabets");
		System.out.println();
		findUnCommonCharacters("iaduai", "audsjdsa");

		
		
	}
}
