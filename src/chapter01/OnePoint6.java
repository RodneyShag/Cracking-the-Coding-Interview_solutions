package chapter01;

public class OnePoint6 { // O(n^2) runtime. Impossible to do better since must touch all n^2 elements.

	/* Rotates image[][] 90 degrees clockwise */
	public static void rotate90clockwise(int [][] image){
		int n = image.length;
		
		for (int layer = 0; layer < n/2; layer++){
			int first = layer;
			int last  = n - 1 - layer;
			for (int i = first; i < last ; i++){
				int offset = i - first;
				/* 4-way swap */
				int temp  = image[first][first + offset];
				image[first][first + offset] = image[last - offset][first];
				image[last - offset][first] = image[last][last - offset];
				image[last][last - offset] = image[first + offset][last];
				image[first + offset][last] = temp;
			}
		}
	}
	
	/* For fun: I tried rotating 180 degrees */
	public static int [] [] rotate180(int [] [] image){
		int n = image.length;
		
		for (int row = 0; row < n/2; row++){
			for (int i = 0; i < n; i++){
				swap(image, i, row, n-1-i, n-1-row); // notice this is the 5-argument version of swap.
			}
		}
		/* If n is odd, rotate middle row */
		if(n % 2 == 1){
			for (int i = 0; i < n/2; i++){
				swap(image, i, n/2, n-1-i, n/2);
			}
		}
		return image;
	}
	
	/* Swaps 2 elements in a 2-D array */
	private static void swap(int [][] array, int x1, int y1, int x2, int y2){
		int temp = array[y1][x1];
		array[y1][x1] = array[y2][x2];
		array[y2][x2] = temp;
	}
}
