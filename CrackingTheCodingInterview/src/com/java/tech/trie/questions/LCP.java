package com.java.tech.trie.questions;
//https://www.geeksforgeeks.org/longest-common-prefix-using-trie/

import java.util.Set;

import com.java.tech.trie.Trie;
import com.java.tech.trie.common.HelperMethods;

public class LCP {
	static Trie trie;

	public static String findLcaWords(StringBuilder output, Trie trie) {
		if (trie == null || trie.getMap().keySet().size() > 1) {
			return output.toString();
		}
		Set<Character> set = trie.getMap().keySet();
		for (Character ch : set) {
			output = output.append(ch);
			return findLcaWords(output, trie.getMap().get(ch));
		}
		return output.toString();
	}

	public static void main(String args[]) {
		// LCP
		trie = new Trie();
		String lcaWords[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		for (String word : lcaWords) {
			HelperMethods.addWord(word, trie);
		}

		System.out.println(findLcaWords(new StringBuilder(), trie));
		
		//String x = "*****ba*****ab";
		//x = x.replace("**", ""); // Gives *ba*ab
		//System.out.println(x);
	}

}
