package com.java.tech.dp;

public class EditDistance {

	// Please solve the question on paper before proceeding
	public static int editDistance(String a, String b) {
		int[][] matrix = new int[a.length() + 1][b.length() + 1];
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {

				if (i == 0) {
					matrix[0][j] = j;
					continue;
				}
				if (j == 0) {
					matrix[i][0] = i;
					continue;
				}

				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
				}
			}

		}
		displayBoard(matrix);
		return matrix[a.length()][b.length()];
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
		int length = editDistance("sunday", "saturday");
		System.out.println(length);
	}
}
