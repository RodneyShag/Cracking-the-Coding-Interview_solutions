// github.com/RodneyShag

package _4_03_List_of_Depths;

import java.util.*;
import common.TreeNode;
import common.TreeFunctions;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 4.3: List of Depths");
        TreeNode tree = TreeFunctions.createBST();
        List<List<Integer>> lists = ListOfDepths.levelOrder(tree);
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            System.out.format("\nLevel %d: ", i);
            for (Integer num : list) {
                System.out.print(num);
            }
        }
    }
}
