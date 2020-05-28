package cham;

import java.util.HashMap;
import java.util.Set;

/**
 * Класс реализации направленного граффа, где хранятся веса путей
 * до каждой точки от заданной и информация о взвешанном граффе
 *
 * connections хранит информацию о взвешенном граффе,
 * где хварится имя узла и вся информацию о его связях с другими узлами
 *
 * way хранит информацию о наименьшем весе пути от заданной точки(с весом 0) до всех остальных точек граффа
 */

public class Nodes {

    HashMap<String, Connections> connections = new HashMap<>();
    HashMap<String, Integer> way = new HashMap<>();

    // Добавление нового узла
    public void addConnection(String nodeName, int weight, String endNode){
        // Проверяет наличие информации об этом узле
        // Если есть, то дописывает данные связи
        if(this.connections.containsKey(nodeName)){
            Connections connect = connections.get(nodeName);
            connect.setConnections(endNode, weight);

        // Если нету, то создает новую
        }else{
            Connections connect = new Connections();
            connect.setConnections(endNode, weight);
            this.connections.put(nodeName, connect);
        }
    }

    // Возвращение веса пути
    public HashMap<String, Integer> getWay() {
        return way;
    }

    // Метод начала работы вычисления весов путей
    public void calculate(String startNode){
        this.way.put(startNode, 0);
        sumWeight(startNode);
    }

    // Добавление веса пути
    // true - если вес добавлен или изменен
    // false - если не добавлен
    private boolean addWay(String nodeName, int weightWay){
        // Если такая запись есть, то получаетм вес, сравниваем и добавляем если меньше имеющегося
        if(this.way.containsKey(nodeName)){
            int weight = this.way.get(nodeName);

            if(weight > weightWay) {
                this.way.put(nodeName, weightWay);
                return true;
            }

            // Если такой записи нет - создаем
        }else {
            this.way.put(nodeName, weightWay);
            return true;
        }

        return false;
    }

    // Рекурсивная проверка весов граффа
    private void sumWeight(String sumNode){
        // Получение и проверка всех связей
        Connections connect = connections.get(sumNode);
        if(connect == null)
            return;

        // Получение и проверка ребер граффа из этой точки
        Set<String> nodes = connect.getEndNodes();
        if(nodes.isEmpty())
            return;

        // Получение веса пути до заданного узла
        int weight = way.get(sumNode);

        // Проход по всем узлам
        for(String node: nodes)
            if (addWay(node, weight + connect.getWeight(node))) {
                sumWeight(node);
            }
    }
}
