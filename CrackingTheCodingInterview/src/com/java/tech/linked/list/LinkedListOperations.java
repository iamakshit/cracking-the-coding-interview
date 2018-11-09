package com.java.tech.linked.list;

import java.util.Scanner;

import com.java.tech.common.CustomException;
import com.java.tech.common.ErrorCodes;

public class LinkedListOperations {
	Scanner ak = new Scanner(System.in);
	Integer data = 0;

	public void selectOptions(Node head) throws CustomException {

		while (true) {
			System.out.println("Enter the option that you want to refer to");
			String option = ak.nextLine();
			switch (option) {
			case "insertHead":
				System.out.println("Enter a value");
				data = Integer.parseInt(ak.nextLine());
				head = appendToHead(head, data); // Giving out reference is very important
				displayList(head);
				break;
			case "insertTail":
				System.out.println("Enter a value");
				data = Integer.parseInt(ak.nextLine());
				head = appendToTail(head, data); // Giving out reference is very important
				displayList(head);
				break;
			case "delete":
				System.out.println("Enter a value");
				data = Integer.parseInt(ak.nextLine());
				head = deleteNode(head, data); // Giving out reference is very important or else.
				displayList(head);
				break;
			case "display":
				displayList(head);
				break;
			case "partition":
				System.out.println("Enter a value");
				data = Integer.parseInt(ak.nextLine());
				head = partitionList(head, data);
				displayList(head);
				break;
			case "reverse":
				head = reverseLinkedList(head);
				displayList(head);
				break;
			case "palindrome":
				System.out.println(checkIfPalindrome(head));
				break;
			case "exit":
				System.exit(0);
			default:
				System.out.println("Wrong option entered");

			}
		}
	}

	public void displayList(Node head) {
		for (Node current = head; current != null; current = current.next) {
			System.out.print(current.data + "->");
		}
		System.out.println("NULL");
	}

	public Node appendToHead(Node head, int d) {
		Node node = new Node(d);
		node.next = head;
		return node;

	}

	public Node appendToTail(Node head, int d) {

		if (head == null) {
			return null;
		}

		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}

		currentNode.next = new Node(d);
		return head;
	}

	public Node deleteNode(Node head, int d) {
		if (head == null) {
			return null;
		}

		// You can write like this. int a=2,b=4; *RIGHT*
		// int a=2,int b=2;
		// keep all the cases in mind
		for (Node prev = null, current = head; current != null; prev = current, current = current.next) {

			if (current.data == d) {
				if (prev != null) {
					prev.next = current.next;
				} else {
					head = current.next;
				}
			}

		}

		return head;

	}

	public Node reverseLinkedList(Node head) {
		Node currentNode = head;
		Node previousNode = null, nextNode = null; // Have a look at this way of initialization
		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		return previousNode;
	}

	public boolean checkIfPalindrome(Node head) throws CustomException {
		if (head == null) {
			throw new CustomException(ErrorCodes.EMPTY_LIST.getMessage());
		}

		Node fastNode = head, slowNode = head;
		while (fastNode != null && fastNode.next != null) { //be very careful in the conditions
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}

		if (fastNode != null) {
			slowNode = slowNode.next;
		}

		Node secondHead = reverseLinkedList(slowNode);

		while (secondHead != null) {
			if (secondHead.data != head.data) {
				return false;
			}
			head = head.next;
			secondHead = secondHead.next;
		}

		return true;
	}

	public Node partitionList(Node head, int value) { /// please develop all the edge cases before you start on the
														/// problem.
		Node lessNode = null, moreNode = null;
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			if (currentNode.data < value) {
				if (lessNode == null) {
					lessNode = currentNode;
					currentNode = currentNode.next;
					lessNode.next = null;
				} else {
					Node next = currentNode.next;
					currentNode.next = lessNode;
					lessNode = currentNode;
					currentNode = next;
				}
			} else {
				if (moreNode == null) {
					moreNode = currentNode;
					currentNode = currentNode.next;
					moreNode.next = null;
				} else {
					Node next = currentNode.next;
					currentNode.next = moreNode;
					moreNode = currentNode;
					currentNode = next;
				}
			}
		}
		System.out.println(lessNode.data);
		// System.out.println(moreNode.data);
		currentNode = lessNode;
		while (lessNode.next != null) {
			System.out.println(lessNode.data);
			lessNode = lessNode.next;
		}
		lessNode.next = moreNode;
		return currentNode;
	}
}
