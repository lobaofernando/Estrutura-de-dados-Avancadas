package BinarySearchTree;

import java.util.ArrayList;
import java.util.Iterator;

public class Node {

    ArrayList<Node> children = new ArrayList<Node>();

    private int value;
    private Node left;
    private Node right;

    public Node(int name) {
        this.value =name;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public void addChild(Node node) {
        ;
    }

    public Node search(Node root, int value)
    {
        if (root==null || root.value==value)
            return root;
        if (root.value < value)
            return search(root.right, value);
        return search(root.left, value);
    }

    public void addRecursive(Node root, int value)
    {
        if (root.value < value) {
            if (root.getRight() == null) {
                Node node = new Node(value);
                root.setRight(node);
                return;
            }
            addRecursive(root.getRight(), value);
        }else {
            if (root.getLeft() == null) {
                Node node = new Node(value);
                root.setRight(node);
                return;
            }
            addRecursive(root.getLeft(), value);
        }
    }

    public void printNode() {
        System.out.print("Valor: ");
        System.out.println(this.getValue());
        System.out.print("<--Esquerda: ");
        System.out.println(left.getValue());
        System.out.print("Direita-->: ");
        System.out.println(right.getValue());
    }

    public String print() {
        StringBuilder buffer = new StringBuilder(50);
        printAux(buffer, "", "");
        return buffer.toString();
    }

    private void printAux(StringBuilder builder, String text, String childrenPrefix) {
        builder.append(text);
        builder.append(this.value);
        builder.append("\n");
        for (Iterator<Node> it = this.children.iterator(); it.hasNext();) {
            Node next = it.next();
            if (it.hasNext()) {
                next.printAux(builder, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.printAux(builder, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

}
