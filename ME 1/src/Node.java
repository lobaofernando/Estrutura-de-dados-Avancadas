import java.util.ArrayList;

public class Node {

    private int value;
    private Node left;
    private Node right;
    ArrayList<Node> list = new ArrayList<Node>();

    public Node(int value) {
        this.value  = value;
        left = null;
        right = null;
    }

    public void addList(Node node) {
        list.add(node);
    }

    public Node addNode(int value) {
        Node node = new Node(value);
        if (value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                right.addNode(value);
            }
        } else {
            if (this.left == null) {
                this.left = node;
            } else {
                left.addNode(value);
            }
        }
        return node;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
