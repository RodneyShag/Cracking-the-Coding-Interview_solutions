package chapter2;

/* Used in TwoPoint7 - Solution 3 */
public class Result {
	/* Data */
	Node node;
	boolean result;

	/* Constructors */
	public Result(){
		node = null;
		result = false;
	}
	public Result(Node node, boolean result){
		this.node = node;
		this.result = result;
	}
}
