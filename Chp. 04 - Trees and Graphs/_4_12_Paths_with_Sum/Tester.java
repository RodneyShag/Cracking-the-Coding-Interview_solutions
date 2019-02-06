package _4_12_Paths_with_Sum;

import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.print("*** Test 4.12: Paths with Sum\n");
        TreeNode tree = TreeFunctions.createBST();
        PathWithSums.findSum(tree, 6);
    }
}
