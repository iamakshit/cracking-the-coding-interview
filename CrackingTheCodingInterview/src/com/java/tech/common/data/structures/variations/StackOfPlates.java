package com.java.tech.common.data.structures.variations;

import java.util.LinkedList;

public class StackOfPlates {

	// Stack Object
	public class Stack {

		LinkedList<Integer> stackElements;

		public Stack() {
			stackElements = new LinkedList<>();
		}

		public LinkedList<Integer> getStackElements() {
			return stackElements;
		}

		public void setStackElements(LinkedList<Integer> stackElements) {
			this.stackElements = stackElements;
		}
	}

	LinkedList<Stack> plates;
	int size;

	public StackOfPlates(int size) {
		this.plates = new LinkedList<>();
		this.size = size;
	}

	private Stack createStack(int element) {
		Stack stack = new Stack();
		LinkedList<Integer> stackElements = new LinkedList<Integer>();
		stackElements.add(element);
		stack.setStackElements(stackElements);
		return stack;
	}

	public void add(int element) {
		if (plates.isEmpty()) {
			plates.add(createStack(element));
			return;
		}

		if (plates.peekLast().getStackElements().size() >= size) {
			plates.add(createStack(element));
			return;
		}

		Stack stack = plates.pollLast();
		LinkedList<Integer> list = stack.getStackElements();
		list.add(element);
		stack.setStackElements(list);
		plates.push(stack);

	}

	public int popAt(int substack) {
		if (this.plates.size() < substack) {
			return -1;
		}

		Stack stack = plates.get(substack - 1);
		Integer number = stack.getStackElements().pop();
		return number;
	}

	public void printStack(int subStack) {
		if (this.plates.size() < subStack) {
			return;
		}

		System.out.println(plates.get(subStack - 1).getStackElements().toString());
	}

}
