package com.java.tech.ood.hashmap;

public class LinkedListNode<K, V> {
	LinkedListNode<K, V> previousNode;
	LinkedListNode<K, V> nextNode;
	K key;
	V value;

	public LinkedListNode(K k, V v) {
		this.key = k;
		this.value = v;

	}

	public LinkedListNode<K, V> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(LinkedListNode<K, V> previousNode) {
		this.previousNode = previousNode;
	}

	public LinkedListNode<K, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkedListNode<K, V> nextNode) {
		this.nextNode = nextNode;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
