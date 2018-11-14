package com.java.tech.dp.robot;

public class Cell {

	Integer row;
	Integer column;
	boolean isObstaclePlaced = false;
	String displayString = "-";

	public Cell(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public String getDisplayString() {
		return displayString;
	}

	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer coliumn) {
		this.column = coliumn;
	}

	public boolean isObstaclePlaced() {
		return isObstaclePlaced;
	}

	public void setObstaclePlaced(boolean isObstaclePlaced) {
		this.isObstaclePlaced = isObstaclePlaced;
	}

}
