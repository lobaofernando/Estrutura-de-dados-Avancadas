package GenericTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Node {

    String name;
    ArrayList<Node> children = new ArrayList<Node>();

    public Node(String name) {
        this.name=name;
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


}
