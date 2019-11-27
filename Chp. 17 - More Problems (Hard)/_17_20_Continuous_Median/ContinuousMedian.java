// github.com/RodneyShag

package _17_20_Continuous_Median;

import java.util.Collections;
import java.util.PriorityQueue;

//- We use 2 Heaps to keep track of median
//  - maxHeap contains all SMALL elements
//  - minHeap contains all LARGE elements
//- We make sure that 1 of the following conditions is always true:
//   1) maxHeap.size() == minHeap.size()
//   2) maxHeap.size() - 1 = minHeap.size()

public class ContinuousMedian {
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue();

    public static void addNum(int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            minHeap.add(n);
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size()) {
            maxHeap.add(n);
            minHeap.add(maxHeap.remove());
        }
        // maxHeap will never be smaller size than minHeap
    }

    public static double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
