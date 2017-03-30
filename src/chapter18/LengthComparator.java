package chapter18;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		return b.length() - a.length();		// Purposely sorting backwards to put longer words in front.
	}
}
