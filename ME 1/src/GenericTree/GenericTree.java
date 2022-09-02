package GenericTree;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GenericTree {

    private Node root;
    private ArrayList<Node> list;

    //construtor
    public GenericTree() {
        this.root = null;
        this.list = new ArrayList<Node>();
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
                System.out.println("Nó " + input + " definido como raiz.");
                list.add(root);
            } else {

                boolean found = false;
                System.out.println("Nó " + input + " será filho de qual nó da árvore? ");
                input = sc.nextLine();

                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).getName().equals(input)) {

                        System.out.println("Nó " + node.getName() + " inserido com filho do Nó " + list.get(i).getName());
                        list.get(i).addChild(node);
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

    //exibir nós
    public void printNodes() {

        if (this.list.size()==0) {
            return;
        }

        System.out.println("======================================");
        System.out.println("Nós da árvore: ");

        for (Node node : this.list) {

            System.out.println(node.getName().toUpperCase(Locale.ROOT) + ": " + node.getChildren().size()
                    + " filhos");

        }
        System.out.println("======================================");
    }

}
