// github.com/RodneyShag

package _1_9_String_Rotation;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 1.9: String Rotation\n");
        test("waterbottle", "erbottlewat");
        test("", "erbottlewat");
        test("tooth", "candy");
    }

    private static void test(String s1, String s2) {
        System.out.println(s1 + ", " + s2 + "  --> " + StringRotation.isRotation(s1, s2));
    }
}
