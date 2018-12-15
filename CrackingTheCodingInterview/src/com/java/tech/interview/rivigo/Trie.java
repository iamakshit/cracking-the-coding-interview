package com.java.tech.interview.rivigo;

import java.util.LinkedHashMap;

public class Trie {

	public Character ch = null;

	public boolean isEnd = true;

	public LinkedHashMap<Character, Trie> map;

	public Trie(Character ch) {
		this.ch = ch;
		map = new LinkedHashMap<Character, Trie>();
	}

	public Trie(Character ch, boolean isEnd) {
		this.ch = ch;
		this.isEnd = isEnd;
		map = new LinkedHashMap<Character, Trie>();
	}

	public Character getCh() {
		return ch;
	}

	public void setCh(Character ch) {
		this.ch = ch;
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

}