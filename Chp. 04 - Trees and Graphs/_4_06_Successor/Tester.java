package _4_06_Successor;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 4.6: Successor\n");
        TreeNode tree = TreeFunctions.createBST();
        System.out.println("Should be 6:    " + Successor.inOrderSucc(tree));
        System.out.println("Should be 5:    " + Successor.inOrderSucc(tree.left));
        System.out.println("Should be null: " + Successor.inOrderSucc(tree.right.right));
    }
}
