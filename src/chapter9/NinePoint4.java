package chapter9;
import java.util.ArrayList;

/* I like the iterative solution better. Can completely ignore recursive solution if I want. The code for both solutions are from book. */
public class NinePoint4 {
	
	/**********************/
	/* Iterative Solution */
	/**********************/
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < Math.pow(2, set.size()); i++){
			ArrayList<Integer> subset = convertIntToArrayList(i, set);
			allSubsets.add(subset);
		}
		return allSubsets;
	}
	
	/* Tricky Bit Stuff: Treats decimal integer as bits, using proper shifting. */
	private static ArrayList<Integer> convertIntToArrayList(int x, ArrayList<Integer> set){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;	//knowing to create this "index" to increase, while "i" decreases may be tricky.
		for (int i = x; i > 0; i >>= 1){
			if ((i & 1) == 1)
				subset.add(set.get(index));
			index++;
		}
		return subset;
	}
	
	/**********************/
	/* Recursive Solution */     //don't memorize the code.
	/**********************/	 //using the "index" variable properly (especially to handle the base case) is the tricky part
	public static ArrayList<ArrayList<Integer>> getSubsetsRecursive(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		if (index == set.size()){
			ArrayList<Integer> emptySet = new ArrayList<Integer>();
			allSubsets.add(emptySet);
		}
		else{
			allSubsets = getSubsetsRecursive(set, index + 1);
			
			//we made this moreSubsets variable cuz can't loop through allSubsets while adding elements to it
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			Integer item = set.get(index);
			for (ArrayList<Integer> subset : allSubsets){
				ArrayList<Integer> subsetToAdd = new ArrayList<Integer>();
				subsetToAdd.addAll(subset);
				subsetToAdd.add(item);
				moreSubsets.add(subsetToAdd);
			}
			allSubsets.addAll(moreSubsets);
		}
		return allSubsets;
	}
}
