package _17_10_Majority_Element;

import java.util.Arrays;

public class MajorityElement {
    public static Integer majorityElement(int[] array) {
        Integer majority = getCandidate(array);
        return isMajorityValid(array, majority) ? majority : null;
    }

    private static Integer getCandidate(int[] array) {
        int majority = 0;
        int count = 0;
        for (int n : array) {
            if (count == 0) {
                majority = n;
            }
            if (majority == n) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    private static boolean isMajorityValid(int[] array, int majority) {
        long count = Arrays.stream(array).filter(a -> (a == majority)).count();
        return count * 2 > array.length;
    }
}
