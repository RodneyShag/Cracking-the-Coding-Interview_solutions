package __Intro_LevelOrder_Traversal;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test Level-Order Traversal\n");
        TreeNode tree = TreeFunctions.createBST();
        TreeFunctions.printLevelOrder(tree);
    }
}
