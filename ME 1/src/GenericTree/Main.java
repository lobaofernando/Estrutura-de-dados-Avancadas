package GenericTree;

//grau , altura, profundidade, nós folha, nós internos
//converter em arvore binaria

import BinarySearchTree.BinarySearchTree;

import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("======================================");
        System.out.println("1 - Criar novo nó");
        System.out.println("2 - Exibir Nós folha da árvore genérica");
        System.out.println("3 - Exibir Nós internos da árvore genérica");
        System.out.println("4 - Exibir nós da árvore genérica");
        System.out.println("5 - Printar Árvore");
        System.out.println("6 - Converter exemplo em Árvore binária");
        System.out.println("7 - Printar exemplo Árvore binária");
        System.out.println("8 - Converter Árvore criada em binária");
        System.out.println("9 - Printar Árvore binária criada");
        System.out.println("10- Printar árvore exemplo\n");
        System.out.println("11- Converter árvore generica para binaria de busca");
        System.out.println("12- Printar árvore binaria de busca convertida");
        System.out.println("13- Printar árvore binária de busca exemplo\n");
        System.out.println("14- Deletar nó da árvore binária de busca convertida 1");
        System.out.println("15- Deletar nó da árvore binária de busca convertida 2");
        System.out.println("16- testDelete()");
        System.out.println("17- testDelete2()");
        System.out.println("\nx - Sair");
        System.out.println("======================================");
    }

    public static void main(String[] args) {
        GenericTree exampleTree = new GenericTree();

        exampleTree.addNodetest(1, 0);
        exampleTree.addNodetest(2, 1);
        exampleTree.addNodetest(23, 1);
        exampleTree.addNodetest(3, 2);
        exampleTree.addNodetest(4, 2);
        exampleTree.addNodetest(5, 3);
        exampleTree.addNodetest(6, 1);
        exampleTree.addNodetest(7, 5);
        exampleTree.addNodetest(8, 5);
        exampleTree.addNodetest(9, 5);
        exampleTree.addNodetest(10, 6);

        BinarySearchTree exampleBSTree = new BinarySearchTree();

        // inputs para arvore binaria de busca exemplo: 8 4 12 6 10 14 5 7 9 11 13 20 15
        exampleBSTree.addNode(8);
        exampleBSTree.addNode(4);
        exampleBSTree.addNode(12);
        exampleBSTree.addNode(6);
        exampleBSTree.addNode(10);
        exampleBSTree.addNode(14);
        exampleBSTree.addNode(5);
        exampleBSTree.addNode(7);
        exampleBSTree.addNode(9);
        exampleBSTree.addNode(11);
        exampleBSTree.addNode(13);
        exampleBSTree.addNode(20);
        exampleBSTree.addNode(15);

        GenericTree ExampleBtree = null;
        BinarySearchTree bstree = null;
        GenericTree btree = null;
        GenericTree tree = new GenericTree();;
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
                case "11":
                    if (tree.getRoot() == null) {
                        System.out.println("Árvore Genérica vazia!");
                        break;
                    }
                    bstree = new BinarySearchTree(tree.getList());
                    break;
                case "12":
                    if (tree.getRoot() == null) {
                        System.out.println("Primeiro use a opção 11 para gerar a Árvore Binária de busca!");
                        break;
                    }
                    System.out.println(bstree.getRoot().print());
                    break;
                case "13":
                    System.out.println(exampleBSTree.getRoot().print());
                    break;
                case "14":
                    if ((bstree != null ? bstree.getRoot() : null) == null) {
                        System.out.println("Primeiro use a opção 11 para gerar a Árvore Binária de busca!");
                        break;
                    }
                    exampleBSTree.deleteNode();
                    break;
                case "15":
                    if ((bstree != null ? bstree.getRoot() : null) == null) {
                        System.out.println("Primeiro use a opção 11 para gerar a Árvore Binária de busca!");
                        break;
                    }
                    exampleBSTree.testDelete();
                    break;
                case "16":
                    if (exampleBSTree.getRoot() == null) {
                        System.out.println("Primeiro use a opção 11 para gerar a Árvore Binária de busca!");
                        break;
                    }
                    exampleBSTree.testDelete();
                    break;
                case "17":
                    if (exampleBSTree.getRoot() == null) {
                        System.out.println("Primeiro use a opção 11 para gerar a Árvore Binária de busca!");
                        break;
                    }
                    exampleBSTree.deleteNode();
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
