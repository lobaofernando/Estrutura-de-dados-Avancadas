package GenericTree;

//grau , altura, profundidade, nós folha, nós internos
//converter em arvore binaria

public class Main {

    public static void main(String[] args) {

        GenericTree tree1 = new GenericTree();

        boolean check = true;
        while (check) {

            check = tree1.addNode();
        }
        tree1.printNodes();
    }

}
