package GenericTree;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//classe de árvore genérica
public class GenericTree {

    private Node root;                          //raiz
    private final ArrayList<Node> list;         //lista de nós na árvore
    private int nivel = 0;                    //grau máximo da árvore

    //construtor
    public GenericTree() {
        this.root = null;
        this.list = new ArrayList<>();
    }
    //retorna nó raiz
    public Node getRoot() {
        return this.root;
    }
    //retorna grau máximo da árvore
    public int getNivel() {
        return nivel;
    }
    //seta o grau máximo
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    //retorna grau do nó pesquisado
    public void getNodeGrau(String name) {

        for (Node node : this.list) {

            if (node.getName().equals(name)) {
                System.out.println("Nó " + node.getName() + " tem grau " + node.getNivel());
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
                System.out.println(node.getName());
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
                System.out.println(node.getName());
            }
        }
        System.out.println("======================================");

    }
    //adicionar nó
    public void addNode() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("======================================");
        System.out.println("Insira o nome do nó: ");
        input=sc.nextLine();

        if (input.equals("exit")) {
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
            input = sc.nextLine();

            for (Node n : this.list) {
                if (n.getName().equals(input)) {
                    node.setGrau(n.getNivel()+1);
                    if (node.getNivel() > this.nivel) {
                        setNivel(node.getNivel());
                    }
                    System.out.println("Nó " + node.getName() + " inserido com filho do Nó " + n.getName());
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
            System.out.print(node.getName().toUpperCase(Locale.ROOT) + ": ");
            System.out.print("nível " + node.getNivel() + ", ");
            System.out.print("grau " + node.getChildren().size() + ", ");
            //node.getNodeAltura(this.getNivel());
            System.out.print(", ");
            node.printChildren();
            System.out.println("");

        }
        System.out.println("====================================== ");
    }
    //verificar se nó existe
    public boolean searchNodes(String name) {
        for (Node node : list) {
            if (node.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
