package chapter11;
import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {
	public String sortChars(String s){		//Strings are immutable, which is why we convert to char array first
		char [] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public int compare(String a, String b){
		return sortChars(a).compareTo(sortChars(b));	//uses String.compareTo
	}
}
