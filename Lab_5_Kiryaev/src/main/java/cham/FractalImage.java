package cham;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FractalImage extends JComponent {

    BufferedImage buffer_image;
    Graphics2D graphics2D;

    Dimension dim;

    public FractalImage(Dimension dim){
        setPreferredSize(dim);
        buffer_image = new BufferedImage((int)dim.getWidth(), (int)dim.getHeight(), BufferedImage.TYPE_INT_RGB);
        graphics2D = (Graphics2D) buffer_image.getGraphics();
        this.dim = dim;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(buffer_image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void draw(int iteration){
        // Задание стандартного цвета
        graphics2D.setColor(Color.white);

        // Вычисление точек основания стартового квадрата
        int score = dim.height / 6;
        int x1 = (int)(score * 2.5);
        int y1 = dim.height - 1;
        int x2 = (int)(score * 3.5);
        int y2 = dim.height - 1;

        // Создание и отрисовка стартового квадрата
        Square square = new Square(x1, y1, x2, y2, 90);
        graphics2D.fillPolygon(square.xPoints(), square.yPoints(), square.scorePoints());

        // Запуск рекурсии
        drawFractal(iteration, square.getTopLine(), square.getAngle());
    }

    public void drawFractal(int iteration, int[] line, int angle){
        if(iteration > 0){
            //Вычисление координат вектора основания
            int xSize = line[2] - line[0];
            int ySize = line[3] - line[1];

            // Вычисление длинны основания треугольника
            double size = Math.sqrt(xSize * xSize + ySize * ySize);

            // Вычисление длинны вектора от точки основания до точки вершины
            double vector = Math.sqrt(size * size / 2);

            // Вычисление координаты вершины равнобедренного треугольника
            int x = line[0] + (int)(vector * Math.cos(Math.toRadians(angle - 45)));
            int y = line[1] - (int)(vector * Math.sin(Math.toRadians(angle - 45)));

            // Создание квадратов
            Square sqrRight = new Square(line[0], line[1], x, y, angle + 45);
            Square sqrLeft = new Square(x, y, line[2], line[3], angle - 45);

            // Отрисовка квадратов
            graphics2D.fillPolygon(sqrRight.xPoints(), sqrRight.yPoints(), sqrRight.scorePoints());
            graphics2D.fillPolygon(sqrLeft.xPoints(), sqrLeft.yPoints(), sqrLeft.scorePoints());

            // Левая часть фрактала
            drawFractal(iteration - 1, sqrLeft.getTopLine(), sqrLeft.getAngle());

            // Правая часть фрактала
            drawFractal(iteration - 1, sqrRight.getTopLine(), sqrRight.getAngle());
        }
    }
}
