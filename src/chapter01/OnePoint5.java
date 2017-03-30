package chapter01;

public class OnePoint5 {
	
	public static String basicCompression(String str) {
		/* Error Check */
		if (str == null || str.isEmpty()) {
			return str;
		}
		
		/* Only compress if necessary */
		if (compressedLength(str) >= str.length()) {
			return str;
		}
		
		StringBuffer sb = new StringBuffer(); // use StringBuffer since more efficient than creating/appending Strings
		int numSame = 1;
		
		for (int i = 1; i < str.length(); i++) {
			char prev = str.charAt(i-1);
			char curr = str.charAt(i);
			if (prev == curr){
				numSame++;
			} else {
				sb.append(prev);
				sb.append(String.valueOf(numSame));
				numSame = 1;
			}
		}
		
		/* Finished going through the string, now we have to write whatever we have */
		sb.append(str.charAt(str.length()-1));
		sb.append(String.valueOf(numSame));
		return sb.toString();
	}
	
	/* Helper Function - Basically same algo as above function */
	private static int compressedLength(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}
		
		int size = 0;
		int numSame = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i-1) == str.charAt(i)) {
				numSame++;
			} else {
				size++; // add 1 for letter
				size += String.valueOf(numSame).length(); // converts numSame to String so we can see how many digits in it.
				numSame = 1;
			}
		}
		/* Finished going through the string, now we have to write whatever we have */
		size++;
		size += String.valueOf(numSame).length();
		return size;
	}
}
