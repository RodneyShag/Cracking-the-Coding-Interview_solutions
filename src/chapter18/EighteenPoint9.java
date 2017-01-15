package chapter18;
import java.util.Collections;
import java.util.PriorityQueue;

 /* Code is easy to write if I understand algorithm.
 * Tricks:
 * - Uses 2 Heaps to track median (maxHeap keeps track of mins. minHeap keeps track of maxes)
 * - Uses Collections.reverseOrder() instead of creating a Comparator<Integer>
 * - Notice we split up the code depending on the size/number of elements in each heap. We want to maintain:
 * 			maxheap.size() == minheap.size() or
 *			maxheap.size()-1 == minheap.size() always holds.
 */

public class EighteenPoint9 {	//code from website
	  static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(50, Collections.reverseOrder());	//maxheap contains all SMALL elements
	  static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(50);								//minheap contains all LARGE elements
	  
	  static void addNum(int n) {
	        if (maxHeap.isEmpty())
	            maxHeap.add(n);
	        if (maxHeap.size() == minHeap.size()) {
	            if (n < minHeap.peek())
	                maxHeap.add(n);
	            else {
	                maxHeap.add(minHeap.remove());
	                minHeap.add(n);
	            }
	        }
	        else {	// maxheap.size()-1 == minheap.size()
	            if (n > maxHeap.peek())
	                minHeap.add(n);
	            else {
	                minHeap.add(maxHeap.remove());
	                maxHeap.add(n);
	            }
	        }
	    }
	    
	    static int getMedian() {
	        if (maxHeap.isEmpty()) 
	        	return 0;
	        else if (maxHeap.size() == minHeap.size())
	            return (maxHeap.peek() + minHeap.peek()) / 2;
	        else
	            return maxHeap.peek();
	    }
}

