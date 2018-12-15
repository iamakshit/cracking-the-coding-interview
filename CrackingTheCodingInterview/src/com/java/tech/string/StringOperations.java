package com.java.tech.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import com.java.tech.common.CustomException;
import com.java.tech.common.ErrorCodes;

/**
 * 
 * Remember to have the break operation in the switch case substring(0,0) ==> No
 * String You got concurrent modification exception for combination remember
 * that. Can't use continue outside of the loop arraylist.get() will throw error
 * if it does not exist boolean [] isCharacterUsed = new
 * boolean[input.length()];
 * 
 * Whenever you want to sort the string, convert that to the charArray and then
 * sort the string
 * 
 * int array by default has values 0
 * 
 * str = str.replaceAll("\\s+", " "); (Right) str.replaceAll("\\s+", " ");
 * (Wrong)
 **/
public class StringOperations {

	public void stringOperations(String input, String option) throws CustomException {
		switch (option) {
		case "permutation":
			permutation(input);
			break;
		case "combination":
			combination(input);
			break;
		default:
			throw new CustomException(ErrorCodes.WRONG_INPUT_CASE.getMessage());
		}
	}

	public void validateInput(String input) throws CustomException {
		if (input == null || input.isEmpty()) {
			throw new CustomException(ErrorCodes.EMPTY_STRING_ENTERED.getMessage());
		}
	}

	/******************************************************************************************/

	private String sortString(String a) {
		char[] a_array = a.toCharArray();
		Arrays.sort(a_array);
		return a_array.toString();
	}

	public boolean checkIfPermutationBySort(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		return sortString(a).equals(sortString(b));
	}

	public boolean checkIfPermutationByCharCounts(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		int[] letters = new int[255];
		for (char ch : a.toCharArray()) {
			int num = (int) ch;
			letters[num]++;
		}

		for (char ch : b.toCharArray()) {
			int num = (int) ch;
			letters[num]--;
			if (letters[num] < 0) {
				return false;
			}
		}
		return true;
	}

	/******************************************************************************************/

	private void combination(String input) {
		List<String> combinations = new ArrayList<String>();
		combinations.add("");

		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			List<String> list = new ArrayList<String>();
			for (String string : combinations) {
				list.addAll(combineString(string, ch));
			}
			combinations.addAll(list);
		}

		System.out.println(combinations);
	}

	private List<String> combineString(String string, Character ch) {
		List<String> list = new ArrayList<String>();
		if (string.length() == 0) {
			list.add(ch.toString());
		} else if (string.length() == 1) {
			list.add((ch + string));
			list.add((string + ch));
		} else {
			for (int i = 0; i < string.length(); i++) {
				String str = string.substring(0, i) + ch + string.substring(i, string.length());
				list.add(str);
			}
		}
		return list;
	}

	/******************************************************************************************/

	private void permutation(String input) {
		HashSet<String> permutations = new HashSet<String>();
		// ArrayList<Boolean> isCharacterUsed = new ArrayList<Boolean>();
		boolean[] isCharacterUsed = new boolean[input.length()];
		for (int i = 0; i < input.length(); i++) {
			permutateString(permutations, input, new StringBuilder(), i, isCharacterUsed);
		}
		System.out.println(permutations);
	}

	private void permutateString(HashSet<String> permutations, String input, StringBuilder finalString, int index,
			boolean[] isCharacterUsed) {
		if (finalString.length() == input.length()) {
			permutations.add(finalString.toString());
			return;
		}

		if (index >= input.length() || isCharacterUsed[index]) {
			return;
		}

		isCharacterUsed[index] = true;
		finalString.append(input.charAt(index));

		for (int i = 0; i < input.length(); i++) {
			permutateString(permutations, input, finalString, i, isCharacterUsed);

		}
		finalString.setLength(finalString.length() - 1);
		isCharacterUsed[index] = false;
	}

	/******************************************************************************************/

	public boolean checkifOneAway(String firstStr, String secondStr) {
		int[] letters = new int[256];
		for (char ch : firstStr.toCharArray()) {
			int num = (int) ch;
			letters[num]++;
		}

		for (char ch : secondStr.toCharArray()) {
			int num = (int) ch;
			letters[num]--;
		}

		int count = 0;
		for (int i = 0; i < 256; i++) {
			if (letters[i] > 1 || letters[i] < -1) {
				return false;
			}

			if (letters[i] != 0) {
				count++;
			}
			if (count > 2) {
				return false;
			}
		}
		return true;
	}

	/******************************************************************************************/

	public String stringCompression(String input) throws CustomException {
		validateInput(input);
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			int count = 0;
			while (((i + count) < input.length()) && (ch == input.charAt(i + count))) {
				count++;
			}
			i = i + count - 1; /// YOU MISSED OUT THIS STEP (BE CAREFUL HERE)
			output.append(ch);
			output.append(count);
		}
		return output.toString();
	}

	/******************************************************************************************/

	public boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		s1 += s2;
		if (s1.contains(s2)) {
			return true;
		}
		return false;
	}

	/******************************************************************************************/

	public void permutateDuplicate(String input) {
		HashMap<Character, Integer> charToCountMap = new HashMap<>();
		for (Character ch : input.toCharArray()) {
			if (charToCountMap.containsKey(ch)) {
				charToCountMap.put(ch, charToCountMap.get(ch) + 1);
			} else {
				charToCountMap.put(ch, 1);
			}
		}

		permuatationDuplicate(charToCountMap, new StringBuilder(), input.length());

	}

	public void permuatationDuplicate(HashMap<Character, Integer> charToCountMap, StringBuilder output, int length) {
		if (output.length() == length) {
			System.out.println(output);
		}

		for (Character ch : charToCountMap.keySet()) {
			if (charToCountMap.get(ch) <= 0) {
				continue;
			}
			charToCountMap.put(ch, charToCountMap.get(ch) - 1);
			output.append(ch);
			permuatationDuplicate(charToCountMap, output, length);
			output.setLength(output.length() - 1);
			charToCountMap.put(ch, charToCountMap.get(ch) + 1);

		}
	}

	/******************************************************************************************/

	public void parens(int count) {

		parensthesisCount(new StringBuilder(), count, count);
	}

	public void parensthesisCount(StringBuilder output, int leftParensCount, int rightParensCount) {
		if (leftParensCount == 0 && rightParensCount == 0) {
			System.out.println(output);
		}

		if (leftParensCount > 0) {
			output.append("(");
			parensthesisCount(output, leftParensCount - 1, rightParensCount);
			output.setLength(output.length() - 1);
		}
		if (rightParensCount > 0 && leftParensCount < rightParensCount) {
			output.append(")");
			parensthesisCount(output, leftParensCount, rightParensCount - 1);
			output.setLength(output.length() - 1);
		}
	}

	/******************************************************************************************/

	public ArrayList<String> sortWithAnagramsNextToEachOther(String[] list) {
		TreeMap<String, TreeSet<String>> map = new TreeMap<String, TreeSet<String>>();
		for (String s : list) {
			char[] array = s.toCharArray();
			Arrays.sort(array);
			String sortedString = new String(array);
			// System.out.println(sortedString);
			// Remember to convert the character array to string, you need new String and
			// not
			// the toString method

			if (map.containsKey(sortedString)) {
				TreeSet<String> set = map.get(sortedString);
				set.add(s);
			} else {
				TreeSet<String> set = new TreeSet<>();
				set.add(s);
				map.put(sortedString, set);
			}
		}
		ArrayList<String> output = new ArrayList<>();
		for (String s : map.keySet()) {

			output.addAll(map.get(s));
		}

		return output;
	}

	/******************************************************************************************/

	public void generateInterleavingStrings(String s1, String s2, int l1, int l2, StringBuilder finalString) {
		if (finalString.length() == (s1.length() + s2.length())) {
			System.out.println(finalString);
		}

		if (l1 < s1.length()) {
			finalString.append(s1.charAt(l1));
			generateInterleavingStrings(s1, s2, l1 + 1, l2, finalString);
			finalString.setLength(finalString.length() - 1);
		}
		if (l2 < s2.length()) {
			finalString.append(s2.charAt(l2));
			generateInterleavingStrings(s1, s2, l1, l2 + 1, finalString);
			finalString.setLength(finalString.length() - 1);

		}
	}

	/*
	 * https://www.geeksforgeeks.org/extract-maximum-numeric-value-given-string/
	 */
	public static Integer findTheHighestNumber() {
		String input = "100--564---365--";
		input = input.replaceAll("-+", "-"); //Check how we can split a number here easily
		String[] inputs = input.split("-");  
		//TODO the methos is incomplete. Needs to be completed.
		return null;
	}

	/******************************************************************************************/

	// https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0
	public static String removeAdjacentDuplicates(String input) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			int count = 0;
			i += 1;
			while (i < input.length() && (ch == input.charAt(i))) {
				++i;
				++count;
			}
			i -= 1;
			if (count == 0) {
				output.append(ch);
			}
		}
		return output.toString();
	}

	public static void main(String args[]) {
		System.out.println(removeAdjacentDuplicates("geeksforgeek"));
		System.out.println(removeAdjacentDuplicates("acaaabbbacdddd"));
		String x = "0";
		String y = "1";

	}
}
