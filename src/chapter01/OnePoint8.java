package chapter01;

public class OnePoint8 {
	public static boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		String doubledString = s1 + s1;
		return doubledString.contains(s2);
	}
}
