package com.java.tech.dp.noadj;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NoAdjacentCharacter {

	// https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/

	public static Comparator<CharacterCount> customComparator = new Comparator<CharacterCount>() {

		@Override
		public int compare(CharacterCount o1, CharacterCount o2) {
			// TODO Auto-generated method stub
			if (o1.getCount() == o2.getCount()) {
				return 0;
			} else if (o1.getCount() > o2.getCount()) {
				return -1;
			}
			return 1;
		}

	};

	static HashMap<Character, CharacterCount> prepareMap(String input) {
		HashMap<Character, CharacterCount> map = new HashMap<Character, CharacterCount>();
		for (Character ch : input.toCharArray()) {
			if (map.containsKey(ch)) {
				CharacterCount obj = map.get(ch);
				obj.setCount(obj.getCount() + 1);
			} else {
				CharacterCount obj = new CharacterCount(ch, 1);
				map.put(ch, obj);
			}
		}
		return map;
	}

	static void prepareQueue(HashMap<Character, CharacterCount> map, PriorityQueue<CharacterCount> queue) {
		for (CharacterCount characterCount : map.values()) {
			queue.add(characterCount);

		}
	}

	public static String devolopNoAdjacentCharacter(String input) {
		PriorityQueue<CharacterCount> queue = new PriorityQueue<CharacterCount>(customComparator); // Important syntax
		HashMap<Character, CharacterCount> map = prepareMap(input);
		prepareQueue(map, queue);

		StringBuilder output = new StringBuilder();
		CharacterCount obj = queue.peek();
		output.append(obj.getCh());
		obj.setCount(obj.getCount() - 1);
		if (obj.getCount() == 0) {
			queue.remove(obj);
		}
		
		while (!queue.isEmpty()) {
			System.out.println(output);

			obj = queue.poll();
			if (obj.getCh() == output.charAt(output.length() - 1)) {
				System.out.println(queue+" "+output);
				
				CharacterCount anotherObj = queue.poll();
				if (anotherObj == null) {
					return null;
				}

				output.append(anotherObj.getCh());
				anotherObj.setCount(anotherObj.getCount() - 1);
				queue.add(anotherObj);
				if (anotherObj.getCount() == 0) {
					queue.remove(anotherObj);
				}
				queue.add(obj);
				continue;
			}
			output.append(obj.getCh());
			obj.setCount(obj.getCount() - 1);
			if (obj.getCount() == 0) {
				queue.remove(obj);
			}
		}
		
		return output.toString();
	}


	public static void main(String[] args) {
		System.out.println(devolopNoAdjacentCharacter("aaabc"));
	}
}
