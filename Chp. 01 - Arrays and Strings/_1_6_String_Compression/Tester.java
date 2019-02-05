package _1_6_String_Compression;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test 1.6: String Compression\n");
        test("aabcccccaaa");
        test("abababa");
    }

    private static void test(String original) {
        System.out.println("  Original string: " + original);
        String compressed = StringCompression.basicCompression(original);
        System.out.println("Compressed string: " + compressed + "\n");
    }
}
