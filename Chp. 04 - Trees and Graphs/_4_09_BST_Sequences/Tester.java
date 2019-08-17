package _4_09_BST_Sequences;

import java.util.*;

import common.TreeNode;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 4.9: BST Sequences\n");
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        List<Deque<Integer>> results = BSTSequences.allSequences(root);
        for (Deque<Integer> result : results) {
            System.out.println(result);
        }
    }
}
