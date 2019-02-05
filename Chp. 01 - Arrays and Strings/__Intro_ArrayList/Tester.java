package __Intro_ArrayList;

public class Tester {
    public static void main(String[] args) {
        System.out.println("*** Test ArrayList\n");
        test(new String[]{ "Hi", "there" }, new String[]{ "Robert", "Jones" });
    }

    private static void test(String[] strings1, String[] strings2) {
        System.out.println(IntroArrayList.merge(strings1, strings2));
    }
}
