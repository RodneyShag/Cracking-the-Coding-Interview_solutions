package _4_11_Random_Node;

public class Tester {
	public static void main(String[] args) {
		System.out.println("*** Test 4.11: RandomNode\n");
		BST bst = new BST();
		int[] array = {1, 0, 6, 2, 3, 9, 4, 5, 8, 7};
		for (int num : array) {
			bst.insert(num);
		}
		for (int i = 0; i < 20; i++) {
			System.out.print(bst.getRandomNode() + " ");
		}
	}
}
