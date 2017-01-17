package chapter1;

public class OnePoint5 {
	public static void main (String [] args){
		test("aabcccccaaa");
		test("abababa");
	}
	
	/******************************************************************************/
	/* Solution 1 - Using StringBuffer (Since Strings are immutable and too slow) */
	/******************************************************************************/
	public static String basicCompression_1(String string){
		/* Error Check */
		if (string == null || string.isEmpty())
			return string;
		
		/* Only compress if necessary */
		if (compressedLength(string) >= string.length())
			return string;
		
		StringBuffer sb = new StringBuffer(); // can optionally use String, but that's slower since Strings are immutable.
		
		int numSame = 1;
		for (int i = 1; i < string.length(); i++){
			char prev = string.charAt(i-1);
			char curr = string.charAt(i);
			if (prev == curr){
				numSame++;
			}
			else{
				sb.append(prev);
				sb.append(String.valueOf(numSame));
				numSame = 1;
			}
		}
		
		/* Finished going through the string, now we have to write whatever we have */
		sb.append(string.charAt(string.length()-1));
		sb.append(String.valueOf(numSame));
		
		return sb.toString();
	}
	
	/* Helper Function - Basically same algo as above function */
	private static int compressedLength(String str){
		if (str == null || str.isEmpty())
			return 0;
		
		int size = 0;
		int numSame = 1;
		for (int i = 1; i < str.length(); i++){
			char prev = str.charAt(i-1);
			char curr = str.charAt(i);
			if (prev == curr){
				numSame++;
			}
			else{
				size++; // add 1 for letter
				size += String.valueOf(numSame).length(); // valueOf() converts numSame to String so we can see how many digits in it.
				numSame = 1;
			}
		}
		/* Finished going through the string, now we have to write whatever we have */
		size++; // add 1 for letter
		size += String.valueOf(numSame).length();
		
		return size;
	}


	/************************************************************************************************/
	/* Solution 2 - Using char[] (If for some reason they didn't let us use String or StringBuffer) */
	/************************************************************************************************/
	public static String basicCompression_2(String string){
		/* Error Check */
		if (string == null || string.isEmpty())
			return string;
		
		/* Only compress if necessary */
		int size = compressedLength(string);
		if (size >= string.length())
			return string;
		
		char [] array = new char[size];
		int arrayIndex = 0;
		
		int numSame = 1;
		for (int i = 1; i < string.length(); i++){
			char prev = string.charAt(i-1);
			char curr = string.charAt(i);
			if (prev == curr){
				numSame++;
			}
			else{
				arrayIndex = writeToArray(array, arrayIndex, prev, numSame);
				numSame = 1;
			}
		}
		
		/* Finished going through the string, now we have to write whatever we have */
		arrayIndex = writeToArray(array, arrayIndex, string.charAt(string.length()-1), numSame);

		return new String(array);
	}
	
	/* Incorporating this as a function makes our code super clean. Great idea for interview */
	private static int writeToArray(char [] array, int index, char ch, int num){
		array[index++] = ch;
		String numAsString = String.valueOf(num);
		int size = numAsString.length();
		for (int i = 0; i < size; i++){
			array[index++] = numAsString.charAt(i);
		}
		return index;
	}
	
	/* Tests code */
	private static void test(String original){
		System.out.println("Original string = " + original);
		String compressed = basicCompression_1(original);
		System.out.println("Solution 1: " + compressed);	
		String compressed_2 = basicCompression_2(original);
		System.out.println("Solution 2: " + compressed_2);	
		System.out.println();
	}
}
