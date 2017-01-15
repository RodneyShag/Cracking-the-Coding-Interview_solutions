package chapter10;

public class Chapter10 {
	public static void main (String [] args){
		/* Introduction Notes:
		 * 4 ways to divide data
		 * 	- by order of appearance
		 *  - by hashing it mod number of machines (Benefit: Every machine knows exactly where data is)
		 *  - grouping similar things together (like all people in mexico)
		 *  - arbitrarily
		 */
		/* 10.1 Notes:
		 * Book says can store data in text files, SQL Database, or XML
		 */
		
		/* 10.2 Notes:
		 * - Use BFS to find (shortest) path between 2 people.
		 * - To Handle the Millions of Users (which won't fit on one machine)
		 * 		- Server Should have:
		 * 			- HashMap<Integer, Machine> machines (which maps machine's ID to the actual machine)
		 * 			- HashMap<lnteger, Integer> personToMachineMap (which maps person's ID to machine's ID)
		 * 		- Machine should have:
		 * 			- HashMap<Integer, Person> persons (which maps person's ID to Person)
		 * - Optimization: Reduce Machine Jumps - Look up 5 things at once instead of 1 by 1 (see book for details)
		 */
	
		/* 10.5 Notes:
		 * - Simple Answer: Use HashTable to mark pages as visited.
		 * - To solve problem where some URLs are different but content is same/similar:
		 * 		- Create a "signature" for each page so we can assess degree of similarity.
		 * 		  Then, If a page has a high degree of similarity to other pages, deprioritize crawling its children.
		 */
		
		/* 10.6 - We have 10 billion URLS. Detect Duplicates:
		 * - Note: 10 billion URLS at 100 characters each at 4 bytes each = 4 terabytes of information.
		 * - create 4000 1GB chunks of files called <x>.txt where <x> is hash(url) % 4000. now all URLS with same hash value are in the same file. 
		 * - Now do a 2nd pass (that is, go through each text file and create a HashMap<URL, Boolean> to detect duplicates)
		 * - (Also, can split this up into 4000 machines to process in parallel. Has its own pros/cons.
		 * 
		 *            --- hashing to group similar things together is a great trick (also used in putting anagrams together problem for String[])
		 */
		
		/* 10.7 - Design caching mechanism for Web Server:
		 * - "A linked list would allow easy purging of old data, by moving "fresh" items to the front. We could implement it to remove the 
		 *    last element of the linked list when the list exceeds a certain size." (Each machine can have a copy of this)
		 * - Storing the cache (which is HashMap<String, Node>). 3 Options:
		 * 		0) Each machine has it's own cache of just it's searches(lame)
		 * 		1) Each machine has it's own cache of all machine's searches
		 * 		2) Cache is shared across machines (by hashing keys)
		 * 		3) Rodney way: Each machine has most popular searches cached, and the rest is shared among the machines
		 */
	}
}
