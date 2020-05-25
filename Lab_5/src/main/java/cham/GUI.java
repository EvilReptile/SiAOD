package cham;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JImage image;
    int howMuch = 0;

    public GUI(Dimension dim){
        setSize(dim);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        image = new JImage(dim.width);

        add(image);
    }

    public void drawFractal(int iteration){
        image.scales(iteration);
        sierpTop(iteration);
        image.drawLineRightTop();
        sierpRight(iteration);
        image.drawLineRightBottom();
        sierpBottom(iteration);
        image.drawLineLeftBottom();
        sierpLeft(iteration);
        image.drawLineLeftTop();

        System.out.println(howMuch);
    }

    private void sierpTop(int iteration){
        howMuch++;
        if(iteration > 1){
            sierpTop(iteration - 1);
            image.drawLineRightTop();
            sierpRight(iteration - 1);
            image.drawLineTop();
            sierpLeft(iteration - 1);
            image.drawLineLeftTop();
            sierpTop(iteration - 1);
        }else {
            image.drawCurveTop();
        }
    }

    private void sierpRight(int iteration){
        howMuch++;
        if(iteration > 1){
            sierpRight(iteration - 1);
            image.drawLineRightBottom();
            sierpBottom(iteration - 1);
            image.drawLineRight();
            sierpTop(iteration - 1);
            image.drawLineRightTop();
            sierpRight(iteration - 1);
        }else{
            image.drawCurveRight();
        }
    }

    private void sierpBottom(int iteration){
        howMuch++;
        if(iteration > 1){
            sierpBottom(iteration - 1);
            image.drawLineLeftBottom();
            sierpLeft(iteration - 1);
            image.drawLineBottom();
            sierpRight(iteration - 1);
            image.drawLineRightBottom();
            sierpBottom(iteration - 1);
        }else{
            image.drawCurveBottom();
        }
    }

    private void sierpLeft(int iteration){
        howMuch++;
        if(iteration > 1){
            sierpLeft(iteration - 1);
            image.drawLineLeftTop();
            sierpTop(iteration - 1);
            image.drawLineLeft();
            sierpBottom(iteration - 1);
            image.drawLineLeftBottom();
            sierpLeft(iteration - 1);
        }else{
            image.drawCurveLeft();
        }
    }

}
