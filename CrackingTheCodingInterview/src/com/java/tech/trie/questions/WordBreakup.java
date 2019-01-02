package com.java.tech.trie.questions;
//https://www.geeksforgeeks.org/word-break-problem-trie-solution/

import com.java.tech.trie.Trie;
import com.java.tech.trie.common.HelperMethods;

public class WordBreakup {

	static Trie trie;

	public static boolean wordBreak(String input) {

		for (int i = 1; i <= input.length(); i++) { // THIS SYNTAX IS IMPORTANT
			String a = input.substring(0, i);
			boolean isWordFound = HelperMethods.findWord(a, trie);
			if (!isWordFound) {
				continue;
			}
			String b = input.substring(i, input.length());
			if (wordBreak(b) || b.length() == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {

		trie = new Trie();
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "ma\n", "mango", "icecream", "and", "go", "i",
				"like", "ice", "cream" };
		for (String word : dictionary) {
			HelperMethods.addWord(word, trie);
		}
		System.out.println(HelperMethods.findWord("i", trie));
		System.out.println(wordBreak("ilike"));
	}

}
