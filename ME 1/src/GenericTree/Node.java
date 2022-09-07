package GenericTree;

import java.util.ArrayList;

public class Node {

    String name;
    ArrayList<Node> children = new ArrayList<Node>();
    int grau;

    public Node(String name) {
        this.name=name;
    }

    public int getNivel() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public void printChildren() {
        System.out.print("filhos (");
        for (Node node : this.children) {
            System.out.print((String)node.getName() + ", ");
        }
        System.out.print(")  ");
    }

    public void getNodeAltura(int maxGrau) {
        System.out.print("altura " + Math.abs((this.getNivel() - maxGrau)));
    }

    public boolean isFolha() {
        if (this.children.size() == 0) {
            return true;
        }
        return false;
    }

}
