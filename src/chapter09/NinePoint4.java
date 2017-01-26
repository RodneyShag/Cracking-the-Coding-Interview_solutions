package chapter09;

import java.util.ArrayList;

public class NinePoint4 {
	
	/* Iterative solution */
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < Math.pow(2, set.size()); i++){    // this is the main trick
			ArrayList<Integer> subset = createSubset(set, i);
			allSubsets.add(subset);
		}
		return allSubsets;
	}
	
	private static ArrayList<Integer> createSubset(ArrayList<Integer> set, int num){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int indexInSet = 0;
		while (num != 0){
			if ((num & 1) == 1)
				subset.add(set.get(indexInSet));
			indexInSet++;
			num = num >> 1;
		}
		return subset;
	}
}
