package com.java.tech.interview.rivigo;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class WildCardMatchingDictionary {

	/*
	 * Create a dictionary out of a given set of words. Operations to get string of
	 * partial match with wildcard. words => man, hat, banana, cat Operation : ?a?
	 * 
	 * ? -> 1 character
	 * 
	 * > word length is max 50 
	 * > number of words - 1,00,000
	 * > number of searches -> 50000
	 * 
	 * E.g
	 * 
	 * queen
	 * Operation 2 types: 
	 * 1) Add word 
	 * 2) Find words with pattern : q?e?n
	 * 
	 */

	LinkedHashMap<Character, Trie> map;

	public WildCardMatchingDictionary() {
		map = new LinkedHashMap<Character, Trie>();
		// b ==> Trie{map}
	}

	public void addWord(String word) {
		if (word == null || word.length() == 0) {
			return;
		}

		Trie trie = null;
		
		
		for (Character ch : word.toCharArray()) {

			if (map.containsKey(ch)) {
				trie = map.get(ch);
				// map = trie.get(ch);

			} else {
				trie = new Trie(ch);
				map.put(ch, trie);
				// map = trie.map();

			}

		}

		trie.setEnd(true);

	}

	public HashSet<String> findPattern(String pattern) {

		HashSet<String> set = new HashSet<String>();

		if (pattern == null && pattern.length() == 0) {
			return set;
		}

		// getWords(pattern, words, new StringBuilder(),trie)
		return set;
	}

	public void getWords(String pattern, HashSet<String> words, StringBuilder currentWord, Trie trie) {

		if (pattern.length() == 0 && trie.isEnd()) {
			words.add(currentWord.toString());
			return;
		}

		// LinkedHashMap<Character, Trie> map = trie.map();
		// if (pattern.charAt(0).equals('?')) {
		for (Character ch : map.keySet()) {
			int length = pattern.length();

			currentWord.append(ch);
			// getWords(pattern.subString(1, length), words, currentWord, map.get(ch));
			currentWord.setLength(currentWord.length() - 1);
		}

		/// } else if (map.containsKey(patternCh.charAt(0))) {
		// int length = pattern.length();
		// currentWord.append(ch);
		// getWords(pattern.subString(1, length), words, currentWord, map.get(ch));
		// currentWord.setLength(currentWord.length() - 1);
		// }

		return;

	}

}
