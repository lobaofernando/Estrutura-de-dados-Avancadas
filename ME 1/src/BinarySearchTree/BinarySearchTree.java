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
        this.list = new ArrayList<Node>();
    }
    //construtor a partir de árvore já feita
    public BinarySearchTree(ArrayList<GenericTree.Node> list) {
        this.list = new ArrayList<Node>();
        for (GenericTree.Node node : list) {
            this.addNode(node.getValue());
        }
    }

    public Node getRoot() {
        return root;
    }

    public ArrayList<Node> getList() {
        return list;
    }

    public void addNode(int value)  {

        Node node = new Node(value);

        if (this.root == null) {
            this.root = node;
            this.list.add(node);
        }
        addNodeRecursive(this.root, value);
    }

    void addNodeRecursive(Node parent, int value) {
        if (value < parent.getValue()) {
            if (parent.getLeft() == null) {
                Node node = new Node(value);
                node.setParent(parent);
                parent.setLeft(node);
                this.list.add(node);
            }
            addNodeRecursive(parent.getLeft(), value);
        }
        else if (value > parent.getValue()) {
            if (parent.getRight() == null) {
                Node node = new Node(value);
                node.setParent(parent);
                parent.setRight(node);
                this.list.add(node);
            }
            addNodeRecursive(parent.getRight(), value);
        }
    }

    public boolean searchNodes(int value) {
        for (Node node : list) {
            if (node.getValue()==value) {
                return true;
            }
        }
        return false;
    }

    Node maxValue(Node node)  {
        //initially minval = root
        //find minval
        while (node.getRight() != null)  {
            node = node.getRight();
        }
        System.out.println(node.getValue());
        return node;
    }

    public void excluir() {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("======================================");
        System.out.println("Insira o valor do nó: ");
        input=sc.nextInt();

        if (input==0) {
            return;
        }

        if (input == this.getRoot().getValue()) {
            System.out.println("Nó raiz não pode ser excluído!!");
        }

        if (!searchNodes(input)) {
            System.out.println("Nó não cadastrado!!");
            return;
        }
        excluirAux(input);
    }

    void excluirAux(int input) {

        for (Node node : this.getList()) {
            if (node.getValue() == input) {

                if (node.getLeft() == null && node.getRight()==null) {
                    if (node.getParent().getValue() > node.getValue()) {
                        node.getParent().setLeft(null);
                    } else {
                        node.getParent().setRight(null);
                    }
                    this.list.remove(node);
                    return;
                }

                if (node.getLeft() == null) {
                    if (node.getValue() > node.getParent().getValue()) {
                        node.getParent().setRight(node.getRight());
                    } else {
                        node.getParent().setLeft(node.getRight());
                    }
                    node.getRight().setParent(node.getParent());
                    this.list.remove(node);
                    return;
                }
                Node no = this.maxValue(node.getLeft());

                if (no.getLeft() != null) {
                    no.getLeft().setParent(no.getParent());

                    if (no.getLeft().getValue() < no.getParent().getValue()) {
                        no.getParent().setLeft(no.getLeft());
                    } else {
                        no.getParent().setRight(no.getLeft());
                    }
                } else {
                    if (no.getValue() > no.getParent().getValue()) {
                        no.getParent().setRight(null);
                    } else {
                        no.getParent().setLeft(null);
                    }
                }
                node.setValue(no.getValue());
                this.list.remove(no);
                return;
            }
        }
    }

}