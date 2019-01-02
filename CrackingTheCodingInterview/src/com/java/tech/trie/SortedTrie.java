package com.java.tech.trie;

import java.util.TreeMap;

public class SortedTrie {

	public boolean isEnd = false;

	public TreeMap<Character, SortedTrie> map; // It is not LinkedHashMap

	public SortedTrie() {
		map = new TreeMap<Character, SortedTrie>();
	}

	public SortedTrie(Character ch, boolean isEnd) {
		this.isEnd = isEnd;
		map = new TreeMap<Character, SortedTrie>();
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public TreeMap<Character, SortedTrie> getMap() {
		return map;
	}

	public void setMap(TreeMap<Character, SortedTrie> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "SortedTrie [isEnd=" + isEnd + ", map=" + map + "]";
	}

}
