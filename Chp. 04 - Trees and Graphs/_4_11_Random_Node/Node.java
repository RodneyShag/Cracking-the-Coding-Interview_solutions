package _4_11_Random_Node;

class Node {
	int value;
	Node left;
	Node right;
	int size;
	
	Node(int value) {
		this.value = value;
		left  = null;
		right = null;
		size = 1; // This will count size of the entire tree rooted at this Node.
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
