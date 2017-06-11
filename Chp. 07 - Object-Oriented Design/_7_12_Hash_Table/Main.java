package _7_12_Hash_Table;

public class Main {
	public static void main (String [] args) {
		Hash<Integer, String> map = new Hash<>();
		map.put(2, "Bob");
		System.out.print(map);
		System.out.println("Hash MAX_SIZE = " + map.getMaxSize() + "\n");
		
		map.put(3, "Jenny");
		System.out.print(map);
		System.out.println("Hash MAX_SIZE = " + map.getMaxSize() + "\n");
		
		map.put(6, "Alex");
		System.out.print(map);
		System.out.println("Hash MAX_SIZE = " + map.getMaxSize() + "\n");

		map.put(7, "Jenny");
		System.out.print(map);
		System.out.println("Hash MAX_SIZE = " + map.getMaxSize() + "\n");
		
		map.put(10, "Cynthia");
		System.out.print(map);
		System.out.println("Hash MAX_SIZE = " + map.getMaxSize() + "\n");
		
		map.put(6, "Sam"); // Sam should overwrite Alex
		System.out.print(map);
		System.out.println("Hash MAX_SIZE = " + map.getMaxSize() + "\n");
	}
}
