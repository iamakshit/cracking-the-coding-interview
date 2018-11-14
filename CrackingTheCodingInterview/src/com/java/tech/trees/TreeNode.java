package com.java.tech.trees;

import java.util.ArrayList;

public class TreeNode<T> {

	T value;
	boolean visited = false;
	TreeNode<T> leftNode;
	TreeNode<T> rightNode;
	ArrayList<TreeNode<T>> adjacentNodes;

	public TreeNode() {
		this.adjacentNodes = new ArrayList<TreeNode<T>>();
		this.leftNode = new TreeNode<T>();
		this.rightNode = new TreeNode<T>();
	}

	public ArrayList<TreeNode<T>> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(ArrayList<TreeNode<T>> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public TreeNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
