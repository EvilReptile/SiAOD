package cham;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Алгоритм поиска кратчайшего пути в граффе
 */
public class Dijkstra {

    // Вычисление кратчайшего расстояния до точки
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        HashSet<Node> settledNodes = new HashSet<>();
        HashSet<Node> unsettledNodes = new HashSet<>();

        source.setDistance(0);
        unsettledNodes.add(source);

        // Перебор непроверенных узлов
        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            // Цикл перебора смежных пар узлов
            for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                // Если точка не найдена в непроверенных узлах
                if (!settledNodes.contains(adjacentNode)) {
                    сalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            // Добавление точки в проверенные
            settledNodes.add(currentNode);
        }

        return graph;
    }

    // Сравнение найденного кратчайшего расстояния с уже сохраненным
    private static void сalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();

        // Если уже найденное расстояние с расстоянием ребра меньше дистанции до узла
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);

            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);

            evaluationNode.setShortestPath(shortestPath);
        }
    }

    // Возвращает самое коротное расстояние для нода
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        // Перебор точек в списке непроверенных
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();

            // Если расстояния нода меньше наименьшего расстояния
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }

        return lowestDistanceNode;
    }
}