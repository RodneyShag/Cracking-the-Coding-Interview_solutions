package chapter17;

public class SeventeenPoint08 {
	public static int maxSum(int [] array){
		int runningSum = 0;
		int maxSum = 0;
		for (int i = 0; i < array.length; i++){
			runningSum += array[i];
			if (runningSum < 0)
				runningSum = 0;
			maxSum = Math.max(maxSum, runningSum);
		}
		return maxSum;
	}
}
