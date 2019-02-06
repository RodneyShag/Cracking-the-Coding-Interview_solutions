package _16_20_T9__HashMap_Solution;

import java.util.HashMap;
import java.util.List;

public class Tester {
    private static String[] words = {"tree", "used", "ace", "bee", "bed", "tape", 
                                     "mouse", "pan", "ran", "ninja", "ninjas"};

    public static void main(String[] args) {
        System.out.println("*** Test 16.20: T9 - HashMap Solution\n");
        HashMap<String, List<String>> map = T9.buildMap(words);
        System.out.println("Matching words: ");
        for (String word : map.get("8733")) {
            System.out.println(word);
        }
    }
}
