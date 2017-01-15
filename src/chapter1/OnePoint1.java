package chapter1;
import java.util.HashSet;
import java.util.Arrays;

/* 5 Solutions
 * 1) Use HashMap                 O(n) runtime          (Best Solution)
 * 2) Use Array of 256 characters O(n) runtime
 * 3) Use BitVector               O(n) runtime          (Not Necessary)
 * 4) Using Sorting               O(n log n) runtime
 * 5) Naive Brute Force           O(n^2) runtime
 */
public class OnePoint1 {
	public static void main (String [] args){
		System.out.println("Bob  " + uniqueCharacters_1("Bobby"));
		System.out.println("Ben  " + uniqueCharacters_1("Ben"));
		System.out.println("Alex " + uniqueCharacters_1("Alex"));
		System.out.println();	
		System.out.println("Bob  " + uniqueCharacters_2("Bobby"));
		System.out.println("Ben  " + uniqueCharacters_2("Ben"));
		System.out.println("Alex " + uniqueCharacters_2("Alex"));
		System.out.println();	
		System.out.println("Bob  " + uniqueCharacters_3("Bobby"));
		System.out.println("Ben  " + uniqueCharacters_3("Ben"));
		System.out.println("Alex " + uniqueCharacters_3("Alex"));
		System.out.println();
		System.out.println("Bob  " + uniqueCharacters_4("Bobby"));
		System.out.println("Ben  " + uniqueCharacters_4("Ben"));
		System.out.println("Alex " + uniqueCharacters_4("Alex"));
		System.out.println();
		System.out.println("Bob  " + uniqueCharacters_5("Bobby"));
		System.out.println("Ben  " + uniqueCharacters_5("Ben"));
		System.out.println("Alex " + uniqueCharacters_5("Alex"));
	}
	
	/* O(n) runtime, O(n) space: using HashMap (my favorite solution) */
	public static boolean uniqueCharacters_1(String string){
		HashSet<Character> mySet = new HashSet<>();
		for (Character ch : string.toCharArray()){
			if (mySet.contains(ch))
				return false;
			else
				mySet.add(ch);
		}
		return true;
	}

	/* O(n) runtime, O(1) space: using Array */
	public static boolean uniqueCharacters_2(String string){
		if (string.length() > 256)
			return false;
		
		boolean [] array = new boolean[256];
		
		for (Character c : string.toCharArray()){
			int charAsInt = (int) c;
			if (array[charAsInt] == true) // already came across this character in string
				return false;
			else
				array[charAsInt] = true;
		}
		return true;
	}

	/* O(n) time, O(1) space. Way too fancy bitvector trick. */
	public static boolean uniqueCharacters_3(String string){
		/* We assume our string is just 26 lower-case characters */
		string = string.toLowerCase();
		int bitVector = 0; // "int" is 32 bits. This is enough for 26 (lower-case) characters
		for (Character s : string.toCharArray()){
			int num = s - 'a';
			if ((bitVector & (1 << num)) != 0)
				return false;
			else
				bitVector |= (1 << num);
		}
		return true;
	}
	
	/* O(n log n) runtime. Space complexity depends on sorting method */
	public static boolean uniqueCharacters_4(String string){
		char [] stringCharArray = string.toCharArray();
		Arrays.sort(stringCharArray);
		for (int i = 0; i < stringCharArray.length - 1; i++){
			if (stringCharArray[i] == stringCharArray[i+1])
				return false;
		}
		return true;
	}
	
	/* O(n^2) runtime, O(1) space: by comparing each character to every other character (Naive solution) */
	public static boolean uniqueCharacters_5(String string){
		for (int i = 0; i < string.length() - 1; i++){
			for (int j = i + 1; j < string.length(); j++){
				if (string.charAt(i) == string.charAt(j))
					return false;
			}
		}
		return true;
	}
}

