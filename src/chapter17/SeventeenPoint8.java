package chapter17;

public class SeventeenPoint8 {
	public static int maxSum(int [] array){
		int runningSum = 0;
		int maxSum = 0;
		for (int i = 0; i < array.length; i++){
			runningSum += array[i];
			maxSum = Math.max(maxSum, runningSum);
			if (runningSum < 0)
				runningSum = 0;
		}
		return maxSum;
	}
	/* For special case of array of all negative numbers, our code returns "0" for an sub-array of 0 elements */
}
