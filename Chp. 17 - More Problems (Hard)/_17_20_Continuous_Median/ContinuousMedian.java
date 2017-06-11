package _17_20_Continuous_Median;

import java.util.Collections;
import java.util.PriorityQueue;

//- We use 2 Heaps to keep track of median
//- We make sure that 1 of the following conditions is always true:
//   1) maxHeap.size() == minHeap.size()
//   2) maxHeap.size() - 1 = minHeap.size()

public class ContinuousMedian {
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap contains all SMALL elements
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();						     // minHeap contains all LARGE elements
	  
	public static void addNum(int n) {
		if (maxHeap.isEmpty()) {
            maxHeap.add(n);
		} else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
	        if (n > maxHeap.peek()) {
	        	minHeap.add(n);
	        } else {
	            maxHeap.add(n);
	        	minHeap.add(maxHeap.remove());
	        }
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
