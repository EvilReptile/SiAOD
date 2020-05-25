package cham;

import java.awt.*;

public class App {

    public static void main( String[] args ) {
        GUI gui = new GUI(new Dimension(1000, 1000));
        long start;
        long end;

        gui.drawFractal(2);

        gui.image.clearImage();

        start = System.nanoTime();
        gui.drawFractal(2);
        end = System.nanoTime();

        gui.image.clearImage();
        System.out.println("Время работы алгоритма на 2 итерациях: " + (end - start));

        start = System.nanoTime();
        gui.drawFractal(3);
        end = System.nanoTime();

        gui.image.clearImage();
        System.out.println("Время работы алгоритма на 3 итерациях: " + (end - start));

        start = System.nanoTime();
        gui.drawFractal(4);
        end = System.nanoTime();

        gui.image.clearImage();
        System.out.println("Время работы алгоритма на 4 итерациях: " + (end - start));

        start = System.nanoTime();
        gui.drawFractal(5);
        end = System.nanoTime();
        System.out.println("Время работы алгоритма на 5 итерациях: " + (end - start));
    }
}

