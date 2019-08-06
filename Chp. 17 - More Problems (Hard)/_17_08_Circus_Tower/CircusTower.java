package _17_08_Circus_Tower;

import java.util.*;

public class CircusTower {
    public static int findMax(int[][] persons) {
        if (persons == null || persons.length == 0 || persons[0].length != 2) {
            return 0;
        }
        Arrays.sort(persons, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        
        int[] sortedArray = new int[persons.length];
        int size = 0;
        for (int[] person : persons) {
            int num = person[1];
            int start = 0;
            int end = size; // 1 element past end of our sortedArray
            while (start != end) {
                int mid = (start + end) / 2;
                if (sortedArray[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            sortedArray[start] = num;
            if (start == size) {
                size++;
            }
        }
        return size;
    }
}
