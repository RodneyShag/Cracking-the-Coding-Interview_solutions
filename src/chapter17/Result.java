package chapter17;

public class Result {
	int hits = 0;
	int pseudoHits = 0;
	
	public String toString(){
		return ("(" + hits + "," + pseudoHits + ")");
	}
}
