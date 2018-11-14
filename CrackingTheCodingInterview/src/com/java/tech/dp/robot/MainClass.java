package com.java.tech.dp.robot;

import java.util.ArrayList;

import com.java.tech.common.CustomException;

public class MainClass {

	public static void prepareList(ArrayList<Integer> list, int n) {
		if (n > 0) {
			list.add(n);
			n=n-1;
			prepareList(list,n);
		}

	}

	public static void main(String args[]) throws CustomException {
		
		RobotInGrid robotInGrid = new RobotInGrid(4,4,6);
		robotInGrid.displayRealBoard();
		Cell destination = new Cell(3,3);
		robotInGrid.findMinPath(0,0,destination);
		robotInGrid.printPath();
		
	}
}
