package BinarySearchTree;

import GenericTree.Node;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//classe de árvore binária
public class BinarySearchTree {

    private Node root;                          //raiz
    private ArrayList<Node> list;               //lista de nós na árvore
    private int nivel = 0;                      //grau máximo da árvore

    //construtor
    public BinarySearchTree() {
        this.root = null;
        this.list = new ArrayList<>();
    }
}