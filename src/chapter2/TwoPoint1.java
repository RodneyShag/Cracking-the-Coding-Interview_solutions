package chapter2;

import java.util.HashSet;

/* Removes duplicates from unsorted list
 * 
 * Solutions         Runtime       Preference
 * -----------------------------------------------------
 * 1) Use HashMap    O(n)          Favorite
 * 2) Brute-Force    O(n^2)        Naive (but O(1) space)
 */
public class TwoPoint1 {
	/* Solution Version 1 - Ideal HashMap Solution.*/
	/* Walk the list linearly with TWO pointers (even though I probably could have done it with 1). Use HashMap as storage*/
	/* O(n) time, O(n) space */
	static void removeDuplicates(Node head){
		HashSet<Integer> map = new HashSet<>();
		Node curr = head;
		Node prev = null;
		
		while(curr != null){
			if(map.contains(curr.data))
				prev.next = curr.next;
			else{
				map.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
		}
		return;
	}
	
	/* Solution Version 2 - if O(1) space constraint */
	/* Use 1 pointer to walk list, and another pointer to check all remaining nodes each time */
	/* O(n^2) time, O(1) space */
	static void removeDuplicates2(Node head){
		Node curr = head;
		Node runner = null;	//we could have used 2 runners (curr and prev) instead of doing "runner.next" and "runner.next.next".
							
		while(curr != null){
			runner = curr;
			while(runner.next != null){
				if (curr.data == runner.next.data)
					runner.next = runner.next.next;
				else									//this "else" is important. prevents null pointer exception, and logically makes sense.
					runner = runner.next;
			}
			curr = curr.next;
		}
		return;
	}
}
