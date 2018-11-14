package com.java.tech.common.data.structures.variations;

import java.util.Stack;

//Implement MyQueue using two stacks
public class MyQueue {

	Stack<Integer> pushStack;
	Stack<Integer> popStack;

	public MyQueue() {
		pushStack = new Stack<Integer>();
		popStack = new Stack<Integer>();
	}

	public void addElement(Integer element) {
		if (pushStack.isEmpty() && !popStack.isEmpty()) {
			while (!popStack.isEmpty()) {
				pushStack.push(popStack.pop());
			}
		}
		pushStack.push(element);

	}

	public int popElement() {
		if (popStack.isEmpty() && !pushStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}

		if (popStack.isEmpty() && pushStack.isEmpty()) {
			return -1;
		}
		return popStack.pop();
	}

	public void display() {
		System.out.println(this.pushStack.toString());
		System.out.println(this.popStack.toString());
	}
}
