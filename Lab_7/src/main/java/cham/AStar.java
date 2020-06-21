package cham;


public class AStar extends Algorithm {

    // Метод запуска поиска пути
    public void findPath(Location start, Location end, JMap[][] map){
        int height = map.length;
        int width = map.length;
        Map2D maps = new Map2D(width, height);
        maps.setStart(start);
        maps.setFinish(end);

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (!map[x][y].isBlock())
                    maps.setCellValue(x, y, 0);
                else
                    maps.setCellValue(x, y, Integer.MAX_VALUE);
            }
        }

        Waypoint wp = AStarPathfinder.computePath(maps);

        while (wp != null)
        {
            Location loc = wp.getLocation();
            map[loc.xCoord][loc.yCoord].setPath();

            wp = wp.getPrevious();
        }

        map[start.xCoord][start.yCoord].setStart();
        map[end.xCoord][end.yCoord].setEnd();
    }

    @Override
    public String toString() {
        return "Алгоримт А*";
    }

    @Override
    public void clean() {

    }


}
