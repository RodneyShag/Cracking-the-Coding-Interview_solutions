package chapter01;

public class OnePoint3 {
	
	/* Algorithm:
	 * Count the different characters using an array (as shown below) or a HashMap.
	 * For each string, count the number of each character and save it in an array. Compare these 2 arrays, however...
	 * instead of using 2 arrays, we can do it with 1, as shown below.
	 */
	public static boolean isPermutation_1(String s1, String s2){
		if (s1.length() != s2.length()) {
			return false;
		}
		int [] letters = new int[256]; // we assume it's an ASCII string. Should ask interviewer if String is ASCII or Unicode
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			letters[ch]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			if (--letters[ch] < 0) {
				return false;
			}
		}
		return true;
	}
}
