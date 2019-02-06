package __Intro_PostOrder_Traversal;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test Post-Order Traversal\n");
        TreeNode tree = TreeFunctions.createBST();
        TreeFunctions.printPostOrder(tree);
    }
}
