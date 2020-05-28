package cham;

import java.util.HashMap;
import java.util.Set;

public class Connections {

    HashMap<String, Integer> connections = new HashMap<>();

    // Добавляет новую связь
   public void setConnections(String endNode, int weight){
        connections.put(endNode, weight);
    }

    // Возвращает все конечные узлы ребер
    public Set<String> getEndNodes(){
        return connections.keySet();
    }

    // Возвращает вес ребра до конечного узла
    public int getWeight(String nameNode){
        return connections.get(nameNode);
    }

}
