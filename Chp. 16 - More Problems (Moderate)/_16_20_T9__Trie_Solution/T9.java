package _16_20_T9__Trie_Solution;

import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

// Algorithm:
//   Create Trie containing all given words
//   For each "number" query, walk down corresponding paths of Trie to find matching words

public class T9 {
    private static HashMap<Character, List<Character>> digitToLetter = new HashMap<>();

    static {
        digitToLetter.put('2', Arrays.asList('a', 'b', 'c'));
        digitToLetter.put('3', Arrays.asList('d', 'e', 'f'));
        digitToLetter.put('4', Arrays.asList('g', 'h', 'i'));
        digitToLetter.put('5', Arrays.asList('j', 'k', 'l'));
        digitToLetter.put('6', Arrays.asList('m', 'n', 'o'));
        digitToLetter.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitToLetter.put('8', Arrays.asList('t', 'u', 'v'));
        digitToLetter.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static void getValidWords(StringBuffer prefix, String number, Trie trie, TrieNode trienode, List<String> results) {
        if (number.isEmpty()) {
            results.add(prefix.toString());
            return;
        }
        Character ch = number.charAt(0);
        List<Character> list = digitToLetter.get(ch);
        for (Character letter : list) {
            if (trienode.getChild(letter) != null) {
                prefix.append(letter);
                getValidWords(prefix, number.substring(1), trie, trienode.getChild(letter), results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
}
