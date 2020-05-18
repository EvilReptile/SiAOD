package cham;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    FractalImage image;

    public GUI(Dimension dim){
        setSize(dim);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        image = new FractalImage(dim);
        add(image);

        // Запуск отрисовки
        image.draw(8);
    }
}
