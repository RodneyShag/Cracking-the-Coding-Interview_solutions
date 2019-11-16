// github.com/RodneyShag

package _17_20_Continuous_Median;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 17.20: Continuous Median\n");
        for (int i = 0; i < 5; i++) {
            ContinuousMedian.addNum(i);
            System.out.println("Add " + i + " to data structure.  Median = " + ContinuousMedian.getMedian());
        }
    }
}
