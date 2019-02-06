package _16_24_Pairs_with_Sum;

class Pair { // always places smaller value in "a"
    int a;
    int b;

    Pair(int a, int b) {
        this.a = Math.min(a, b);
        this.b = Math.max(a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null || !(obj instanceof Pair)) {
            return false;
        }
        Pair otherPair = (Pair) obj;
        return a == otherPair.a && b == otherPair.b;
    }

    @Override
    public int hashCode() {
        return 2 * a + 3 * b;
    }

    @Override
    public String toString() {
        return "(" + a + "," + b + ")";
    }
}
