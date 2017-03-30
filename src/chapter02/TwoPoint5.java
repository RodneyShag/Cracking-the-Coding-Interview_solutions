package chapter02;

public class TwoPoint5 {
	/* Reverse Order. Accounts for adding lists of different lengths */
	static Node addReverseOrder(Node n, Node m) {
		if (n == null) {
			return m;
		} else if (m == null) {
			return n;
		}
		return addReverseOrderHelper(n, m, 0);
	}

	private static Node addReverseOrderHelper(Node n, Node m, int carry) {
		if (n == null && m == null && carry == 0) {
			return null;
		}
		int value = carry; // we calculate "value" step by step, making it easy to test null values.
		if (n != null) {
			value += n.data;
		}
		if (m != null) {
			value += m.data;
		}
		int thisDigit = value % 10;
		int nextCarry = value / 10;
		Node result = new Node(thisDigit);
		result.next = addReverseOrderHelper(n == null ? null : n.next, m == null ? null : m.next, nextCarry);
		return result;
	}
	
	static Node AddForwardOrder(Node n, Node m) {
		/* Pad the shorter list with 0's */
		int sizeN = ListFunctions.calculateSize(n);
		int sizeM = ListFunctions.calculateSize(m);
		if (sizeN > sizeM) {
			int numberOfZerosToInsert = sizeN - sizeM;
			for (int i = 0; i < numberOfZerosToInsert ; i++) {
				m = ListFunctions.insertInFront(m, 0);
			}
		}
		else if (sizeM > sizeN) {
			int numberOfZerosToInsert = sizeM - sizeN;
			for (int i = 0; i < numberOfZerosToInsert ; i++) {
				n = ListFunctions.insertInFront(n, 0);
			}
		}
		
		/* Do the addition */
		IntWrapper carry = new IntWrapper();
		Node result = AddForwardOrderHelper(n, m, carry);
		
		/* Account for the carry if necessary */
		if (carry.value == 1) {
			Node node = new Node(1);
			node.next = result;
			return node;
		} else {
			return result;
		}
	}
	
	static Node AddForwardOrderHelper(Node n, Node m, IntWrapper carry) {
		if (n == null && m == null) {
			return null;
		}
		
		Node rest = AddForwardOrderHelper(n.next, m.next, carry);
		int value = n.data + m.data + carry.value;
		
		int thisDigit = value % 10;
		int nextCarry = value / 10;
		
		Node result = new Node(thisDigit);
		result.next = rest;
		carry.value = nextCarry;
		
		return result;
	}
}
