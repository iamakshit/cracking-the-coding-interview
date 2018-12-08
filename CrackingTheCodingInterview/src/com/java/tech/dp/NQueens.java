package com.java.tech.dp;

public class NQueens {

	int n;
	int[][] grid;
	boolean[] rows;
	boolean[] columns;

	public NQueens(int n) {
		this.n = n;
		grid = new int[n][n];
		rows = new boolean[n];
		columns = new boolean[n];
	}

	public void placeNQueens(int row) {
		if (row == n) {
			displayGrid();
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isQueenSafe(row, i, grid)) {
				grid[row][i] = 1;
				rows[row] = true;
				columns[i] = true;

				placeNQueens(row + 1);

				rows[row] = false;
				columns[i] = false;
				grid[row][i] = 0;
			}
		}
	}

	public boolean isQueenSafe(int row, int column, int[][] grid) {
		if (rows[row] || columns[column]) {
			return false;
		}
		int i = 0;
		while ((row - i) >= 0 && (column - i) >= 0) {
			if (grid[row - i][column - i] == 1) {
				return false;
			}
			i += 1;
		}

		while ((row + i) < grid.length && (column + i) < grid.length) {
			if (grid[row + i][column + i] == 1) {
				return false;
			}
			i += 1;
		}
		return true;
	}

	public void displayGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
