package GenericTree;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GenericTree {

    private Node root;
    private ArrayList<Node> list;
    private int maxGrau = 0;

    //construtor
    public GenericTree() {
        this.root = null;
        this.list = new ArrayList<Node>();
    }

    public int getMaxGrau() {
        return maxGrau;
    }

    public void setMaxGrau(int maxGrau) {
        this.maxGrau = maxGrau;
    }

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
    public boolean addNode() {

        while (true) {

            Scanner sc = new Scanner(System.in);
            String input;
            printNodes();
            System.out.println("======================================");
            System.out.println("Insira o nome do nó: ");
            input=sc.nextLine();

            if (input.equals("exit")) {
                return false;
            }

            Node node = new Node(input);

            if (root == null) {
                root = new Node(input);
                root.setGrau(0);
                System.out.println("Nó " + input + " definido como raiz.");
                list.add(root);
            } else {

                boolean found = false;
                System.out.println("Nó " + input + " será filho de qual nó da árvore? ");
                input = sc.nextLine();

                for (Node n : this.list) {

                    if (n.getName().equals(input)) {

                        node.setGrau(n.getGrau()+1);
                        if (node.getGrau() > this.maxGrau) {
                            setMaxGrau(node.getGrau());
                        }
                        System.out.println("Nó " + node.getName() + " inserido com filho do Nó " + n.getName());
                        n.addChild(node);
                        list.add(node);
                        found = true;
                        return true;
                    }
                }
                if (!found) {
                    System.out.println("Nó não encontrado, tente novamente.");
                }
            }
        }
    }

    public void getNodeGrau(String name) {

        for (Node node : this.list) {

            if (node.getName().equals(name)) {
                System.out.println("Nó " + node.getName() + " tem grau " + node.getGrau());
                return;
            }
        }

        System.out.println("Nó não enccontrado!!");
    }

    public void getNodeAltura(Node n) {

        for (Node node : this.list) {

            if (node.equals(n)) {
                System.out.println("Nó " + node.getName() + " tem altura " + Math.abs((node.getGrau() - this.maxGrau)));
                return;
            }
        }

        System.out.println("Nó não enccontrado!!");
    }

    //exibir nós
    public void printNodes() {

        if (this.list.size()==0) {
            return;
        }

        System.out.println("======================================");
        System.out.println("Nós da árvore: ");

        for (Node node : this.list) {

            System.out.print(node.getName().toUpperCase(Locale.ROOT) + ": " + node.getChildren().size()
                    + " filhos e grau " + node.getGrau() + " ");
            getNodeAltura(node);

        }
        System.out.println("====================================== " + this.getMaxGrau());
    }

}
