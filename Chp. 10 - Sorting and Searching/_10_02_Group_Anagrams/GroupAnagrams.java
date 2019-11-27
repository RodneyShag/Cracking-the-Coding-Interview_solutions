// github.com/RodneyShag

package _10_02_Group_Anagrams;

import java.util.*;

public class GroupAnagrams {

    // Solution 1
    //
    // HashMap:
    //   key:   the sorted version of the String.
    //   value: all the unsorted Strings that sort to the key.
    public static void groupAnagrams(String[] array) {
        HashMap<String, List<String>> map = new HashMap();

        // Group words by Anagram (by putting into HashMap)
        for (String str : array) {
            String key = sortChars(str);
            map.putIfAbsent(key, new ArrayList<String>());
            List<String> anagrams = map.get(key);
            anagrams.add(str);
        }

        // Copy HashMap entries to array
        int index = 0;
        for (List<String> list : map.values()) {
            for (String str : list) {
                array[index++] = str; // overwrite the old values
            }
        }
    }

    private static String sortChars(String str) {
        char[] content = str.toCharArray(); // Strings are immutable, which is why we convert to char[] first
        Arrays.sort(content);
        return new String(content);
    }
    
    // Solution 2 - Character Counts
    //
    // - In our above solution, we were using sorting (O(n log n)) to see if 2 strings are anagrams. 
    //   Instead, we can compare the letter counts of the Strings to see if they're anagrams (O(n))
    // - The only difference in this solution is how we create the key for our `HashMap`. 
    //   Our key will represent the number of letters in each string, where each letter has a separator in it.
    //     -  Example: `aabccc` becomes `2-1-3-...0-` (where the `...` is for the remaining 22 characters)
    public static void groupAnagrams2(String[] array) {
        HashMap<String, List<String>> map = new HashMap();

        // Group words by Anagram (by putting into HashMap)
        for (String str : array) {
            String key = createKey(str);
            map.putIfAbsent(key, new ArrayList<String>());
            List<String> anagrams = map.get(key);
            anagrams.add(str);
        }

        // Copy HashMap entries to array
        int index = 0;
        for (List<String> list : map.values()) {
            for (String str : list) {
                array[index++] = str; // overwrite the old values
            }
        }
    }

    private static String createKey(String str) {
        int[] array = new int[26]; // 26 is number of letters. Java initializes all values to 0.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            array[ch - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int x : array) {
          sb.append(x);
          sb.append('-');
        }
        return sb.toString();
    }
}
