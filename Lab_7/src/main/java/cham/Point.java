package cham;

public class Point {

    private Location oldPoint;
    private int weight;

    public Point(Location oldPoint, int weight){
        this.oldPoint = oldPoint;
        this.weight = weight;
    }

    public Location getOldPoint() {
        return oldPoint;
    }

    public int getWeight() {
        return weight;
    }
}
