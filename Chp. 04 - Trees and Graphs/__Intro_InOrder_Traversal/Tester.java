package __Intro_InOrder_Traversal;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test In-Order Traversal\n");
        TreeNode tree = TreeFunctions.createBST();
        TreeFunctions.printInOrder(tree);
    }
}
