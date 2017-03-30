package chapter09;

import java.util.ArrayList;

public class NinePoint04 {	
	// Time Complexity: O(2^n). Impossible to do better
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		int max = (int) Math.pow(2, set.size());
		for (int i = 0; i < max; i++) { // this is the main trick
			ArrayList<Integer> subset = createSubset(set, i);
			allSubsets.add(subset);
		}
		return allSubsets;
	}
	
	private static ArrayList<Integer> createSubset(ArrayList<Integer> set, int num) {
		ArrayList<Integer> subset = new ArrayList<>();
		int indexInSet = 0;
		while (num != 0) {
			if ((num & 1) == 1) {
				subset.add(set.get(indexInSet));
			}
			indexInSet++;
			num = num >> 1;
		}
		return subset;
	}
}
