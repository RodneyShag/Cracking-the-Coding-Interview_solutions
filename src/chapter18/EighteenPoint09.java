package chapter18;

import java.util.Collections;
import java.util.PriorityQueue;

 /* Tricks:
 * - Uses 2 Heaps to track median
 * - Uses Collections.reverseOrder() instead of creating a Comparator<Integer>
 * - We split up the code depending on the size/number of elements in each heap. We want to maintain:
 * 			maxheap.size() == minheap.size() or
 *			maxheap.size()-1 == minheap.size() always holds.
 */
public class EighteenPoint09 {	//code from website
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());	// maxHeap contains all SMALL elements
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();						    // minHeap contains all LARGE elements
	  
	public static void addNum(int n) {
		if (maxHeap.isEmpty())
            maxHeap.add(n);
		else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek())
                maxHeap.add(n);
            else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        }
	    else {	// maxheap.size()-1 == minheap.size()
	        if (n > maxHeap.peek())
	        	minHeap.add(n);
	        else {
	            maxHeap.add(n);
	        	minHeap.add(maxHeap.remove());
	        }
	    }
	}
	    
	public static double getMedian() {
        if (maxHeap.isEmpty()) 
        	return 0;
        else if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}
