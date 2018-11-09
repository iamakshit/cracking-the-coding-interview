package com.java.tech.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
}
