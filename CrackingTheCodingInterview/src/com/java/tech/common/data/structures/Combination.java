package com.java.tech.common.data.structures;
/*
 * LESSONS LEARNT:
 * 1. In the Generics, the types have to be mentioned at the top itself.
 * */
public class Combination<T, K> {

	public T a;
	public K b;

	public Combination(T a, K b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		String inputStr = "(a=" + a + ",b=" + b + ")";
		return inputStr;
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public K getB() {
		return b;
	}

	public void setB(K b) {
		this.b = b;
	}

}
