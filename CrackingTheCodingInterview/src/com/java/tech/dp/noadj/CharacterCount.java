package com.java.tech.dp.noadj;

public class CharacterCount {
	Character ch;
	Integer count = 0;

	public CharacterCount(Character ch, int count) {
		// TODO Auto-generated constructor stub
		this.count = count;
		this.ch = ch;
	}

	public Character getCh() {
		return ch;
	}

	public void setCh(Character ch) {
		this.ch = ch;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CharacterCount [ch=" + ch + ", count=" + count + "]";
	}

}
