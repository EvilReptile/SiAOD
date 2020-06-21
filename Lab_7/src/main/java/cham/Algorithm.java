package cham;

public abstract class Algorithm {

    // Метод запуска поиска пути
    public abstract void findPath(Location start, Location end, JMap[][] map);
    //Метод получения названия алгоритма
    public abstract String toString();
    // Метод очистки поля
    public abstract void clean();
}
