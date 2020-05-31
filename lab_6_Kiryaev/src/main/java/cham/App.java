package cham;

public class App {
    public static void main( String[] args ) {
        Graph graph = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);
        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);
        nodeC.addDestination(nodeE, 10);
        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);
        nodeF.addDestination(nodeE, 5);

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        // На вход подается графф с начальной точкой
        Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        for(Node node: graph.getNodes()){
            System.out.print("Путь до точки проходит через: ");
            for(Node n: node.getShortestPath())
                System.out.print(n.getName() + "->");

            System.out.println(node.getName());
            System.out.println("Расстояние до точки равно: " + node.getDistance());
            System.out.println();
        }
    }
}
