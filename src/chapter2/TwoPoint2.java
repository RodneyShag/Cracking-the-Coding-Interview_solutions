package chapter2;
/* This question is tougher than it seems, cuz of RECURSION, and WRAPPER class. Textbook also had 2 other solutions it briefly mentioned */

public class TwoPoint2 {
	/**************************************************************************************************/
	/* Solution 1 - If list length is known: find and return "length - k" element by walking linearly */
	/**************************************************************************************************/
	public static Node kthToLast_1(Node n, int k){
		/* Error Checking */
		if (n == null)
			return null;
		
		int size = ListFunctions.calculateSize(n);
		
		/* Error Checking */
		if (k <= 0 || k > size)
			return null;

		for (int i = 0; i < size - k; i++){
			n = n.next;
		}

		return n;
	}
	/**** For solutions 2A, 2C, we do it recursively, but need to pass back TWO things (index and Node), so it's tough ****/
	/***************/
	/* Solution 2A - If list size unknown, and cheating with CRAPPY solution by 
	 * 1) returning an int instead of a Node, 2) Just printing result in function */
	/***************/
	
	public static int kthToLast_2A(Node n, int k){ // we could error-check for "k" in a wrapper function
		
		/* Base Case */
		if (n == null)
			return 0;
		
		/* Recursive Case */
		else{
			int value = 1 + kthToLast_2A(n.next, k);
			if (value == k)
				System.out.println("Element " + k + " from end = "+ n.data);
			return value;
		}
	}

	/* Solution 2B - Skip: It's C++ */

	/***************/
	/* Solution 2C */ // Employs advanced "IntWrapper" technique (so we can return the actual "Node" and IntWrapper). Uses Recursion.
	/***************/
	
	public static Node kthToLast_2C(Node n, int k, IntWrapper i){ // we could error-check for "k" in a wrapper function
		/* Base Case */
		if (n == null)
			return null;
		/* Recursive Case */
		else{
			Node node = kthToLast_2C(n.next, k, i);
			i.value++;
			if (k == i.value)
				return n;
			else
				return node;	//keeps returning null, until hopefully we find a match, then it keeps returning the Node that matched
		}
	}
	
	//Solution 2D: instead of using Intwrapper, can create and return a data structure that includes a Node and an int.

	/********************************************************************/
	/* Solution 3 - If list length unknown: #CleverTrick - Using Runner */ //Ignore this stupid solution since solution 1 is better.
	/********************************************************************/
	public static Node kthToLast_3(Node n, int k){
		if (n == null || k <= 0)	//will assume k is not larger than the size of the list
			return null;	
		
		Node curr = n;
		Node runner = n;
		for (int i = 0; i < k; i ++){
			runner = runner.next;
		}
		while(runner != null){
			curr = curr.next;
			runner = runner.next;
		}
		return curr;
	}
}
