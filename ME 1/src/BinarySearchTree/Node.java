package BinarySearchTree;

import java.util.ArrayList;
import java.util.Iterator;

public class Node {

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

    public void addRecursive(Node node)
    {
        if (this.value < node.getValue()) {
            if (this.getRight() == null) {
                this.setRight(node);
            } else {
                this.addRecursive(node);
            }
        } else {
            if (this.getLeft() == null) {
                this.setRight(node);
            } else {
                this.addRecursive(node);
            }
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
        System.out.println("Árvore Binária de Busca:");
        System.out.println("\nLegenda:");
        System.out.println("    Direita:  \u001B[44m   \033[0m");
        System.out.println("    Esquerda: \u001B[41m   \033[0m\n");
        StringBuilder buffer = new StringBuilder(50);
        printAux(buffer, "", "");
        return buffer.toString();
    }

    private void printAux(StringBuilder builder, String text, String childrenPrefix) {
        builder.append(text);
        builder.append(this.value);
        builder.append("\033[0m");
        builder.append("\n");

        if (this.getRight() != null) {
            if (this.getLeft() != null) {
                this.getRight().printAux(builder, childrenPrefix + "\u001B[34m├──── ", childrenPrefix + "\u001B[31m│      ");
            } else {
                this.getRight().printAux(builder, childrenPrefix + "\u001B[34m└──── ", childrenPrefix + "\u001B[31m       ");
            }
        }
        if (this.getLeft() != null) {
            this.getLeft().printAux(builder, childrenPrefix + "\u001B[31m└──── ", childrenPrefix + "       ");
        }
    }

}
