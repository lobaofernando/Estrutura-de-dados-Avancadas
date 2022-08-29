package GenericTree;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void printNodes(ArrayList<Node> list) {

        if (list.size()==0) {
            return;
        }

        System.out.println("======================================");
        System.out.println("Nós da árvore: ");

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getName().toUpperCase(Locale.ROOT) + ": " + list.get(i).getChildren().size()
                    + " filhos");

        }
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        Node root = null;
        ArrayList<Node> list = new ArrayList<Node>();

        while (true) {

            Scanner sc = new Scanner(System.in);
            String input;
            printNodes(list);
            System.out.println("======================================");
            System.out.println("Insira o nome do nó: ");
            input=sc.nextLine();

            if (input.equals("exit")) {
                break;
            }

            Node node = new Node(input);

            if (root == null) {
                root = new Node(input);
                System.out.println("Nó " + input + " definido como raiz.");
                list.add(root);
            } else {

                boolean found = false;
                System.out.println("Nó " + input + " será filho de qual nó da árvore? ");
                input = "";
                input = sc.nextLine();

                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).getName().equals(input)) {

                        System.out.println("Nó " + node.getName() + " inserido com filho do Nó " + list.get(i).getName());
                        list.get(i).addChild(node);
                        list.add(node);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Nó não encontrado, tente novamente.");
                }
            }

        }

        printNodes(list);

    }

}
