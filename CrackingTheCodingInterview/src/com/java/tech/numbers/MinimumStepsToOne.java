package com.java.tech.numbers;

public class MinimumStepsToOne {

	public static int minStepstoOne(int input) {
		int[] a = new int[input + 1];
		for (int i = 2; i <= input; i++) {
			a[i] = (Math.min(a[i - 1], a[divisor(input)])) + 1;
		}
		displayArray(a);
		return a[input];

	}

	static void displayArray(int[] a)
	{
		for(int i=1;i<a.length;i++)
		{
			System.out.println(i+" "+a[i]+" divisor ="+divisor(i));
		}
	}

	static int divisor(int number) {
		int i;
		for (i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return number / i;
			}
		}
		return 1;
	}

	public static void main(String args[]) {
		System.out.println(minStepstoOne(50));
	}
}
