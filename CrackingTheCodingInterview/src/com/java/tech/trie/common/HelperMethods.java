package com.java.tech.trie.common;

import com.java.tech.trie.Trie;

public class HelperMethods {
	public static boolean findWord(String word, Trie trie) {
		if (word == null || word.length() == 0) {
			return trie.isEnd;
		}
		Character ch = word.charAt(0);
		Trie nextTrie = trie.getMap().get(ch);
		if (nextTrie == null) {
			return false;
		}
		return findWord(word.substring(1, word.length()), nextTrie);
	}

	public static void addWord(String word, Trie trie) {
		if (word == null || word.length() == 0) {
			trie.setEnd(true);
			return;
		}

		Character ch = word.charAt(0);
		if (!trie.getMap().containsKey(ch)) {
			trie.getMap().put(ch, new Trie());
		}
		addWord(word.substring(1, word.length()), trie.getMap().get(ch));
	}
	
	//https://www.geeksforgeeks.org/counting-number-words-trie/
	public static int countNoOfWords(Trie trie) {
		if (trie == null) {
			return 0;
		}

		int count = 0;
		if (trie.isEnd) {
			count += 1;
		}

		for (Character ch : trie.getMap().keySet()) {
			count += countNoOfWords(trie.getMap().get(ch));
		}
		return count;

	}
}
