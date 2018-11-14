package com.java.tech.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeOperations {

	public void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}

		inOrderTraversal(node.getLeftNode());
		System.out.println(node.getValue());
		inOrderTraversal(node.getRightNode());

	}

	public TreeNode<Integer> buildBST(int[] list, int start, int end) {
		if (start < end) {
			int mid = ((start + end) / 2);
			System.out.println("Mid =" + mid + " Start =" + start + " End =" + end);
			TreeNode<Integer> node = createTreeNode(list[mid]);
			TreeNode<Integer> leftNode = buildBST(list, start, mid);
			TreeNode<Integer> rightNode = buildBST(list, mid + 1, end);
			node.setLeftNode(leftNode);
			node.setRightNode(rightNode);
			return node;
		}
		return null;
	}

	public boolean DFS(TreeNode<Integer> node, int value) {

		if (node == null) {
			return false;
		}

		if (node.getValue() == value) {
			return true;
		}

		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();
		stack.push(node);
		while (!stack.isEmpty()) {
			TreeNode<Integer> stackNode = stack.pop();
			stackNode.setVisited(true);
			if (stackNode.getValue() == value) {
				return true;
			}
			ArrayList<TreeNode<Integer>> adjacentNodes = stackNode.getAdjacentNodes();
			for (TreeNode<Integer> adjacentNode : adjacentNodes) {
				stack.push(adjacentNode);
			}
		}
		return false;
	}

	public boolean BFS(TreeNode<Integer> node, int value) // Always mark a node visited and not visited
	// Java also has a util called Queue
	// We have a stack class and an interface called Queue
	{
		if (node == null) {
			return false;
		}

		if (node.getValue() == value) {
			return true;
		}

		// Queue<Integer> queue = new Queue() ; //NOT POSSIBLE AS QUEUE IS AN INTERFACE
		// MAKE SURE YOU HAVE VISITED NOTED AS WELL.
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {// poll removes the head of the queue
			TreeNode<Integer> queueNode = queue.poll();
			queueNode.setVisited(true);
			if (queueNode.value == value) {
				return true;
			}
			ArrayList<TreeNode<Integer>> adjacentNodes = queueNode.adjacentNodes;
			for (TreeNode<Integer> adjacentNode : adjacentNodes) {
				if (!adjacentNode.isVisited()) {
					queue.add(adjacentNode);
				}
			}
		}
		return false;
	}

	private TreeNode<Integer> createTreeNode(int i) {
		// TODO Auto-generated method stub
		TreeNode<Integer> node = new TreeNode<Integer>(i);
		return node;
	}
}
