package _7_12_Hash_Table;

public class Main {
    public static void main(String[] args) {
        Hash<Integer, String> map = new Hash<>();
        map.put(2, "Bob");
        System.out.print(map);
        System.out.println("Hash numBuckets = " + map.numBuckets + "\n");

        map.put(3, "Jenny");
        System.out.print(map);
        System.out.println("Hash numBuckets = " + map.numBuckets + "\n");

        map.put(6, "Alex");
        System.out.print(map);
        System.out.println("Hash numBuckets = " + map.numBuckets + "\n");

        map.put(7, "Jenny");
        System.out.print(map);
        System.out.println("Hash numBuckets = " + map.numBuckets + "\n");

        map.put(10, "Cynthia");
        System.out.print(map);
        System.out.println("Hash numBuckets = " + map.numBuckets + "\n");

        System.out.println("** Sam should overwrite Alex **\n");
        map.put(6, "Sam");
        System.out.print(map);
        System.out.println("Hash numBuckets = " + map.numBuckets + "\n");
    }
}
