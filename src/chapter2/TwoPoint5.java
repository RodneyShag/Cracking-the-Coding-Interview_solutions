package chapter2;

public class TwoPoint5 {
	/* Wrapper */
	static Node addReverseOrder (Node n, Node m){
		if (n == null)
			return m;
		if (m == null)
			return n;
		return addReverseOrderHelper(n, m, 0);
	}
	
	/* Forward Order
	 * - 1st add these SLL on paper to see how I would do it, then implement it.
	 * - accounts for adding lists of multiple lengths.
	 * - dont forget to actually create New Nodes.
	 */
	private static Node addReverseOrderHelper (Node n, Node m, int carry){
		if (n == null && m == null && carry == 0)
			return null;
		
		int value = carry;	//we calculate "value" step by step making it easy to test null values.
		if (n != null)
			value += n.data;
		if (m != null)
			value += m.data;
		int thisDigit = value % 10;
		int nextCarry = value / 10;
		Node myNode = new Node(thisDigit);
		myNode.next = addReverseOrderHelper(n == null ? null : n.next, m == null ? null : m.next, nextCarry); //makes null testing efficient.
		return myNode;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////// I like my code below better than book's code, even though I took most of my ideas from book ///////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	/* Challenging part is we need to return 2 things (a "Node" and a "Carry"), we have 2 options:
	      1) Make our own "Partial Sum" class (done here)
	      2) Use IntWrapper (like in problem 2.2) (not done here)
	   Difficult to code correctly.
	*/
	static Node addForwardOrder(Node n, Node m){
		/* Pad the shorter list with 0's */
		int sizeN = ListFunctions.calculateSize(n);
		int sizeM = ListFunctions.calculateSize(m);
		if (sizeN > sizeM){
			int numberOfZerosToInsert = sizeN - sizeM;
			for (int i = 0; i < numberOfZerosToInsert ; i ++){
				m = ListFunctions.insertInFront(m, 0);
			}
		}
		else if (sizeM > sizeN){
			int numberOfZerosToInsert = sizeM - sizeN;
			for (int i = 0; i < numberOfZerosToInsert ; i++){
				n = ListFunctions.insertInFront(n, 0);
			}
		}
		/*********************************/
		
		PartialSum ps = addForwardOrderHelper(n, m);
		if (ps == null)    // ps will never be null.
			return null;
		if (ps.carry == 1) // since we gotta make our Linked List 1 Node longer.
			updateFront(ps, 0);
		return ps.next;
	}

	// Notice this helper function returns PartialSum instead of Node
	static PartialSum addForwardOrderHelper(Node n, Node m){

		PartialSum ps = new PartialSum(); // we make this early so that we never return null. We can just return new PartialSum()
		if (n == null && m == null)	//either both null, or neither null, since we "padded" the lists.
			return ps;
		else{
			ps = addForwardOrderHelper(n.next, m.next);
			int value = n.data + m.data;
			updateFront(ps, value);
			return ps;
		}
	}
	
	/* Creates a new Node to represent value and puts it in front of SLL. If value is >= 10, will need to use a carry */
	private static void updateFront(PartialSum ps, int value){
		int carry = (value + ps.carry) / 10;
		int rem   = (value + ps.carry) % 10;
		ps.carry = carry;
		Node n = new Node(rem);
		n.next = ps.next;
		ps.next = n;
	}
}
