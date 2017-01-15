package chapter18;
import java.util.Comparator;

public class StringComparator implements Comparator<String>{
	/* Purposely sorting from longest to shortest */
	public int compare(String a, String b){
		return b.length() - a.length();		//so that longer words will be in front.
	}
	
	
}
