package _16_20_T9__HashMap_Solution;

import java.util.*;

// Algorithm: Pre-process all words into a HashMap<String, List<String>> where 
//      key   = Number (well, only numbers that give valid words will be included)
//      value = List of Valid Words

public class T9 {
    private static Map<Character, Character> letterToDigit = new HashMap<>();

    static { // static initializer block
        for (char ch = 'a'; ch <= 'c'; ch++) letterToDigit.put(ch, '2');
        for (char ch = 'd'; ch <= 'f'; ch++) letterToDigit.put(ch, '3');
        for (char ch = 'g'; ch <= 'i'; ch++) letterToDigit.put(ch, '4');
        for (char ch = 'j'; ch <= 'l'; ch++) letterToDigit.put(ch, '5');
        for (char ch = 'm'; ch <= 'o'; ch++) letterToDigit.put(ch, '6');
        for (char ch = 'p'; ch <= 's'; ch++) letterToDigit.put(ch, '7');
        for (char ch = 't'; ch <= 'v'; ch++) letterToDigit.put(ch, '8');
        for (char ch = 'w'; ch <= 'z'; ch++) letterToDigit.put(ch, '9');
    }

    public static Map<String, List<String>> buildMap(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String number = getNumber(word);
            map.putIfAbsent(number, new ArrayList<>());
            List<String> listOfWords = map.get(number);
            listOfWords.add(word);
        }
        return map;
    }

    private static String getNumber(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = letterToDigit.get(str.charAt(i));
            sb.append(ch);
        }
        return sb.toString();
    }
}

// Time Complexity: O(1) lookup (after preprocessing)
