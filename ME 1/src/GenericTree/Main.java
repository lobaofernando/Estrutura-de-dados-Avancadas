package GenericTree;

//grau , altura, profundidade, nós folha, nós internos
//converter em arvore binaria

import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("======================================");
        System.out.println("1- Criar novo nó");
        System.out.println("2- Exibir Nós folha");
        System.out.println("3- Exibir Nós internos");
        System.out.println("4- Exibir nós");
        System.out.println("5- Printar Árvore");
        System.out.println("");
        System.out.println("x- Sair");
        System.out.println("9- Printar árvore exemplo");
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        GenericTree exampleTree = new GenericTree();
        exampleTree.addNodetest("A", "");
        exampleTree.addNodetest("B", "A");
        exampleTree.addNodetest("C", "B");
        exampleTree.addNodetest("D", "B");
        exampleTree.addNodetest("E", "C");
        exampleTree.addNodetest("F", "A");
        exampleTree.addNodetest("G", "E");
        exampleTree.addNodetest("H", "E");
        exampleTree.addNodetest("J", "F");

        GenericTree tree = new GenericTree();
        boolean check = true;

        while (check) {
            menu();
            String input;
            Scanner sc = new Scanner(System.in);
            System.out.print("Escolha a opção desejada: ");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    tree.addNode();
                    break;
                case "2":
                    tree.folhas();
                    break;
                case "3":
                    tree.internos();
                    break;
                case "4":
                    tree.printNodes();
                    break;
                case "5":
                    System.out.println("======================================");
                    System.out.println(tree.getRoot().print());
                    break;
                case "9":
                    exampleTree.printNodes();
                    System.out.println(exampleTree.getRoot().print());
                    break;
                case "x":
                    System.out.println("======================================");
                    System.out.println("Árvore final");
                    tree.printNodes();
                    System.out.println("Saindo ....");
                    check = false;
                    break;
                default:
                    System.out.println("Valor não reconhecido, tente novamente!");
                    break;
            }
        }
    }
}
