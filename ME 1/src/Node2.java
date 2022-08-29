public class Node2 {

    int value;
    Node2 left;
    Node2 right;

    public Node2(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    private Node2 addRecursive(Node2 current, int value) {
        if (current == null) {
            return new Node2(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(Node2 root, int value) {
        root = addRecursive(root, value);
    }
}