package com.java.tech.dp;

public class LongestCommonSubSequence {

	public static int findLongestCommonSubSequence(String x, String y) {
		if (x == null || x.isEmpty() || y == null || y.isEmpty()) {
			return 0;
		}

		int[][] a = new int[x.length() + 1][y.length() + 1];
		for (int i = 0; i < x.length(); i++) {
			a[i][0] = 0;
		}

		for (int j = 0; j < y.length(); j++) {
			a[0][j] = 0;
		}

		for (int i = 1; i <= x.length(); i++) {
			for (int j = 1; j <= y.length(); j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					a[i][j] = a[i - 1][j - 1] + 1;
				} else {

					a[i][j] = Math.max(a[i - 1][j - 1], Math.max(a[i][j - 1], a[i - 1][j]));
				}
			}
		}

		//displayMatrix(a);
		return a[x.length()][y.length()];

	}

	public static void displayMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {

		String x = "ABCDGH";
		String y = "AEDFHR";
		int length = findLongestCommonSubSequence(x, y);
		System.out.println(length);

		x = "ABC";
		y = "AC";
		length = findLongestCommonSubSequence(x, y);
		System.out.println(length);

	}

}
