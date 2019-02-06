package __Intro_PreOrder_Traversal;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test Pre-Order Traversal\n");
        TreeNode tree = TreeFunctions.createBST();
        TreeFunctions.printPreOrder(tree);
    }
}
