package com.java.tech.dp;

public class SubSetSum {
	static Integer[] list = { 3, 34, 4, 12, 5, 2 };
	static Integer sum = 1;
	static boolean[][] matrix = new boolean[list.length + 1][sum + 1];

	public static void subSetSum() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0) {
					matrix[i][j] = false;
					continue;
				}
				if (j == 0) {
					matrix[i][j] = true;
					continue;
				}

				int output = j - (list[i - 1]);
				if (output == 0) {
					matrix[i][j] = true;
					continue;
				}
				if ((output > 0) && (matrix[i][output])) {
					System.out.println(i + " " + j + " " + output);
					matrix[i][j] = true;
					continue;
				}
				matrix[i][j] = matrix[i - 1][j];

			}
		}

		System.out.println(matrix[list.length][sum]);
	}

	public static void display() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		subSetSum();
		display();
	}
}
