package _8_08_Permutations_with_Dups;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationsWithDups {
	public static ArrayList<String> getPermutations(String str) {
		HashMap<Character, Integer> map = buildFrequencyTable(str);
		ArrayList<String> result = new ArrayList<>();
		getPermutations(new StringBuffer(), str.length(), map, result);
		return result;
	}
	
	private static HashMap<Character, Integer> buildFrequencyTable(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			map.merge(ch, 1, Integer::sum);
		}
		return map;
	}
	
	private static void getPermutations(StringBuffer prefix, int remaining, HashMap<Character, Integer> map, ArrayList<String> result) {
		if (remaining == 0) {
			result.add(prefix.toString());
			return;
		}
		
		for (Character ch : map.keySet()) {
			int count = map.get(ch);
			if (count > 0) {
				map.put(ch, count - 1);
				prefix.append(ch);
				getPermutations(prefix, remaining - 1, map, result);
				prefix.deleteCharAt(prefix.length() - 1);
				map.put(ch, count);
			}
		}
	}
}
