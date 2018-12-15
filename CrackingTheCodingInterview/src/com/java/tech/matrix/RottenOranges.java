package com.java.tech.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RottenOranges {

	public static int findRottenOranges(int[][] matrix) {
		HashMap<Integer, HashSet<Integer>> rowToColumnMap = new HashMap<>();
		LinkedList<Cell> rottenOrangesQueue = new LinkedList<Cell>();

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] != 0) {
					HashSet<Integer> cols = new HashSet<Integer>();
					if (rowToColumnMap.containsKey(row)) {
						cols = rowToColumnMap.get(row);
					}

					cols.add(col);
					rowToColumnMap.put(row, cols);
				}

				if (matrix[row][col] == 2) {
					rottenOrangesQueue.add(new Cell(row, col, 0));
				}
			}
		}

		Integer maxTimeFrame = 0;
		System.out.println(rottenOrangesQueue);
		while (!rottenOrangesQueue.isEmpty()) {

			Cell cell = rottenOrangesQueue.removeFirst();
			// System.out.println(cell);
			maxTimeFrame = rotAdjacentCells(cell, rottenOrangesQueue, rowToColumnMap, maxTimeFrame, matrix);
			removeElementFromMap(cell.getRow(), cell.getColumn(), rowToColumnMap);

		}

		System.out.println(rowToColumnMap);
		if (!rowToColumnMap.isEmpty()) {
			return -1;
		}
		return maxTimeFrame;
	}

	private static Integer rotAdjacentCells(Cell cell, LinkedList<Cell> rottenOrangesQueue,
			HashMap<Integer, HashSet<Integer>> rowToColumnMap, Integer maxTimeFrame, int[][] matrix) {
		int row = cell.getRow();
		int column = cell.getColumn();
		int timeframe = cell.getTimeFrameCount();

		if (((row - 1) >= 0) && (matrix[row - 1][column] == 1)) {
			matrix[row - 1][column] = 2;
			rottenOrangesQueue.add(new Cell(row - 1, column, timeframe+1));
			removeElementFromMap(row - 1, column, rowToColumnMap);
		}

		if (((row + 1) < matrix.length) && (matrix[row + 1][column] == 1)) {
			matrix[row + 1][column] = 2;
			rottenOrangesQueue.add(new Cell(row + 1, column, timeframe+1));
			removeElementFromMap(row + 1, column, rowToColumnMap);

		}

		if (((column - 1) >= 0) && (matrix[row][column - 1] == 1)) {
			matrix[row][column - 1] = 2;
			rottenOrangesQueue.add(new Cell(row, column - 1, timeframe+1));
			removeElementFromMap(row, column - 1, rowToColumnMap);

		}
		if (((column + 1) < matrix[0].length) && (matrix[row][column + 1] == 1)) {
			matrix[row][column + 1] = 2;
			rottenOrangesQueue.add(new Cell(row, column + 1, timeframe+1));
			removeElementFromMap(row, column + 1, rowToColumnMap);
		}

		maxTimeFrame = Math.max(maxTimeFrame, timeframe);
		return maxTimeFrame;
	}

	private static void removeElementFromMap(int row, int column, HashMap<Integer, HashSet<Integer>> rowToColumnMap) {
		if (rowToColumnMap.containsKey(row)) {
			HashSet<Integer> cols = rowToColumnMap.get(row);
			if (cols.contains(column)) {
				cols.remove(column);
			}
			if (cols.isEmpty()) {
				rowToColumnMap.remove(row);
			} else {
				rowToColumnMap.put(row, cols);
			}
		}

	}

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		//int arr[][] = { {2, 1, 0, 2, 1},{0, 0, 1, 2, 1},{1, 0, 0, 2, 1}};
		int ans = findRottenOranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);
		
	}
}
