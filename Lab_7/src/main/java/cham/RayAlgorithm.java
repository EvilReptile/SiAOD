package cham;

import java.util.HashMap;

public class RayAlgorithm extends Algorithm {

    private HashMap<Location, Point> close_point = new HashMap<>();

    private JMap[][] map;

    private Location start;
    private Location end;

    @Override
    public void findPath(Location start, Location end, JMap[][] map) {
        this.map = map;
        this.start = start;
        this.end = end;
        findNextPoint(start, end);
    }

    @Override
    public String toString() {
        return "Ортогонально-диагональный лучевой алгоритм";
    }

    // Алгоримт поиска следующей точки пути
    private void findNextPoint(Location location, Location end){
        // Получение векторных координат оставшегося пути
        int dx = end.xCoord - location.xCoord;
        int dy = end.yCoord - location.yCoord;
        // Получение коэффициента прямой
        double k;
        if(dx == 0)
            k = dy;
        else if(dy == 0)
            k = 0;
        else
            k = dy/dx;

        // Если конечная точка найдена внизу
        if(k >= 0.75){
            Location newLoc;
            if(map[location.xCoord][location.yCoord + 1].isBlock())
                newLoc = newLocation(location);
            else
                newLoc = new Location(location.xCoord, location.yCoord + 1);

            if(newLoc != null)
                if(newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                    setClosePoint(newLoc, new Point(location, 0));
                    map[newLoc.xCoord][newLoc.yCoord].setPath();
                    findNextPoint(newLoc, end);
                }else
                    return;
            else
                return;
        }

        // Если конечная точка найдена слева или справа снизу
        if(k <= 0.75 && k > 0.25){
            // Если точка слева
            if(dx < 0){
                Location newLoc;

                if(map[location.xCoord - 1][location.yCoord + 1].isBlock())
                    newLoc = newLocation(location);
                else
                    newLoc = new Location(location.xCoord - 1, location.yCoord + 1);

                if(newLoc != null)
                    if(newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                        setClosePoint(newLoc, new Point(location, 0));
                        map[newLoc.xCoord][newLoc.yCoord].setPath();
                        findNextPoint(newLoc, end);
                    }else
                        return;
                else
                    return;

            // Если точка справа
            }else if(dx > 0){
                Location newLoc;

                if(map[location.xCoord + 1][location.yCoord + 1].isBlock())
                    newLoc = newLocation(location);
                else
                    newLoc = new Location(location.xCoord + 1, location.yCoord + 1);

                if(newLoc != null)
                    if(newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                        setClosePoint(newLoc, new Point(location, 0));
                        map[newLoc.xCoord][newLoc.yCoord].setPath();
                        findNextPoint(newLoc, end);
                    }else
                        return;
                else
                    return;
            }
        }

        // Если конечная точка найдена слева или справа
        if(k <= 0.25 && k >= -0.25){
            //Если точка слева
            if(dx < 0){
                Location newLoc;

                if(map[location.xCoord - 1][location.yCoord].isBlock())
                    newLoc = newLocation(location);
                else
                    newLoc = new Location(location.xCoord - 1, location.yCoord);

                if(newLoc != null)
                    if(newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                        setClosePoint(newLoc, new Point(location, 0));
                        map[newLoc.xCoord][newLoc.yCoord].setPath();
                        findNextPoint(newLoc, end);
                    }else
                        return;
                else
                    return;

            // Если точка справа
            }else if(dx > 0){
                Location newLoc;

                if(map[location.xCoord + 1][location.yCoord].isBlock())
                    newLoc = newLocation(location);
                else
                    newLoc = new Location(location.xCoord + 1, location.yCoord);

                if(newLoc != null)
                    if(newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                        setClosePoint(newLoc, new Point(location, 0));
                        map[newLoc.xCoord][newLoc.yCoord].setPath();
                        findNextPoint(newLoc, end);
                    }else
                        return;
                else
                    return;
            }
        }

        // Если конечная точка найдена слева или справа сверху
        if(k < -0.25 && k > -0.75 ){
            // Если точка слева
            if(dx < 0){
                Location newLoc;

                if(map[location.xCoord - 1][location.yCoord - 1].isBlock())
                    newLoc = newLocation(location);
                else
                    newLoc = new Location(location.xCoord - 1, location.yCoord - 1);

                if(newLoc != null)
                    if(newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                        setClosePoint(newLoc, new Point(location, 0));
                        map[newLoc.xCoord][newLoc.yCoord].setPath();
                        findNextPoint(newLoc, end);
                    }else
                        return;
                else
                    return;

            // Если точка справа
            }else if(dx > 0) {
                Location newLoc;

                if (map[location.xCoord + 1][location.yCoord - 1].isBlock())
                    newLoc = newLocation(location);
                else
                    newLoc = new Location(location.xCoord + 1, location.yCoord - 1);

                if (newLoc != null)
                    if (newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                        setClosePoint(newLoc, new Point(location, 0));
                        map[newLoc.xCoord][newLoc.yCoord].setPath();
                        findNextPoint(newLoc, end);
                    } else
                        return;
                 else
                    return;
            }
        }

        // Если конечная точка найдена сверху
        if(k <= -0.75){
            Location newLoc;
            if(map[location.xCoord][location.yCoord - 1].isBlock())
                newLoc = newLocation(location);
            else
                newLoc = new Location(location.xCoord, location.yCoord - 1);

            if(newLoc != null)
                if(newLoc.hashCode() != end.hashCode() && !isClosePoint(newLoc)) {
                    setClosePoint(newLoc, new Point(location, 0));
                    map[newLoc.xCoord][newLoc.yCoord].setPath();
                    findNextPoint(newLoc, end);
                }else
                    return;
            else
                return;
        }
    }

    // Метод поиска свободной точки рядом
    private Location newLocation(Location location){
        if(location.xCoord == map.length - 1 || location.yCoord == map.length -1)
            return null;

        if(!map[location.xCoord + 1][location.yCoord].isBlock())
            return new Location(location.xCoord + 1, location.yCoord);

        if(!map[location.xCoord + 1][location.yCoord + 1].isBlock())
            return new Location(location.xCoord + 1, location.yCoord + 1);

        if(!map[location.xCoord][location.yCoord + 1].isBlock())
            return new Location(location.xCoord, location.yCoord + 1);

        if(!map[location.xCoord - 1][location.yCoord + 1].isBlock())
            return new Location(location.xCoord - 1, location.yCoord + 1);

        if(!map[location.xCoord - 1][location.yCoord].isBlock())
            return new Location(location.xCoord - 1, location.yCoord);

        if(!map[location.xCoord - 1][location.yCoord - 1].isBlock())
            return new Location(location.xCoord - 1, location.yCoord - 1);

        if(!map[location.xCoord][location.yCoord - 1].isBlock())
            return new Location(location.xCoord, location.yCoord - 1);

        return null;
    }

    // Метод добавления точки в список закрытых
    private void setClosePoint(Location location, Point point){
        close_point.put(location, point);
    }

    // Проверка точки в списке закрытых
    private boolean isClosePoint(Location location){
        return close_point.get(location) != null;
    }

    // Метод очистки списка закрытых точек
    @Override
    public void clean(){
        close_point = new HashMap<>();
    }

}
