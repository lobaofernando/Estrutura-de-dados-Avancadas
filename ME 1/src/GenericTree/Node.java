package GenericTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Node {

    String name;
    ArrayList<Node> children = new ArrayList<Node>();
    int grau;

    public Node(String name) {
        this.name=name;
    }

    public int getGrau() {
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
        children.add(node);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public boolean isFolha() {
        if (this.children.size() == 0) {
            return true;
        }
        return false;
    }

}
