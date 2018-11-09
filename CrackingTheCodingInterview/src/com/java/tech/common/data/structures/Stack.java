package com.java.tech.common.data.structures;

import java.util.LinkedList;

import com.java.tech.common.CustomException;
import com.java.tech.common.ErrorCodes;

/*
 * LESSONS LEARNT
 * 1> or does not work in java. || works in Java
 * 2> throws and throwable
 * 3> Java always uses new. Python does not use "New"
 * 4> LinkedList has removeFirst/removeLast. It also has addFirst/addLast
 * */
public class Stack<T> {

	private LinkedList<T> stack;
	
	public Stack()
	{
		stack = new LinkedList<T>();
	}
	
	public void push(T element)
	{
		stack.add(element);
	}
	
	public T pop() throws CustomException
	{
		if((stack == null) || (stack.isEmpty()))
		{
			throw new CustomException(ErrorCodes.STACK_IS_EMPTY.getMessage());
		}
	
		T element = stack.pop();
		return element;
	}
}
