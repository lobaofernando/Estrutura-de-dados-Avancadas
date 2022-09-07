package GenericTree;

//grau , altura, profundidade, nós folha, nós internos
//converter em arvore binaria

import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("======================================");
        System.out.println("Escolha a opção desejada: ");
        System.out.println("1- Criar novo nó");
        System.out.println("2- Exibir Nós folha");
        System.out.println("3- Exibir Nós internos");
        System.out.println("4- Exibir nós");
        System.out.println("");
        System.out.println("x- Sair");
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        GenericTree tree1 = new GenericTree();
        boolean check = true;

        while (check) {
            menu();
            String input;
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();

            switch (input) {
                case "1":
                    tree1.addNode();
                    break;
                case "2":
                    tree1.folhas();
                    break;
                case "3":
                    tree1.internos();
                    break;
                case "4":
                    tree1.printNodes();
                    break;
                case "x":
                    System.out.println("======================================");
                    System.out.println("Árvore final");
                    tree1.printNodes();
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
