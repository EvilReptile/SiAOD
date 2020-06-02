package cham;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

    /**
     * Матрица смежности заполняется по принципу:
     * Слева находится узел из которого идут пути, сверху находятся узлы, куда идут пути
     *
     * Составляется таблица смежности без названия вершин.
     * Необходимо указать вес перехода между вершинами в таблице через запятую,
     * если перехода нет указывать ноль
     */
    public static void main( String[] args ) throws IOException {
        File file = new File("test.txt");
        if (!file.isFile()) {
            System.out.println("Ошибка при открытии файла");
            return;
        }

        FileInputStream fin = new FileInputStream(file);
        String buf = "";
        int i = -1;

        while ((i = fin.read()) != -1)
            buf += (char) i;

        if (buf.length() == 0)
            return;

        String[] commands = buf.split("\n");
        Node[] nodeArray = new Node[commands.length];

        // Создание объектов узлов
        for (i = 0; i < nodeArray.length; i++)
            nodeArray[i] = new Node("" + i);


        // Перебор команд в строках матрицы смежности
        for (i = 0; i < commands.length; i++) {
            String[] com = commands[i].split(",");
            for (int j = 0; j < com.length; j++)
                if (!com[j].equals("0"))
                    nodeArray[i].addDestination(nodeArray[j], Integer.parseInt(com[j]));
        }

        Graph graph = new Graph();

        for (Node node : nodeArray)
            graph.addNode(node);

        // На вход подается графф с начальной точкой
        Dijkstra.calculateShortestPathFromSource(graph, nodeArray[0]);

        for (Node node : graph.getNodes()) {
            System.out.print("Путь до точки проходит через: ");
            for (Node n : node.getShortestPath())
                System.out.print(n.getName() + "->");

            System.out.println(node.getName());
            System.out.println("Расстояние до точки равно: " + node.getDistance());
            System.out.println();
        }
    }
}
