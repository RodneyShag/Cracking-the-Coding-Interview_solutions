package _17_12_BiNode;

public class Tester {
	public static void main(String[] args) {
		test_solution1();
		test_solution2();
	}
	
	private static void test_solution1() {
		System.out.println("*** Test 17.13: BiNode\n");
		BiNode root = createTree();
		Converter.inorderTraverse(root);
		System.out.print("Solution 1: ");
		print(Converter.head);
	}
	
	private static void test_solution2() {
		BiNode root = createTree();
		NodePair np = Converter.convert(root);
		System.out.print("\nSolution 2: ");
		print(np.head);
	}
	
	// This is the tree from the book 
	// 
	//          4
	//        2   5
	//       1 3   6
	//      0
	private static BiNode createTree() {
		BiNode zero  = new BiNode(0);
		BiNode one   = new BiNode(1);
		BiNode two   = new BiNode(2);
		BiNode three = new BiNode(3);
		BiNode four  = new BiNode(4);
		BiNode five  = new BiNode(5);
		BiNode six   = new BiNode(6);
		four.left  = two;
		four.right = five;
		two.left   = one;
		two.right  = three;
		five.right = six;
		one.left   = zero;
		return four;
	}
	
	private static void print(BiNode n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.right;
		}
	}
}
