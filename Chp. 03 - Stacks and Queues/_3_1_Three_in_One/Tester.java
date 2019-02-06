package _3_1_Three_in_One;

public class Tester {
    public static void main(String[] args) {
        System.out.print("*** Test 3.1: Three in One\n");
        ThreeInOne stacks = new ThreeInOne();
        try {
            stacks.push(1, 0);
            stacks.push(2, 0);
            stacks.push(3, 0);
            stacks.push(4, 1);
            stacks.push(5, 1);
            stacks.push(6, 1);
            stacks.push(7, 2);
            stacks.push(8, 2);
            stacks.push(9, 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        stacks.print();
    }
}
