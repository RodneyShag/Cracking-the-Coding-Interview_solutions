package _4_11_Random_Node;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public boolean equals(Object other) { // must take an "Object" as a parameter, not a
                                          // "Node", so that it overrides the .equals method
        if (other == this) {
            return true;
        } else if (other == null || !(other instanceof Node)) {
            return false;
        }
        Node otherNode = (Node) other;
        return this.value == otherNode.value
            && this.left.equals(otherNode.left)
            && this.right.equals(otherNode.right);
    }

    @Override
    public int hashCode() {
        return value; // since only using 1 int, won't be multiplying by primes.
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
