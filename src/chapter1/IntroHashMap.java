package chapter1;

import java.util.HashMap;

/* HashMap practice */
public class IntroHashMap {
	public static void main (String [] args){
		String [] strings = {"Bob", "Jane", "Alex"};
		HashMap<Integer, String> map = buildMap(strings);
		for (Integer key : map.keySet()){
			System.out.println("key = " + key + "   value = " + map.get(key));
		}
	}
	
	/* Builds HashMap from Array */
	public static HashMap<Integer, String> buildMap(String [] strings){
		int i = 0;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (String s : strings){
			map.put(i++, s);
		}
		return map;
	}
}