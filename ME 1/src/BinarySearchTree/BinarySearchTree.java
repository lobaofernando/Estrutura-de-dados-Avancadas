package BinarySearchTree;

import GenericTree.BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

//classe de árvore binária
public class BinarySearchTree {

    private Node root;                          //raiz
    private ArrayList<Node> list;               //lista de nós na árvore

    //construtor
    public BinarySearchTree() {
        this.root = null;
        this.list = new ArrayList<>();
    }
    //construtor a partir de árvore já feita
    public BinarySearchTree(ArrayList<GenericTree.Node> list) {
        for (GenericTree.Node node : list) {
            this.addNode(node.getValue());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(int root) {
        Node node = new Node(root);
        this.root = node;
    }

    public ArrayList<Node> getList() {
        return list;
    }

    public void setList(ArrayList<Node> list) {
        this.list = list;
    }

    public void printTree() {
        this.root.print();
    }

    public void addNode(int value)  {
        this.root = addNodeRecursive(this.root, value);
    }

    Node addNodeRecursive(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            list.add(node);
            return node;
        }
        if (value < node.getValue())
            node.setLeft(addNodeRecursive(node.getLeft(), value));
        else if (value > node.getValue())
            node.setRight(addNodeRecursive(node.getRight(), value));
        return node;
    }

    public boolean searchNodes(int value) {
        for (Node node : list) {
            if (node.getValue()==value) {
                return true;
            }
        }
        return false;
    }

    int minValue(Node node)  {
        //initially minval = root
        int minval = node.getValue();
        //find minval
        while (node.getLeft() != null)  {
            minval = node.getLeft().getValue();
            node = node.getLeft();
        }
        return minval;
    }

    int maxValue(Node node)  {
        //initially minval = root
        int minval = node.getValue();
        //find minval
        while (node.getLeft() != null)  {
            minval = node.getLeft().getValue();
            node = node.getLeft();
        }
        return minval;
    }

    public void deleteNode() {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("======================================");
        System.out.println("Insira o valor do nó: ");
        input=sc.nextInt();

        if (input==0) {
            return;
        }

        if (!searchNodes(input)) {
            System.out.println("Nó não cadastrado!!");
            return;
        }
        System.out.println("\nAntes\n");
        System.out.println(this.getRoot().print());
        this.root = delete_Recursive(this.root, input);
        System.out.println("\nDepois\n");
        System.out.println(this.getRoot().print());
    }

    Node delete_Recursive(Node node, int value)  {

        if (node == null)  return null;

        if (value < node.getValue())
            node.setLeft(delete_Recursive(node.getLeft(), value));
        else if (value > node.getValue())
            node.setRight(delete_Recursive(node.getRight(), value));
        else  {
            if (node.getLeft() == null)
                return node.getLeft();
            else if (node.getRight() == null)
                return node.getLeft();

            node.setValue(minValue(node.getRight()));

            node.setRight(delete_Recursive(node.getRight(), node.getValue()));
        }
        return node;
    }
}