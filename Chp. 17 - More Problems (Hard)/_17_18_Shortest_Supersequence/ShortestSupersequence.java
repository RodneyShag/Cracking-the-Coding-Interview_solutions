package _17_18_Shortest_Supersequence;

import java.util.*;

// Algorithm (mostly from book):
// 1) For each integer in smaller array, create a list of its positions in larger list (using HashMap)
//    Our implementation takes O(S + B) time (S is length of smaller array, B is length of longer array)
// 2) We put the head of each list into a minHeap. The [min, max] range in the minHeap is always 
//    a solution range (although it may be too large).
// 3) We keep removing the min element in minHeap and replace it with the first element from the list 
//    it came from. We stop when any of the lists is empty. This step takes O(B log S) time.
//
// Tricky implementation: Update "min" when removing from minHeap. Update "max" when placing into minHeap
//
// Time Complexity: O(S + B log S)

public class ShortestSupersequence {
    public static void shortest(int[] arrayA, int[] arrayB) {
        Map<Integer, Deque<HeapNode>> map = makeLists(arrayA, arrayB);
        Range range = getSmallestRange(map);
        System.out.println("Range: " + range);
    }

    private static Map<Integer, Deque<HeapNode>> makeLists(int[] arrayA, int[] arrayB) {
        Map<Integer, Deque<HeapNode>> map = new HashMap<>();
        for (int num : arrayA) {
            map.put(num, new ArrayDeque<>());
        }
        for (int i = 0; i < arrayB.length; i++) {
            if (map.containsKey(arrayB[i])) {
                Deque<HeapNode> deque = map.get(arrayB[i]);
                HeapNode node = new HeapNode(arrayB[i], i);
                deque.addLast(node);
            }
        }
        return map;
    }

    private static Range getSmallestRange(Map<Integer, Deque<HeapNode>> map) {
        Queue<HeapNode> minHeap = new PriorityQueue<>(new NodeComparator());

        Range currRange = new Range(Integer.MAX_VALUE, Integer.MIN_VALUE);

        // Add 1st element in each list to our minHeap
        for (Deque<HeapNode> deque : map.values()) {
            HeapNode node = deque.removeFirst();
            currRange.max = Math.max(currRange.max, node.index);
            minHeap.add(node);
        }
        currRange.min = minHeap.peek().index;
        Range bestRange = new Range(currRange);

        // Keep replacing elements in minHeap until 1 of the lists is empty
        while (true) {
            // Replace element
            HeapNode node = minHeap.remove();
            Deque<HeapNode> deque = map.get(node.value);
            if (deque.isEmpty()) {
                break;
            }
            HeapNode nodeToAdd = deque.removeFirst();
            minHeap.add(nodeToAdd);

            // Update ranges
            currRange.min = minHeap.peek().index;
            currRange.max = Math.max(currRange.max, nodeToAdd.index);
            if (currRange.isShorterThan(bestRange)) {
                bestRange.setRange(currRange);
            }
        }
        return bestRange;
    }
}
