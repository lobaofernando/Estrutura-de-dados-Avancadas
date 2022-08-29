import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Node root = new Node(20);
        ArrayList<Node> list = new ArrayList<Node>();

        list.add(root);

        while (true) {

            Scanner sc = new Scanner(System.in);
            int input;
            System.out.println("Digite um valor ou então digite 0 para sair: ");
            input=sc.nextInt();

            if (input <= 0 ) {
                break;
            }

            list.add(root.addNode(input));
        }

        for (int c = 0; c < list.size(); c++) {

            System.out.println("Nó       = "+list.get(c).getValue());
            if (list.get(c).getLeft() == null) {
                System.out.println("Esquerda = ----");
            } else {
                System.out.println("Esquerda = "+list.get(c).getLeft().getValue());
            }
            if (list.get(c).getRight() == null) {
                System.out.println("Direita  = ----");
            } else {
                System.out.println("Direita  = "+list.get(c).getRight().getValue());
            }
            System.out.println(" ");

        }
    }

}
