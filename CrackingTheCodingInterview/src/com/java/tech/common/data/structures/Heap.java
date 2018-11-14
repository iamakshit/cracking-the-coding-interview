package com.java.tech.common.data.structures;

public class Heap {

	public int[] heapSort(int[] list) {
		int N = list.length;
		for (int i = (N - 1); i > 0; i--) {
			list = maxHeapify(list, 0, i);
			list = swap(list, i, N);
			N -= 1;
			displayList(list);

		}
		return list;

	}

	public void  buildMaxHeap()
	{
	//	for 
	}

//BUILD-MAX-HEAP.A/
//1 A:heap-size D A:length
//2 for i D bA:length=2c downto 1
//3 MAX-HEAPIFY.A;i/



	public int[] maxHeapify(int[] list, int index, int maxLength) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int largest = index;

		if ((left < maxLength) && (list[left] > list[largest])) {
			largest = left;

		}

		if ((right < maxLength) && (list[right] > list[largest])) {
			largest = right;
		}

		if (largest != index) {
			list = swap(list, largest, index);
			list = maxHeapify(list, largest, maxLength);
		}
		return list;

	}

	public int[] swap(int[] list, int a, int b) {
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
		return list;
	}

	public void displayList(int[] list) {
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
