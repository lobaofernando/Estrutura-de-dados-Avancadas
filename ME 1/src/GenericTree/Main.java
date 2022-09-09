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
        System.out.println("6- Converter exemplo em Árvore binária");
        System.out.println("7- Printar exemplo Árvore binária");
        System.out.println("8- Converter Árvore criada em binária");
        System.out.println("9- Printar Árvore binária criada");
        System.out.println("");
        System.out.println("x- Sair");
        System.out.println("10- Printar árvore exemplo");
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        GenericTree exampleTree = new GenericTree();
        exampleTree.addNodetest("A", "");
        exampleTree.addNodetest("B", "A");
        exampleTree.addNodetest("Z", "A");
        exampleTree.addNodetest("C", "B");
        exampleTree.addNodetest("D", "B");
        exampleTree.addNodetest("E", "C");
        exampleTree.addNodetest("F", "A");
        exampleTree.addNodetest("G", "E");
        exampleTree.addNodetest("H", "E");
        exampleTree.addNodetest("K", "E");
        exampleTree.addNodetest("J", "F");

        GenericTree ExampleBtree = null;
        GenericTree btree = null;
        GenericTree tree = null;
        boolean check = true;

        while (check) {
            menu();
            String input;
            Scanner sc = new Scanner(System.in);
            System.out.print("Escolha a opção desejada: ");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    tree = new GenericTree();
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
                case "6":
                    System.out.println("======================================");
                    btree = GenericTree.BinaryTree(exampleTree);
                    break;
                case "7":
                    System.out.println("======================================");
                    if (btree == null) {
                        System.out.println("Primeiro converta uma árvore em binária.");
                        break;
                    }
                    System.out.println(btree.getRoot().print());
                    break;
                case "8":
                    System.out.println("======================================");
                    if (tree == null) {
                        System.out.println("Primeiro crie uma árvore genérica usando a opção adicionar nós.");
                        break;
                    }
                    ExampleBtree = GenericTree.BinaryTree(tree);
                    break;
                case "9":
                    System.out.println("======================================");
                    if (ExampleBtree == null) {
                        System.out.println("Primeiro converta uma árvore em binária.");
                        break;
                    }
                    System.out.println(btree.getRoot().print());
                    break;
                case "10":
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
