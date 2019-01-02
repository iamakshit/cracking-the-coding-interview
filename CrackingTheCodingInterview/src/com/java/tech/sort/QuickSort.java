package com.java.tech.sort;

public class QuickSort {

	static void quickSort(int[] a, int start, int end) {
		if (start < end) {
			int p = pivotArray(a, start, end);
			quickSort(a, start, p);
			quickSort(a, p + 1, end);
		}

	}
	//TODO Fix the quick sort

	private static int pivotArray(int[] a, int start, int end) {

		int p = start;
		int i = start - 1;
		int j = start;

		while (j < end) {
			if (a[p] > a[j]) {
				i += 1;
				int temp = a[p];
				a[p] = a[i];
				a[i] = temp;

			}
			j += 1;
		}

		int temp = a[p];
		a[p] = a[i + 1];
		a[i + 1] = temp;
		displayArray(a);
		return (i + 1);
	}

	public static void displayArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] a = { 38, 27, 43, 3, 9, 82, 10 };
		quickSort(a, 0, a.length - 1);
		displayArray(a);
	}
}
