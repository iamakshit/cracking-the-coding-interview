package com.java.tech.dp;

public class CuttingRod {

	private static int[] lengthToPrice = {0, 1, 5, 8, 9, 10, 17, 17, 20 };

	public static int findCuttingMethod(int value) {
		int[] a = new int[value + 1];
		for (int i = 1; i <= value; i++) {
			for(int j=1;j<=i;j++)
			{
				a[i] = Math.max(a[i], lengthToPrice[j]+a[i-j]);
			}
		}
		return a[value];
	}
	
	public static void main(String args[])
	{
		System.out.println(findCuttingMethod(1));
		System.out.println(findCuttingMethod(2));
		System.out.println(findCuttingMethod(3));
		System.out.println(findCuttingMethod(4));
		System.out.println(findCuttingMethod(5));
		System.out.println(findCuttingMethod(6));

	}
}
