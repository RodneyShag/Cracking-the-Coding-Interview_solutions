package _17_18_Shortest_Supersequence;

public class HeapNode {
	int value; // same as the value that's the key in our HashMap
	int index;
	
	HeapNode(int listID, int pos) {
		this.value = listID;
		this.index = pos;
	}
	
	@Override
	public String toString() {
		return "" + index;
	}
}