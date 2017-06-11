package _17_21_Volume_of_Histogram;

//  Time Complexity: O(n)
// Space Complexity: O(n)

// Main idea: For each index, the tallest wall anywhere to the left, and to the right, determine
//            the amount of water the index will hold. We can calculate this iteratively.

public class VolumeOfHistogram {
	public static int computeHistogramVolume(int[] histo) {
		/* Calculate left maxes */
		int[] leftMax = new int[histo.length];
		leftMax[0] = histo[0];
		for (int i = 1; i < histo.length; i++) {
			leftMax[i] = Math.max(leftMax[i-1], histo[i]);
		}
				
		/* Calculate right maxes, along with "min" and "sum" */
		int sum = 0;
		int rightMax = 0;
		for (int i = histo.length - 1; i >= 0; i--) {
			rightMax = Math.max(rightMax, histo[i]);
			sum += Math.min(leftMax[i], rightMax) - histo[i];
		}
		return sum;
	}
}
