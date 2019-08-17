package _4_09_BST_Sequences;

import java.util.*;
import common.TreeNode;

public class BSTSequences {
    public static List<Deque<Integer>> allSequences(TreeNode node) {
        List<Deque<Integer>> results = new ArrayList<>();

        if (node == null) {
            results.add(new ArrayDeque<Integer>()); // crucial. So the code labeled "weave lists" works properly
            return results;
        }

        Deque<Integer> prefix = new ArrayDeque<>();
        prefix.add(node.data);

        // Recursive Cases
        List<Deque<Integer>> leftSeq  = allSequences(node.left);
        List<Deque<Integer>> rightSeq = allSequences(node.right);

        // Weave lists
        for (Deque<Integer> left : leftSeq) {
            for (Deque<Integer> right : rightSeq) {
                weaveLists(left, right, results, prefix);
            }
        }

        return results;
    }

    private static void weaveLists(Deque<Integer> list1, Deque<Integer> list2,
            List<Deque<Integer>> results, Deque<Integer> prefix) {
        // Base Case
        if (list1.isEmpty() || list2.isEmpty()) {
        Deque<Integer> result = new ArrayDeque<>(prefix);
        result.addAll(list1);
        result.addAll(list2);
        results.add(result);
        return;
        }
        
        // Use 1st entry in list1
        Integer temp = list1.removeFirst();
        prefix.addLast(temp);
        weaveLists(list1, list2, results, prefix);
        prefix.removeLast();
        list1.addFirst(temp);
        
        // Use 1st entry in list2
        temp = list2.removeFirst();
        prefix.addLast(temp);
        weaveLists(list1, list2, results, prefix);
        prefix.removeLast();
        list2.addFirst(temp);
       }
}
