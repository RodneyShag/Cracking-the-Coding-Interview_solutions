package _4_03_List_of_Depths;

import java.util.ArrayList;
import java.util.LinkedList;
import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 4.3: List of Depths");
        TreeNode tree = TreeFunctions.createBST();
        ArrayList<LinkedList<TreeNode>> lists = ListOfDepths.createLists(tree);
        for (int i = 0; i < lists.size(); i++) {
            LinkedList<TreeNode> list = lists.get(i);
            System.out.format("\nLevel %d: ", i);
            for (TreeNode node : list) {
                System.out.print(node);
            }
        }
    }
}
