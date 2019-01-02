package com.java.tech.trie.questions;

import java.util.LinkedList;

import com.java.tech.trie.SortedTrie;
//https://www.geeksforgeeks.org/sorting-array-strings-words-using-trie/
public class SortWords {

	static SortedTrie trie;

	static boolean findWord(String word, SortedTrie trie) {
		if (word == null || word.length() == 0) {
			return trie.isEnd;
		}
		Character ch = word.charAt(0);
		SortedTrie nextTrie = trie.getMap().get(ch);
		if (nextTrie == null) {
			return false;
		}
		return findWord(word.substring(1, word.length()), nextTrie);
	}

	static void addWord(String word, SortedTrie trie) {
		if (word == null || word.length() == 0) {
			trie.setEnd(true);
			return;
		}

		Character ch = word.charAt(0);
		if (!trie.getMap().containsKey(ch)) {
			trie.getMap().put(ch, new SortedTrie());
		}
		addWord(word.substring(1, word.length()), trie.getMap().get(ch));
	}

	public static void sortWords(LinkedList<String> list, SortedTrie trie, StringBuilder word) {
		if (trie == null) {
			return;
		}

		if (trie.isEnd) {
			list.add(word.toString());
			return;
		}
		for (Character ch : trie.getMap().keySet()) {
			word.append(ch);
			sortWords(list, trie.getMap().get(ch), word);
			word.setLength(word.length() - 1);
		}
	}

	public static void main(String args[]) {
		trie = new SortedTrie();
		String[] words = { "geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer", "science",
				"zoom", "yup", "fire", "in", "data" };
		for (String word : words) {
			addWord(word, trie);
		}
		LinkedList<String> list = new LinkedList<String>();
		sortWords(list, trie, new StringBuilder());
		System.out.println(list);

	}
}
