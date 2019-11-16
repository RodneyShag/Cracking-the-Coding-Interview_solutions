// github.com/RodneyShag

package _17_06_Count_of_2s;

/* Brute force solution. Book's other solution is too complicated for an interview */
public class CountOf2s {

    public static int count2s(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            count += numberOf2s(i);
        }
        return count;
    }

    /* Counts number of 2s in a single number */
    private static int numberOf2s(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 2) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}
