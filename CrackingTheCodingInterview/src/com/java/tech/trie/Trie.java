package com.java.tech.trie;

import java.util.LinkedHashMap;

public class Trie {

	public boolean isEnd = false;

	public LinkedHashMap<Character, Trie> map;

	public Trie() {
		map = new LinkedHashMap<Character, Trie>();
	}

	public Trie(boolean isEnd) {
		this.isEnd = isEnd;
		map = new LinkedHashMap<Character, Trie>();
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public LinkedHashMap<Character, Trie> getMap() {
		return map;
	}

	public void setMap(LinkedHashMap<Character, Trie> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Trie [isEnd=" + isEnd + ", map=" + map + "]";
	}

}