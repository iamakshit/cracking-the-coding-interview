package com.java.tech.dp;

public class LongestPalindromeSubString {

/*	public static int findLongestCommonSubString(String input) {
		int[][] matrix = new int[input.length() + 1][input.length() + 1];
		for (int i = 0; i <= input.length(); i++) {
			for (int j = 0; j <= input.length(); j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
					continue;
				}
				if (input.charAt(i - 1) == input.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], Math.max(matrix[i][j - 1], matrix[i - 1][j - 1]));
				}

			}
		}
		displayBoard(matrix);
		return matrix[input.length()][input.length()];

	}
*/
	public static int findLongestCommonSubString(int[][] matrix, String input, int i, int j) {
		
		if (i > j) {
			return 0;
		}

		if (matrix[i][j] != 0) {
			return matrix[i][j];
		}
		
		if (i == 0 || j == 0) {
			matrix[i][j] = 0;
			return matrix[i][j];
		}
		
		if (input.charAt(i - 1) == input.charAt(j - 1)) {
			System.out.println("Yes");
			int length = findLongestCommonSubString(matrix, input, i - 1, j - 1);
			matrix[i][j] = length + 1;
		} else {
			int length = Math.max(findLongestCommonSubString(matrix, input, i - 1, j - 1),
					Math.max(findLongestCommonSubString(matrix, input, i, j - 1),
							findLongestCommonSubString(matrix, input, i - 1, j)));
			matrix[i][j] = length;
		}

		return matrix[i][j];
	}

	public static void displayBoard(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		//TODO The code is incomplete
		String input = "zabaz";

		int[][] matrix = new int[input.length() + 1][input.length() + 1];
		int length = findLongestCommonSubString(matrix, input, 1,input.length());
		displayBoard(matrix);

	}
}
