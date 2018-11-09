import java.util.ArrayList;
import java.util.Arrays;

import com.java.tech.common.CustomException;
import com.java.tech.common.data.structures.Combination;
import com.java.tech.linked.list.LinkedListOperations;
import com.java.tech.linked.list.Node;
import com.java.tech.numbers.NumbersOperations;
import com.java.tech.string.StringOperations;

public class MainClass {

	public static void main(String args[]) throws CustomException {
		
		LinkedListOperations ops = new LinkedListOperations();
		Node head = new Node(3);
		ops.selectOptions(head);
		ops.selectOptions(head);

	}

	private static void numberOperations() {

		ArrayList<Integer> numbers;
		ArrayList<Combination<Integer, Integer>> output;

		numbers = new ArrayList<>(Arrays.asList(5, 20, 3, 2, 50, 80));
		NumbersOperations numbersCombinationSum = new NumbersOperations();

		output = numbersCombinationSum.findCombinations(78, numbers);
		System.out.println(output);

		numbers = new ArrayList<>(Arrays.asList(90, 70, 20, 80, 50));
		output = numbersCombinationSum.findCombinations(45, numbers);
		System.out.println(output);

		numbers = new ArrayList<>(Arrays.asList(1, 7, 5, 9, 2, 12, 3));
		output = numbersCombinationSum.findCombinations(2, numbers);
		System.out.println(output);

	}

	private static void stringOperations() {
		StringOperations strOps = new StringOperations();

		// System.out.println(strOps.stringCompression("aabcccccaaa"));

		System.out.println(strOps.checkifOneAway("pale", "ple"));
		System.out.println(strOps.checkifOneAway("pales", "pale"));
		System.out.println(strOps.checkifOneAway("pale", "bale"));
		System.out.println(strOps.checkifOneAway("pale", "bake"));

		String str = "          Akshit       is a good boy  ";
		str = str.replaceAll("\\s+", " ");
		System.out.println("(" + str + ")");

		String input = new String("");
		// System.out.println(input);

		String option = null;
		if (option == null || option.isEmpty()) {
			// System.out.println("ghghhg");
		}

		// option = "Akshit";

		// String x = "ab".substring(1, 1);
		// System.out.println(x);

		try {
			StringOperations stringOperation = new StringOperations();
			stringOperation.stringOperations("ab", "combination");
			stringOperation.stringOperations("abc", "permutation");
		} catch (CustomException exception) {
			System.out.println(exception);
		}

	}
}
