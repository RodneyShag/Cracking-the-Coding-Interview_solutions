package _17_05_Letters_and_Numbers;

class Pair {
    int left;
    int right;

    Pair(int l, int r) {
        left = l;
        right = r;
    }

    Pair(Pair otherPair) {
        left = otherPair.left;
        right = otherPair.right;
    }

    int getSize() {
        return right - left + 1;
    }
}
