package chapter17;

/* Used in 17.5 */
public class Result {
	int directHits = 0;
	int pseudoHits = 0;
	
	public String toString(){
		return ("(Direct Hits, Pseudo Hits) = (" + directHits + "," + pseudoHits + ")");
	}
}
