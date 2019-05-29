package _17_21_Volume_of_Histogram;

// Main idea: For each index, 2 walls (the tallest wall anywhere to the left, and to the right), together
//            determine the amount of water the index will hold. We can calculate this iteratively.

public class VolumeOfHistogram {
    public static int computeHistogramVolume(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int size = height.length;

        // Calculate left maxes
        int[] leftMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Calculate right maxes
        int[] rightMax = new int[size];
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // Calculate amount of water that can be stored above each spot on histogram
        int water = 0;
        for (int i = 1; i < size - 1; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}

//  Time Complexity: O(n)
// Space Complexity: O(n)
