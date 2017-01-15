package chapter3;
/* Solution 1
 * Remember to use "int [] heads" and simply implement push/pop/peek
 */
public class ThreePoint1 {
	int stackSize = 100;
	int [] array = new int[3 * stackSize];
	int [] heads = {-1, -1, -1};	//memorize syntax
	
	void push(int value, int stackNum) throws Exception{
		if (heads[stackNum] + 1 > stackSize)
			throw new Exception("Out of space");
		int offset = arrayOffset(stackNum) + ++heads[stackNum];
		array[offset] = value;
	}
	
	int pop(int stackNum) throws Exception{
		if (heads[stackNum] == -1)
			throw new Exception("No elements to pop");
		int offset = arrayOffset(stackNum) + heads[stackNum];
		int result = array[offset];
		//array[offset] = 0;		// "Clear index" from book. Not really necessary
		heads[stackNum]--;
		return result;
	}

	int peek(int stackNum) throws Exception{
		if (heads[stackNum] == -1)
			throw new Exception("No elements to pop");
		int offset = arrayOffset(stackNum) + heads[stackNum];
		return array[offset];
	}
	
	boolean isEmpty(int stackNum){
		return (heads[stackNum] == -1);
	}
	
	private int arrayOffset(int stackNum){
		return stackSize * stackNum;
	}
	
	/* Rodney added this for testing */
	public void printArray(){
		for (int stackNum = 0; stackNum <= 2; stackNum++){
			System.out.print("\nStack #" + stackNum + ":  ");
			for (int i = arrayOffset(stackNum); i <= arrayOffset(stackNum) + heads[stackNum] ; i++){
				System.out.print(array[i] + " ");
			}

		}
	}
	
	/* Solution 2: Variable stack sizes - Book has a solution. Even book says it's too complicated for interviews
	 * Things to remember in their implementation 
	 * 1) If, for example, stack 1 gets too big, they shift stack 2 over (by copying over elements 1 by 1 starting from the end of the stack)
	 * 2) The array is allowed to wrap around on itself (so will need to use % operator)
	 * 3) They made a new class called "StackData" to keep track of a bunch of information about each stack, instead of just the "head" 
	 *    like we did in the previous problem.
	 */
}
