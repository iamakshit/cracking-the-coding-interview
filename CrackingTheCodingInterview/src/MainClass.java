import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import com.java.tech.bit.BitManipulationOperations;
import com.java.tech.common.CustomException;
import com.java.tech.common.data.structures.Combination;
import com.java.tech.common.data.structures.Heap;
import com.java.tech.common.data.structures.variations.MyQueue;
import com.java.tech.common.data.structures.variations.StackOfPlates;
import com.java.tech.dp.Coins;
import com.java.tech.dp.FibbonacciSeries;
import com.java.tech.dp.NQueens;
import com.java.tech.linked.list.LinkedListOperations;
import com.java.tech.linked.list.Node;
import com.java.tech.numbers.NumbersOperations;
import com.java.tech.ood.callcenter.employee.Employee;
import com.java.tech.ood.callcenter.employee.Manager;
import com.java.tech.ood.hashmap.CustomHashMap;
import com.java.tech.sort.CountingSort;
import com.java.tech.sort.MergeSort;
import com.java.tech.string.StringOperations;
import com.java.tech.trees.TreeNode;
import com.java.tech.trees.TreeOperations;

class X {
	//
	public X() {

	}

	public Integer y;
}

public class MainClass {

	static Boolean sa;

	public static void testMethod(X x, Integer a) {
		x.y = 1;
		a = 2;
	}

	public static void main(String args[]) throws CustomException {
		
		ArrayList<String> A;
		
		int[] a = { 10, 1, 4, 3, 2, 7, 9, 12 };

		MergeSort mS = new MergeSort();
		mS.sort(a, 0, a.length);
		mS.displayArray(a);

	}

	public void NQueens() {
		NQueens nQueens = new NQueens(4);
		nQueens.placeNQueens(0);
	}

	public void bitWiseOperation() {
		BitManipulationOperations bOps = new BitManipulationOperations();
		System.out.println(bOps.checkIfPowerOfTwo(8));
		System.out.println(bOps.checkIfPowerOfTwo(9));
		System.out.println(bOps.checkIfPowerOfTwo(7));
	}

	public void countingSort() {
		CountingSort countingSort = new CountingSort(100);
		int[] input = { 4, 20, 3, 66, 1, 1, 3, 4, 4 };
		LinkedList<Integer> output = countingSort.countingSort(input);
		countingSort.displaySortedList(output);
	}

	public void coinChange() {
		Coins coinChange = new Coins();
		int x = coinChange.countNumberOfWays(4);

		double startTime = System.currentTimeMillis();
		int y = coinChange.countMinNumberOfWays(5);
		double endTime = System.currentTimeMillis();
		int z = coinChange.countMinNumberOfWaysOptimal(5);
		double anotherEndTime = System.currentTimeMillis();

		System.out.println(x);
		System.out.println(y);
		System.out.println(z);

		System.out.println(endTime - startTime); // 320010.0 ns
		System.out.println(anotherEndTime - endTime);// 125839.0 ns

	}

	public static void computeFibbonacci() {
		FibbonacciSeries fs = new FibbonacciSeries(50);
		for (int i = 0; i < 10; i++) {
			System.out.print(fs.computeFibbonacci(i) + " ,");
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.print(fs.computeFibbonacciBottom(i) + " ,");
		}

	}

	public void customHashMap() {
		try {
			CustomHashMap<String, String> hashMap = new CustomHashMap<String, String>(3);
			hashMap.put("AB", "Gupta");
			hashMap.put("AB", "Akshit");
			System.out.println(hashMap.get("AB"));
			hashMap.remove("AB");
			System.out.println(hashMap.get("AB"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void casting() {

		Employee manager = new Manager(); //
		Manager employee = (Manager) new Employee(); //
	}

	public void treeOps() {
		TreeOperations tOps = new TreeOperations();
		int[] list = { 1, 2, 3, 4, 5 };
		TreeNode<Integer> node = tOps.buildBST(list, 0, 5);
		System.out.println(node);
		System.out.println(node.getLeftNode());
		System.out.println(node.getRightNode());

		System.out.println("*****");

		TreeNode leftNode = node.getLeftNode();
		System.out.println(leftNode);
		System.out.println(leftNode.getLeftNode());
		System.out.println(leftNode.getRightNode());

		System.out.println("*****");

		TreeNode rightNode = node.getRightNode();
		System.out.println(rightNode);
		System.out.println(rightNode.getLeftNode());
		System.out.println(rightNode.getRightNode());

	}

	public void intTest() {
		System.out.println(Math.ceil(5 / 2));// Output is 2
		System.out.println(Math.ceil(5.0 / 2.0)); // Output is 3
	}

	public void myHeap() {
		Heap heap = new Heap();
		int[] array = { 4, 3, 7, 1, 8, 5 }; // Best way to initialize the array
		array = heap.swap(array, 0, 1);
		array = heap.heapSort(array);
		heap.displayList(array);

		System.out.println();
		int[] array_b = { 1, 3, 4, 8, 5 };
		array_b = heap.maxHeapify(array_b, 0, array_b.length);
		heap.displayList(array_b);

	}

	public void myQueue() {
		MyQueue queue = new MyQueue();
		queue.addElement(2);
		queue.addElement(1);
		System.out.println(queue.popElement());
		queue.addElement(3);
		System.out.println(queue.popElement());
		System.out.println(queue.popElement());
		System.out.println(queue.popElement());
		System.out.println(queue.popElement());
	}

	public static void stackOfPlates() {
		StackOfPlates stackOfPlates = new StackOfPlates(2);
		stackOfPlates.add(1);
		stackOfPlates.add(3);
		stackOfPlates.add(10);
		stackOfPlates.add(2);
		stackOfPlates.printStack(1);
		stackOfPlates.printStack(2);
		stackOfPlates.popAt(1);
		stackOfPlates.printStack(1);
	}

	private static void linkedListOperations() {
		LinkedListOperations ops = new LinkedListOperations();
		Node head = new Node(3);
		// ops.selectOptions(head);
		// ops.selectOptions(head);
		LinkedListOperations linkedOps = new LinkedListOperations();
		// Node head = new Node(3);
		// linkedOps.selectOptions(head);
	}

	private static void numberOperations() {
		NumbersOperations nOps = new NumbersOperations();
		// int[] a = {1,4,5,8,9,2,3,6,7,10};
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		nOps.divideArrayInMinDifference(a);
		System.out.println(nOps.sumOfDigits(98101));
		System.out.println(nOps.powerFunction(10, 3));

		int[] list = { 5, 7, 10, 12, 15, 18, 20 };
		nOps.sumOfSubsets(list, 35);

		ArrayList<Integer> numbers;
		ArrayList<Combination<Integer, Integer>> output;

		numbers = new ArrayList<>(Arrays.asList(5, 20, 3, 2, 50, 80));
		NumbersOperations numbersCombinationSum = new NumbersOperations();

		System.out.println(numbersCombinationSum.multiplicationMinComputation(16, 35));

		output = numbersCombinationSum.findCombinations(78, numbers);
		System.out.println(output);

		numbers = new ArrayList<>(Arrays.asList(90, 70, 20, 80, 50));
		output = numbersCombinationSum.findCombinations(45, numbers);
		System.out.println(output);

		numbers = new ArrayList<>(Arrays.asList(1, 7, 5, 9, 2, 12, 3));
		output = numbersCombinationSum.findCombinations(2, numbers);
		System.out.println(output);

	}

	private static void stringOperations() throws CustomException {
		StringOperations sOps = new StringOperations();
		sOps.generateInterleavingStrings("ABC", "DEF", 0, 0, new StringBuilder());

		StringOperations strOps = new StringOperations();
		strOps.parens(3);

		strOps.permutateDuplicate("aabb");

		String[] input = { "cat", "dog", "tac", "god", "act" };
		ArrayList<String> list = strOps.sortWithAnagramsNextToEachOther(input);

		for (String s : list) {
			System.out.println(s);
		}

		System.out.println(strOps.stringCompression("aabcccccaaa"));

		System.out.println(strOps.checkifOneAway("pale", "ple"));
		System.out.println(strOps.checkifOneAway("pales", "pale"));
		System.out.println(strOps.checkifOneAway("pale", "bale"));
		System.out.println(strOps.checkifOneAway("pale", "bake"));

		String str = "          Akshit       is a good boy  ";
		str = str.replaceAll("\\s+", " ");
		System.out.println("(" + str + ")");

		strOps.stringOperations("ab", "combination");
		strOps.stringOperations("abc", "permutation");

	}
}
