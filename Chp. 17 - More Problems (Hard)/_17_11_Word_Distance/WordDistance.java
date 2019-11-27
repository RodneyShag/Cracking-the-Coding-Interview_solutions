// github.com/RodneyShag

package _17_11_Word_Distance;

import java.util.*;

// Find shortest distance between 2 words in a file
// 
// Solutions                    Preference
// ---------------------------------------------
// 1) Linear Search             Worth Mentioning
// 2) Preprocess with HashMap   Favorite

public class WordDistance {
    // Solution 1 - Linear search, keeping track of the last position of the words
    public static Integer shortest(String[] words, String word1, String word2) {
        if (words == null || word1 == null || word2 == null) {
            return null;
        }
        int min = Integer.MAX_VALUE;
        int lastPosWord1 = -1;
        int lastPosWord2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                lastPosWord1 = i;
            } else if (words[i].equals(word2)) {
                lastPosWord2 = i;
            }

            if (lastPosWord1 != -1 && lastPosWord2 != -1) {
                int currDistance = Math.abs(lastPosWord1 - lastPosWord2);
                min = Math.min(min, currDistance);
            }
        }
        return min;
    }

    // Solution 2
    // 
    // - Preprocess into HashMap<String, ArrayList<Integer>>, where the ArrayList is all the positions the word shows up in.
    // - Merge 2 sorted ArrayLists together (using algo from mergeSort) and "flag" which list each entry is from (using "Pair" class).
    // - Use Solution 1's method to then find minimum distance on our preprocessed data.

    private static Map<String, List<Integer>> map = new HashMap();

    public static void preProcess(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            map.putIfAbsent(currWord, new ArrayList<Integer>());
            List<Integer> positions = map.get(currWord);
            positions.add(i);
        }
    }

    public static Integer shortest2(String word1, String word2) {
        return findDistance(map.get(word1), map.get(word2));
    }

    // Merges lists, then uses same algo from Solution 1 to find minimum distance
    private static Integer findDistance(List<Integer> listA, List<Integer> listB) {
        if (listA == null || listB == null || listA.size() == 0 || listB.size() == 0) {
            return null;
        }

        List<Pair> merged = merge(listA, listB);

        int min = Integer.MAX_VALUE;
        int lastPosWord1 = -1;
        int lastPosWord2 = -1;

        for (int i = 0; i < merged.size(); i++) {
            Pair pair = merged.get(i);
            if (pair.fromListA) {
                lastPosWord1 = pair.num;
            } else {
                lastPosWord2 = pair.num;
            }

            if (lastPosWord1 != -1 && lastPosWord2 != -1) {
                int currDistance = Math.abs(lastPosWord1 - lastPosWord2);
                min = Math.min(min, currDistance);
            }
        }
        return min;
    }

    private static List<Pair> merge(List<Integer> listA, List<Integer> listB) {
        if (listA == null || listB == null || listA.size() == 0 || listB.size() == 0) {
            return new ArrayList();
        }

        List<Pair> merged = new ArrayList();
        int aIndex = 0;
        int bIndex = 0;
        int aValue;
        int bValue;
        while (aIndex < listA.size() && bIndex < listB.size()) {
            aValue = listA.get(aIndex);
            bValue = listB.get(bIndex);
            if (aValue < bValue) {
                merged.add(new Pair(aValue, true));
                aIndex++;
            } else {
                merged.add(new Pair(bValue, false));
                bIndex++;
            }
        }

        /* Only one of these will execute */

        while (aIndex < listA.size()) {
            aValue = listA.get(aIndex);
            merged.add(new Pair(aValue, true));
            aIndex++;
        }

        while (bIndex < listB.size()) {
            bValue = listB.get(bIndex);
            merged.add(new Pair(bValue, false));
            bIndex++;
        }
        return merged;
    }
}
