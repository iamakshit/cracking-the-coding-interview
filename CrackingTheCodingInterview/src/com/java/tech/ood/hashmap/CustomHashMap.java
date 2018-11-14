package com.java.tech.ood.hashmap;

import java.util.ArrayList;

public class CustomHashMap<K, V> {

	ArrayList<LinkedListNode<K, V>> list;
	int size;

	public CustomHashMap(int size) {
		list = new ArrayList<LinkedListNode<K, V>>();
		list.ensureCapacity(size);
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
		this.size = size;
	}

	public int computeKey(K key) throws Exception {
		if (key == null) {
			throw new Exception("Key can't be null");
		}

		int length = key.toString().length();
		length = length % size;
		return length;
	}

	public void put(K key, V value) throws Exception {
		int index = computeKey(key);
		LinkedListNode<K, V> node = list.get(index);

		if (node == null) {
			node = new LinkedListNode<K, V>(key, value);
			list.set(index, node);
		} else {
			while (node.getNextNode() != null && node.getKey() != key) {
				node = node.getNextNode();
			}
			if (node.getKey() == key) {
				node.setValue(value);
			} else // (node.getNextNode() == null) {
			{
				LinkedListNode<K, V> newNode = new LinkedListNode<K, V>(key, value);
				node.setNextNode(newNode);
				newNode.setPreviousNode(node);
			}
		}
	}

	public V get(K key) throws Exception {
		int index = computeKey(key);
		LinkedListNode<K, V> node = list.get(index);
		while (node != null && node.getKey() != key) {
			node = node.getNextNode();
		}
		if (node == null) {
			throw new Exception("No Value Found for that key");
		}

		return node.getValue();

	}

	public void remove(K key) throws Exception {
		int index = computeKey(key);
		LinkedListNode<K, V> node = list.get(index);
		if (node == null) {
			throw new Exception("Node not found");
		}

		LinkedListNode<K, V> prev = null, cur = null;
		for (prev = null, cur = node; cur != null; prev = cur, cur = cur.getNextNode()) {
			if (cur.getKey() == key) {
				if (prev == null) {
					list.set(index, null);
					return;
				}
				prev.setNextNode(cur.getNextNode());
				if (cur.getNextNode() != null) {
					cur.getNextNode().setPreviousNode(prev);
					return;
				}
			}
		}

		throw new Exception("Could not find the key");
	}

}
