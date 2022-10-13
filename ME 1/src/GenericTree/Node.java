package GenericTree;

import java.util.ArrayList;
import java.util.Iterator;

public class Node {

    int value;
    ArrayList<Node> children = new ArrayList<Node>();
    int grau;

    public Node(int value) {
        this.value=value;
    }

    public int getNivel() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public void printChildren() {
        System.out.print("filhos (");
        for (int i = 0; i < this.getChildren().size(); i++) {
            System.out.print(this.getChildren().get(i).getValue());
            if (i < this.getChildren().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(")  ");
    }

    public boolean isFolha() {
        if (this.children.size() == 0) {
            return true;
        }
        return false;
    }

    public String print() {
        StringBuilder buffer = new StringBuilder(50);
        printAux(buffer, "", "");
        return buffer.toString();
    }

    private void printAux(StringBuilder builder, String text, String childrenPrefix) {
        builder.append(text);
        builder.append(this.value);
        builder.append("\n");
        for (Iterator<Node> it = this.children.iterator(); it.hasNext();) {
            Node next = it.next();
            if (it.hasNext()) {
                next.printAux(builder, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.printAux(builder, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

}
