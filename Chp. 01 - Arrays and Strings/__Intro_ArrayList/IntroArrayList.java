// github.com/RodneyShag

package __Intro_ArrayList;

import java.util.ArrayList;

public class IntroArrayList {
    /* Merges 2 arrays into an ArrayList */
    public static ArrayList<String> merge(String[] words, String[] moreWords) {
        ArrayList<String> result = new ArrayList();
        for (String word : words) {
            result.add(word);
        }
        for (String word : moreWords) {
            result.add(word);
        }
        return result;
    }
}
