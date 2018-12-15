package com.java.tech.matrix;

public class Cell {

	int row;
	int column;
	int timeFrameCount = 0;

	public Cell(int row, int column, int timeFrameCount) {
		this.row = row;
		this.column = column;
		this.timeFrameCount = timeFrameCount;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getTimeFrameCount() {
		return timeFrameCount;
	}

	public void setTimeFrameCount(int timeFrameCount) {
		this.timeFrameCount = timeFrameCount;
	}

	@Override
	public String toString() {
		return "Cell [row=" + row + ", column=" + column + ", timeFrameCount=" + timeFrameCount + "]";
	}

}
