package _17_03_Random_Set;

/*		(From book)
	Suppose we have an algorithm that can pull a random set of m elements from an array
	of size n - 1. How can we use this algorithm to pull a random set of m elements from
	an array of size n?
	
	We can first pull a random set of size m from the first n - 1 elements. Then, we just need
	to decide if array [n] should be inserted into our subset (which would require pulling
	out a random element from it). An easy way to do this is to pick a random number k
	from 0 through n. If k < m, then insert array [n] into subset [k].This will both "fairly"
	(i.e., with proportional probability) insert array[n] into the subset and "fairly"remove
	a random element from the subset.
	
	(Book's iterative solution of the above recursive explanation is below)
*/
public class RandomSet {
	public int[] generate(int [] array, int m) {
		/* Copy first "m" elements into new array */
		int [] solution = new int[m];
		for (int i = 0; i < m; i++) {
			solution[i] = array[i];
		}
		
		/* 1 by 1, decide if array[i] (where i >= m) should be in solution[] */
		for (int i = m; i < array.length; i++) {
			int rand = (int) (Math.random() * (i+1)); // random number between 0 and i inclusive
			if (rand < m) {							  // There's "rand / m" percent chance that the new element will be put into array
				solution[rand] = array[i];
			}
		}
		return solution;
	}
}
