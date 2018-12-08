package com.java.tech.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElement {

	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

	static ArrayList<Integer> findKthLargestElement(int[] a, int K) {
		ArrayList<Integer> list = new ArrayList<Integer>(K);
		int limit = K;
		while(limit>=0)
		{
			
			limit-=1;
		}
		for (int i = 0+K; i < a.length; i++) {
			minHeap.add(a[i]);
		}
		minHeap.remove(3);
		minHeap.remove(2);
		System.out.println(minHeap);
		return list;
	}

	public static void main(String args[]) {
		int[] a = { 1, 2, 3, 4, 5, 6 };
		
		//findKthLargestElement(a);
		
	}
}
