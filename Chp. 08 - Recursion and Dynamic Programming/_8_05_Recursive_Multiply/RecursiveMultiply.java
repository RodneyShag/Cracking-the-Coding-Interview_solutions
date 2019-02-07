package _8_05_Recursive_Multiply;

public class RecursiveMultiply {
    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        } else if (a < b) {
            return multiplyHelper(a, b);
        } else {
            return multiplyHelper(b, a);
        }
    }

    private static int multiplyHelper(int smaller, int bigger) {
        if (smaller == 1) {
            return bigger;
        }

        int halfProd = multiplyHelper(smaller / 2, bigger);

        if (smaller % 2 == 0) {
            return halfProd + halfProd;
        } else {
            return halfProd + halfProd + bigger;
        }
    }
}
