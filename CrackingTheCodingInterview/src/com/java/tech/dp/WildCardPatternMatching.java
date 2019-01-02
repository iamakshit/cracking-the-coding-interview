package com.java.tech.dp;

// https://www.geeksforgeeks.org/wildcard-pattern-matching/
public class WildCardPatternMatching {

	public static boolean isWildPattern(boolean[][] T, String input, String pattern) {

		int rowLength = input.length();
		int colLength = pattern.length();
		for (int i = 0; i <= rowLength; i++) {
			for (int j = 0; j <= colLength; j++) {
				if ((i == 0) || (j == 0)) {
					T[i][j] = true;
					continue;
				}

				if (pattern.charAt(j - 1) == '*') {
					T[i][j] = (T[i - 1][j]) || (T[i][j - 1]);
				} else if (pattern.charAt(j - 1) == '?') {
					T[i][j] = T[i - 1][j - 1];
				} else {
					T[i][j] = (pattern.charAt(j - 1) == input.charAt(i - 1));
					if (T[i][j]) {
						T[i][j] = T[i - 1][j - 1];
					}
				}
			}
		}
		return T[rowLength][colLength];
	}

	public static void main(String args[]) {

		String text = "";
		String pattern = "";
		boolean[][] T = new boolean[text.length() + 1][pattern.length() + 1];
	}
}
