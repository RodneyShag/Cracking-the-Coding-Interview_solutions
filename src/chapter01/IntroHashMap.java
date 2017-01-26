package chapter01;

import java.util.HashMap;

public class IntroHashMap {
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
