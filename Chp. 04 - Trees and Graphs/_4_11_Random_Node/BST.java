package _4_11_Random_Node;

class BST {
    Node root = null;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node curr = root;
        while (true) {
            curr.size++;
            if (value <= curr.value) {
                if (curr.left == null) {
                    curr.left = new Node(value);
                    return;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = new Node(value);
                    return;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    public Node find(int value) {
        Node curr = root;
        while (curr != null) {
            if (value == curr.value) {
                return curr;
            } else if (value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    public Node getRandomNode() {
        if (root == null) {
            return null;
        }
        int randomNumber = (int) (Math.random() * root.size);
        return getRandomHelper(root, randomNumber);
    }

    private static Node getRandomHelper(Node node, int num) {
        int leftSize = (node.left == null) ? 0 : node.left.size;
        if (num < leftSize) {
            return getRandomHelper(node.left, num);
        } else if (num == leftSize) {
            return node;
        } else {
            return getRandomHelper(node.right, num - leftSize - 1);
        }
    }
}
