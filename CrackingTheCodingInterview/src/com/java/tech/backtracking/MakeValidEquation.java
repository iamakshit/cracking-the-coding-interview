package com.java.tech.backtracking;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//Make Valid Equation (Backtracking)
//https://www.youtube.com/watch?v=14Jb7aycv3c
//https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form

public class MakeValidEquation { // VERY GOOD INPUT I HAVE GOTTEN
	static ScriptEngineManager mgr = new ScriptEngineManager();
	static ScriptEngine engine = mgr.getEngineByName("JavaScript");

	public static void makeValidEquation(StringBuilder expression, int index, Integer[] numbers, Integer expectedOutput)
			throws ScriptException {
		if ((numbers.length - 1 == (index))) {
			expression.append(numbers[index]);
			if ((engine.eval(expression.toString()) == expectedOutput)) {
				System.out.println(expression.toString());
			}
			return;
		}
		if (numbers.length > 0) {
			Integer number = numbers[index];
			makeValidEquation(new StringBuilder().append(expression).append(number).append("+"), index + 1, numbers,
					expectedOutput);
			makeValidEquation(new StringBuilder().append(expression).append(number).append("-"), index + 1, numbers,
					expectedOutput);
		}
	}

	public static void main(String args[]) throws ScriptException {
		Integer[] numbers = { 2, 3, 5, 1 };
		StringBuilder expression = new StringBuilder();
		Integer expectedOutput = 1;
		makeValidEquation(expression, 0, numbers, expectedOutput);
	}
}
