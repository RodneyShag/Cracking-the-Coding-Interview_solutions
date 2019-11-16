// github.com/RodneyShag

package _4_12_Paths_with_Sum;

import common.TreeNode;
import java.util.*;


public class PathWithSums {
    public static int findSum(TreeNode node, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findSum(node, targetSum, 0, map);
    }

    private static int findSum(TreeNode node, int targetSum, int runningSum, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        runningSum += node.data;
        int totalPaths = map.getOrDefault(runningSum - targetSum, 0);

        map.merge(runningSum, 1, Integer::sum);
        totalPaths += findSum(node.left, targetSum, runningSum, map);
        totalPaths += findSum(node.right, targetSum, runningSum, map);
        map.merge(runningSum, -1, Integer::sum);
        if (map.get(runningSum) == 0) { // Remove when 0 to reduce space usage
            map.remove(runningSum);
        }

        return totalPaths;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(log n) on balanced tree. O(n) otherwise.
