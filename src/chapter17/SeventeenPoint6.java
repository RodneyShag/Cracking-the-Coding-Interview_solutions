package chapter17;

public class SeventeenPoint6 {
	/* My solution is superior to the book's solution */
	public static void minMax(int [] array){	
		if (array == null || array.length == 0)
			return;
		
		int startIndex = -1;	//assume works only with array of positive integers
		int endIndex = -1;
		int maxSoFar = array[0];
		int minSoFar = array[array.length - 1];
		
		/* find endIndex */
		for (int i = 0; i < array.length; i ++){
			if (array[i] > maxSoFar)
				maxSoFar = array[i];
			else if (array[i] < maxSoFar)
				endIndex = i;
		}
		
		/* find startIndex */
		for (int i = array.length - 1; i >= 0; i--){
			if (array[i] < minSoFar)
				minSoFar = array[i];
			else if (array[i] > minSoFar)
				startIndex = i;
		}

		if (startIndex == -1 || endIndex == -1)
			System.out.println("Already Sorted");
		else
			System.out.println("(" + startIndex + "," + endIndex + ")");
	}
}
