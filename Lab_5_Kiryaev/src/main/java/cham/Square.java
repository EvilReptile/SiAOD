package cham;

import javax.swing.*;

public class Square {
    /*
    * На вход подаются координаты прямой основания квадрата и угол перпендикуляра к ней
    * После калькулируются оставшиеся координаты углов
    *
    * Расположение координат:
    *
    *   3_______2
    *   |       |
    *   |       |
    *   0_______1
    */
    // x1, x2, x3, x4
    int[] xPoints = new int[4];

    // y1, y2, y3, y4
    int[] yPoints = new int[4];

    int angle;

    public Square(int x1, int y1, int x2, int y2, int angle){
        xPoints[0] = x1;
        xPoints[1] = x2;

        yPoints[0] = y1;
        yPoints[1] = y2;

        this.angle = angle;

        calculateLine();
    }

    private void calculateLine(){
        // Определение координат вектора основания
        int xSize = xPoints[1] - xPoints[0];
        int ySize = yPoints[1] - yPoints[0];

        // Длинна вектора основания квадрата
        double size = Math.sqrt(xSize * xSize + ySize * ySize);

        // Получение коодринат вектора правого и левого ребра квадрата
        xSize = (int)(size * Math.cos(Math.toRadians(angle)));
        ySize = (int)(size * Math.sin(Math.toRadians(angle)));

        // Вычисление точек верхего ребра квадрата
        xPoints[2] = xPoints[1] + xSize;
        yPoints[2] = yPoints[1] - ySize;

        xPoints[3] = xPoints[0] + xSize;
        yPoints[3] = yPoints[0] - ySize;
    }

    public int[] xPoints(){
        return xPoints;
    }

    public int[] yPoints(){
        return yPoints;
    }

    public int scorePoints(){
        return xPoints.length;
    }

    public int[] getTopLine(){
        int[] line = new int[4];
        line[0] = xPoints[3];
        line[1] = yPoints[3];
        line[2] = xPoints[2];
        line[3] = yPoints[2];

        return line;
    }

    public int getAngle(){
        return angle;
    }
}
