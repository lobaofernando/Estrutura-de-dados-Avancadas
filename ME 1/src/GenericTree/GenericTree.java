package GenericTree;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//classe de árvore genérica
public class GenericTree {

    private Node root;                          //raiz
    private ArrayList<Node> list;               //lista de nós na árvore
    private int nivel = 0;                      //grau máximo da árvore

    //construtor
    public GenericTree() {
        this.root = null;
        this.list = new ArrayList<>();
    }

    //construtor a partir de uma árvore genérica
    public static GenericTree BinaryTree(GenericTree tree) {

        GenericTree btree = new GenericTree();
        btree.setRoot(tree.getRoot());
        btree.setList(tree.getList());

        for (int i = btree.getList().size() - 1; i >= 0; i--) {

            while (btree.getList().get(i).getChildren().size() > 2) {

                btree.getList().get(i).getChildren().remove(btree.getList().get(i).getChildren().size() - 1);

            }

        }
        return btree;
    }
    //retorna nó raiz
    public Node getRoot() {
        return this.root;
    }
    //seta o nível máximo
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    //set root
    public void setRoot(Node root) {
        this.root = root;
    }
    //get list
    public ArrayList<Node> getList() {
        return this.list;
    }
    //set list
    public void setList(ArrayList<Node> list) {
        this.list = list;
    }
    //retorna grau do nó pesquisado
    public void getNodeGrau(int value) {

        for (Node node : this.list) {

            if (node.getValue()==value) {
                System.out.println("Nó " + node.getValue() + " tem grau " + node.getChildren().size());
                return;
            }
        }

        System.out.println("Nó não enccontrado!!");
    }
    //exibir nós
    public void folhas() {

        System.out.println("======================================");
        System.out.println("Nós folha:");
        for (Node node : this.list) {
            if (node.isFolha()) {
                System.out.println(node.getValue());
            }
        }
        System.out.println("======================================");

    }
    //retorna listagem dos nós internos na árvore
    public void internos() {

        System.out.println("======================================");
        System.out.println("Nós internos:");
        for (Node node : this.list) {
            if (!node.isFolha()) {
                System.out.println(node.getValue());
            }
        }
        System.out.println("======================================");

    }
    //adicionar nó
    public void addNode() {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("======================================");
        System.out.println("Insira o valor do nó: ");
        input=sc.nextInt();

        if (input==0) {
            return;
        }

        if (searchNodes(input)) {
            System.out.println("Nó já cadastrado!!");
            return;
        }

        Node node = new Node(input);

        if (root == null) {
            this.root = new Node(input);
            this.root.setGrau(0);
            System.out.println("Nó " + input + " definido como raiz.");
            this.list.add(root);
        } else {
            System.out.println("Nó " + input + " será filho de qual nó da árvore? ");
            input = sc.nextInt();

            for (Node n : this.list) {
                if (n.getValue()==input) {
                    node.setGrau(n.getNivel()+1);
                    if (node.getNivel() > this.nivel) {
                        setNivel(node.getNivel());
                    }
                    System.out.println("Nó " + node.getValue() + " inserido com filho do Nó " + n.getValue());
                    n.addChild(node);
                    this.list.add(node);
                    return;
                }
            }
                System.out.println("Nó não encontrado, tente novamente.");
        }
    }
    //retorna listagem dos nós folhas na árvore
    public void printNodes() {

        if (this.list.size()==0) {
            return;
        }

        System.out.println("======================================");
        System.out.println("Nós da árvore: ");

        for (Node node : this.list) {
            System.out.print(node.getValue() + ": ");
            System.out.print("nível " + node.getNivel() + ", ");
            System.out.print("grau " + node.getChildren().size() + ", ");
            System.out.print(", ");
            node.printChildren();
            System.out.println("");

        }
        System.out.println("====================================== ");
    }
    //verificar se nó existe
    public boolean searchNodes(int value) {
        for (Node node : list) {
            if (node.getValue()==value) {
                return true;
            }
        }
        return false;
    }
    //adiciona nós diretamente
    public void addNodetest(int value, int parent) {

        if (searchNodes(value)) {
            return;
        }

        Node node = new Node(value);

        if (root == null) {
            this.root = node;
            this.root.setGrau(0);
            this.list.add(root);
        } else {
            for (Node n : this.list) {
                if (n.getValue()==parent) {
                    node.setGrau(n.getNivel()+1);
                    if (node.getNivel() > this.nivel) {
                        setNivel(node.getNivel());
                    }
                    n.addChild(node);
                    this.list.add(node);
                    return;
                }
            }
        }
    }
}
