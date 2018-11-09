package com.java.tech.common.data.structures;

import java.util.LinkedList;

import com.java.tech.common.CustomException;
import com.java.tech.common.ErrorCodes;

/**
 * LESSONS LEARNT: 
 * 1. Constructor never has generic T
 */

public class Queue<T> {

	private LinkedList<T> queue;

	public Queue() {
		queue = new LinkedList<T>();
	}

	public void addElement(T element) {
		queue.addLast(element);
	}

	public T removeAndGetElement() throws CustomException {
		if ((queue == null) || (queue.isEmpty())) {
			throw new CustomException(ErrorCodes.QUEUE_IS_EMPTY.getMessage());
		}
		T element = queue.getLast();
		return element;

	}
}
