package com.java.tech.dp.robot;

import java.util.HashMap;
import java.util.LinkedList;

import com.java.tech.common.CustomException;

public class RobotInGrid {

	Integer R;
	Integer C;
	Cell[][] cells;
	Integer obstacleCount;
	HashMap<Cell, Boolean> cache;
	LinkedList<Cell> paths;

	public RobotInGrid(int R, int C, int obstacleCount) throws CustomException {
		this.R = R;
		this.C = C;
		this.obstacleCount = obstacleCount;
		this.cache = new HashMap<Cell, Boolean>();
		this.paths = new LinkedList<Cell>();
		validateSetupBoardInputs(R, C, obstacleCount);
		initializeCells();
	}

	public void validateSetupBoardInputs(int R, int C, int B) throws CustomException {
		if (B > ((R * C) / 2)) {
			throw new CustomException("Obstacles should be less than the quarter");
		}
	}

	public void initializeCells() {

		cells = new Cell[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cells[i][j] = new Cell(i, j);
			}
		}
		placeObstacle();
	}

	public void placeObstacle() {
		int obstacleCount = this.obstacleCount;
		while (obstacleCount > 0) {
			int rowNumber = (int) Math.floor((Math.random()) * R);
			int columnNumber = (int) Math.floor((Math.random()) * C);
			Cell cell = cells[rowNumber][columnNumber];
			if (cell.isObstaclePlaced) {
				continue;
			}
			cell.setObstaclePlaced(true);
			cell.setDisplayString("*");
			obstacleCount -= 1;
		}

	}

	public void displayRealBoard() {

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				System.out.print(cells[i][j].getDisplayString() + " ");
			}
			System.out.println();
		}

	}

	public boolean findMinPath(int row, int column, Cell destination) {
		if (row < 0 || row >= R || column < 0 || column >= C) {
			return false;
		}

		Cell cell = cells[row][column];

		if (cell.isObstaclePlaced) {
			return false;
		}

		if (cache.containsKey(cell)) {
			return cache.get(cell);
		}

		boolean isDestination = (destination.getRow() == row && destination.getColumn() == column);
		boolean success = false;
		if (isDestination || findMinPath(row + 1, column, destination) || findMinPath(row, column + 1, destination)) {
			
			paths.add(cell);
			success = true;
		}
		cache.put(cell, success);
		return success;
	}

	// Non ideal solution
	public void findMinPathUnOptimal(int row, int column, Cell destination) {
		if (destination.getRow() == row && destination.getColumn() == column) {
			printPath();
			return;
		}

		Cell cell = cells[row][column];
		if (cell.isObstaclePlaced) {
			return;
		}

		if ((row + 1) < R) {
			paths.add(cells[row + 1][column]);
			findMinPathUnOptimal(row + 1, column, destination);
			paths.poll();

		}

		if ((column + 1) < C) {
			paths.add(cells[row][column + 1]);
			findMinPathUnOptimal(row, column + 1, destination);
			paths.poll();
		}

	}

	public void printPath() {
		// TODO Auto-generated method stub
		for (Cell cell : paths) {
			System.out.print("(" + cell.getRow() + "," + cell.getColumn() + ")=>");
		}
		System.out.println();
	}

}
