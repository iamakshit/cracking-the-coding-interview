package com.java.tech.trie.questions;

import java.util.LinkedList;

import com.java.tech.trie.Trie;
import com.java.tech.trie.common.HelperMethods;
//https://www.geeksforgeeks.org/auto-complete-feature-using-trie/
public class AutoComplete {

	static Trie trie;

	static Trie findTrie(String initialInput, Trie trie) {
		if (initialInput == null || initialInput.length() == 0) {
			return trie;
		}

		Character ch = initialInput.charAt(0);
		if (!trie.getMap().containsKey(ch)) {
			return null;
		}
		Trie nextTrie = trie.getMap().get(ch);
		return findTrie(initialInput.substring(1, initialInput.length()), nextTrie);
	}

	static LinkedList<String> autoComplete(String initialInput, Trie rootTrie) {
		Trie firstTrie = findTrie(initialInput, rootTrie);
		LinkedList<String> list = new LinkedList<>();
		if (firstTrie == null) {
			return list;
		}
		findAutoCompleteWords(initialInput, list, firstTrie, new StringBuilder());
		return list;
	}

	private static void findAutoCompleteWords(String initialInput, LinkedList<String> list, Trie trie,
			StringBuilder stringBuilder) {
		if (trie == null) {
			return;
		}
		if (trie.isEnd) {
			String output = initialInput + stringBuilder.toString();
			list.add(output);
		}

		for (Character ch : trie.getMap().keySet()) {
			stringBuilder.append(ch);
			findAutoCompleteWords(initialInput, list, trie.getMap().get(ch), stringBuilder);
			stringBuilder.setLength(stringBuilder.length() - 1);
		}
	}

	public static void main(String args[]) {
		trie = new Trie();
		String[] words = { "abc", "abcd", "aa", "abbbaba" };
		for (String word : words) {
			HelperMethods.addWord(word, trie);
		}

		String initialInput = "ab";
		LinkedList<String> list = autoComplete(initialInput, trie);
		System.out.println(list);
	}

}
