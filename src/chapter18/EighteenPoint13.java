package chapter18;
/* Notes:
 * - Actual code in book is super long with many details of implementation (like Tries) missing
 * - Memorizing algorithm is useful
 */
/* Tricks:
 * - Attempt to build the biggest rectangle first (which is maxSize = maxWordLength ^ 2), and do "for (int z = maxSize; z > 0; z--)" and try to
 *   form smaller rectangles so that the 1st rectangle we build is biggest one possible.
 *   
 * - Have "Rectangle" class with isComplete(), isPartialOK(), and append(String s)
 * 
 * - Have "WordGroup" class to group words into an array by their length. So element 2 in array could be words of length 2, which is represented 
 *   as an ArrayList. The book also represented them in a HashMap (or HashSet) for quick lookup. 
 *   (Rodney: Maybe I can do a HashSet<Integer, ArrayList<String>> to hash from word length to the words)
 *   
 * - Use a "trie". After each row we add to the Rectangle, we can search the trie to see if the column has a prefix that's valid (i.e. in the trie)
 * 
 *   
 */
public class EighteenPoint13 {

}
