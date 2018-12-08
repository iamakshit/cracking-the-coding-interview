import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static HashMap<Integer, Integer> map = new HashMap<>();

	public static Comparator<Integer> customComparator = new Comparator<Integer>() {

		public int compare(Integer a, Integer b) {

			int aCount = map.get(a);
			int bCount = map.get(b);

			if (aCount < bCount) {
				return 1;
			} else if (aCount == bCount) {
				return 0;
			} else {
				return -1;
			}
		}

	};

	public static void customDisplay(String[] strList) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (String str : strList) {
			Integer i = Integer.parseInt(str);
			list.add(i);
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		Collections.sort(list, GFG.customComparator);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		Scanner ak = new Scanner(System.in);
		String countStr = ak.nextLine();
		Integer count = Integer.parseInt(countStr);
		String x = ak.nextLine();
		String[] strList = ak.nextLine().split(" ");
		while (count > 0) {
			customDisplay(strList);
			count -= 1;
		}
	}
}