package cham;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс реализации граффа
 * Хранит точки граффа и связи в нем
 */
public class Graph {

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }
}
