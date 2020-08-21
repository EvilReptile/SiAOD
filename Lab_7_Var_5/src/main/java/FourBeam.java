import java.util.ArrayList;

public class FourBeam extends Algorithm {

    private ArrayList<Location> topStart = new ArrayList<>();
    private ArrayList<Location> rightStart = new ArrayList<>();
    private ArrayList<Location> bottomStart = new ArrayList<>();
    private ArrayList<Location> leftStart = new ArrayList<>();

    private ArrayList<Location> topEnd = new ArrayList<>();
    private ArrayList<Location> rightEnd = new ArrayList<>();
    private ArrayList<Location> bottomEnd = new ArrayList<>();
    private ArrayList<Location> leftEnd = new ArrayList<>();

    private JMap[][] map;
    private Location start;
    private Location end;

    @Override
    public void findPath(Location start, Location end, JMap[][] map) {
        this.map = map;
        this.start = start;
        this.end = end;

        topStart.add(start);
        rightStart.add(start);
        bottomStart.add(start);
        leftStart.add(start);
        topEnd.add(end);
        rightEnd.add(end);
        bottomEnd.add(end);
        leftEnd.add(end);

        nextFind();
    }

    @Override
    public String toString() {
        return "Четырехлучевой алгоритм";
    }

    @Override
    public void clean(){
        topStart = new ArrayList<>();
        rightStart = new ArrayList<>();
        bottomStart = new ArrayList<>();
        leftStart = new ArrayList<>();
        topEnd = new ArrayList<>();
        rightEnd = new ArrayList<>();
        bottomEnd = new ArrayList<>();
        leftEnd = new ArrayList<>();
    }

    private void nextFind(){
        Boolean find = true;
        Location loc;
        while(find) {
            find = false;
            loc = topStart.get(topStart.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord][loc.yCoord - 1].isBlock()) {
                    find = true;
                    topStart.add(new Location(loc.xCoord, loc.yCoord - 1));
                    if (bottomEnd.indexOf(topStart.get(topStart.size() - 1)) != -1) {
                        drawLines(topStart.get(topStart.size() - 1));
                        return;
                    }
                    if (leftEnd.indexOf(topStart.get(topStart.size() - 1)) != -1) {
                        drawLines(topStart.get(topStart.size() - 1));
                        return;
                    }
                    if (rightEnd.indexOf(topStart.get(topStart.size() - 1)) != -1) {
                        drawLines(topStart.get(topStart.size() - 1));
                        return;
                    }
                }
            }

            loc = rightStart.get(rightStart.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord + 1][loc.yCoord].isBlock()) {
                    find = true;
                    rightStart.add(new Location(loc.xCoord + 1, loc.yCoord));
                    if (topEnd.indexOf(rightStart.get(rightStart.size() - 1)) != -1) {
                        drawLines(rightStart.get(rightStart.size() - 1));
                        return;
                    }
                    if (leftEnd.indexOf(rightStart.get(rightStart.size() - 1)) != -1) {
                        drawLines(rightStart.get(rightStart.size() - 1));
                        return;
                    }
                    if (bottomEnd.indexOf(rightStart.get(rightStart.size() - 1)) != -1) {
                        drawLines(rightStart.get(rightStart.size() - 1));
                        return;
                    }
                }
            }

            loc = bottomStart.get(bottomStart.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord][loc.yCoord + 1].isBlock()) {
                    find = true;
                    bottomStart.add(new Location(loc.xCoord, loc.yCoord + 1));
                    if (topEnd.indexOf(bottomStart.get(bottomStart.size() - 1)) != -1) {
                        drawLines(bottomStart.get(bottomStart.size() - 1));
                        return;
                    }
                    if (leftEnd.indexOf(bottomStart.get(bottomStart.size() - 1)) != -1) {
                        drawLines(bottomStart.get(bottomStart.size() - 1));
                        return;
                    }
                    if (rightEnd.indexOf(bottomStart.get(bottomStart.size() - 1)) != -1) {
                        drawLines(bottomStart.get(bottomStart.size() - 1));
                        return;
                    }
                }
            }

            loc = leftStart.get(leftStart.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord - 1][loc.yCoord].isBlock()) {
                    find = true;
                    leftStart.add(new Location(loc.xCoord - 1, loc.yCoord));
                    if (topEnd.indexOf(leftStart.get(leftStart.size() - 1)) != -1) {
                        drawLines(leftStart.get(leftStart.size() - 1));
                        return;
                    }
                    if (bottomEnd.indexOf(leftStart.get(leftStart.size() - 1)) != -1) {
                        drawLines(leftStart.get(leftStart.size() - 1));
                        return;
                    }
                    if (rightEnd.indexOf(leftStart.get(leftStart.size() - 1)) != -1) {
                        drawLines(leftStart.get(leftStart.size() - 1));
                        return;
                    }
                }
            }

            loc = topEnd.get(topEnd.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord][loc.yCoord - 1].isBlock()) {
                    find = true;
                    topEnd.add(new Location(loc.xCoord, loc.yCoord - 1));
                    if (bottomStart.indexOf(topEnd.get(topEnd.size() - 1)) != -1) {
                        drawLines(topEnd.get(topEnd.size() - 1));
                        return;
                    }
                    if (leftStart.indexOf(topEnd.get(topEnd.size() - 1)) != -1) {
                        drawLines(topEnd.get(topEnd.size() - 1));
                        return;
                    }
                    if (rightStart.indexOf(topEnd.get(topEnd.size() - 1)) != -1) {
                        drawLines(topEnd.get(topEnd.size() - 1));
                        return;
                    }
                }
            }

            loc = rightEnd.get(rightEnd.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord + 1][loc.yCoord].isBlock()) {
                    find = true;
                    rightEnd.add(new Location(loc.xCoord + 1, loc.yCoord));
                    if (topStart.indexOf(rightEnd.get(rightEnd.size() - 1)) != -1) {
                        drawLines(rightEnd.get(rightEnd.size() - 1));
                        return;
                    }
                    if (leftStart.indexOf(rightEnd.get(rightEnd.size() - 1)) != -1) {
                        drawLines(rightEnd.get(rightEnd.size() - 1));
                        return;
                    }
                    if (bottomStart.indexOf(rightEnd.get(rightEnd.size() - 1)) != -1) {
                        drawLines(rightEnd.get(rightEnd.size() - 1));
                        return;
                    }
                }
            }

            loc = bottomEnd.get(bottomEnd.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord][loc.yCoord + 1].isBlock()) {
                    find = true;
                    bottomEnd.add(new Location(loc.xCoord, loc.yCoord + 1));
                    if (topStart.indexOf(bottomEnd.get(bottomEnd.size() - 1)) != -1) {
                        drawLines(bottomEnd.get(bottomEnd.size() - 1));
                        return;
                    }
                    if (leftStart.indexOf(bottomEnd.get(bottomEnd.size() - 1)) != -1) {
                        drawLines(bottomEnd.get(bottomEnd.size() - 1));
                        return;
                    }
                    if (rightStart.indexOf(bottomEnd.get(bottomEnd.size() - 1)) != -1) {
                        drawLines(bottomEnd.get(bottomEnd.size() - 1));
                        return;
                    }
                }
            }

            loc = leftEnd.get(leftEnd.size() - 1);
            if (loc.xCoord != 0 && loc.yCoord != 0 && loc.xCoord != map.length - 1 && loc.yCoord != map[0].length - 1) {
                if (!map[loc.xCoord - 1][loc.yCoord].isBlock()) {
                    find = true;
                    leftEnd.add(new Location(loc.xCoord - 1, loc.yCoord));
                    if (topStart.indexOf(leftEnd.get(leftEnd.size() - 1)) != -1) {
                        drawLines(leftEnd.get(leftEnd.size() - 1));
                        return;
                    }
                    if (bottomStart.indexOf(leftEnd.get(leftEnd.size() - 1)) != -1) {
                        drawLines(leftEnd.get(leftEnd.size() - 1));
                        return;
                    }
                    if (rightStart.indexOf(leftEnd.get(leftEnd.size() - 1)) != -1) {
                        drawLines(leftEnd.get(leftEnd.size() - 1));
                        return;
                    }
                }
            }
        }
        drawVisited();
    }

    private void drawLines(Location medium){
        drawVisited();
        if(start.xCoord > medium.xCoord)
            for(int x = start.xCoord - 1; x > medium.xCoord; x--)
                map[x][medium.yCoord].setPath();
        else if(start.xCoord < medium.xCoord)
            for(int x = start.xCoord + 1; x < medium.xCoord; x++)
                map[x][medium.yCoord].setPath();
        else if(start.yCoord > medium.yCoord)
            for(int y = start.yCoord - 1; y > medium.xCoord; y--)
                map[start.xCoord][y].setPath();
        else if(start.yCoord < medium.yCoord)
            for(int y = start.yCoord + 1; y < medium.xCoord; y++)
                map[start.xCoord][y].setPath();

        if(medium.xCoord > end.xCoord)
            for(int x = medium.xCoord; x > end.xCoord; x--)
                map[x][medium.yCoord].setPath();
        else if(medium.xCoord < end.xCoord)
            for(int x = medium.xCoord; x < end.xCoord; x++)
                map[x][medium.yCoord].setPath();
        else if(medium.yCoord > end.yCoord) {
            System.out.println("Горизонтальная линия вверх");
            for (int y = medium.yCoord; y > end.yCoord; y--)
                map[medium.xCoord][y].setPath();
        }
        else if(medium.yCoord < end.yCoord)
            for(int y = medium.yCoord; y < end.yCoord; y++)
                map[medium.xCoord][y].setPath();
    }

    private void drawVisited(){
        for(Location loc: topStart)
            map[loc.xCoord][loc.yCoord].setVisited();

        for(Location loc: rightStart)
            map[loc.xCoord][loc.yCoord].setVisited();

        for(Location loc: bottomStart)
            map[loc.xCoord][loc.yCoord].setVisited();

        for(Location loc: leftStart)
            map[loc.xCoord][loc.yCoord].setVisited();

        for(Location loc: topEnd)
            map[loc.xCoord][loc.yCoord].setVisited();

        for(Location loc: rightEnd)
            map[loc.xCoord][loc.yCoord].setVisited();

        for(Location loc: bottomEnd)
            map[loc.xCoord][loc.yCoord].setVisited();

        for(Location loc: leftEnd)
            map[loc.xCoord][loc.yCoord].setVisited();

        map[start.xCoord][start.yCoord].setStart();
        map[end.xCoord][end.yCoord].setEnd();
    }

}
