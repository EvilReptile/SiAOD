package cham;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImage extends JComponent {

    BufferedImage buffer_image;
    int edge;
    int diagonal;
    int x;
    int y;
    int color = 999999999;
    int size;

    public JImage(int size){
        // Создание буфера для отрисовки изображения
        buffer_image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        // Задание размера компонента
        this.setPreferredSize(new Dimension(size, size));

        this.size = size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(buffer_image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void scales(int iteration){
        // Вычисление приемлемых размеров диаголей и длин ребер
        diagonal = size / (howMuchDiag(iteration)  + howMuchEdge(iteration) * 2);
        edge = diagonal * 2 ;

        // Задание стартовых координат
        y = 0;
        x = diagonal;
    }

    // Очистка изображения
    public void clearImage(){
        for(int y = 0; y < buffer_image.getHeight(); y++) {
            for (int x = 0; x < buffer_image.getWidth(); x++) {
                buffer_image.setRGB(x, y, 0);
            }
        }
    }

    // Формула вычисления кол-ва диагоналей по ширине
    private int howMuchDiag(int iteration){
        if(iteration == 1){
            return 4;
        }else{
            return (howMuchDiag(iteration - 1) * 2);
        }
    }

    // Формула вычисления кол-ва прямых по ширине
    private int howMuchEdge(int iteration){
        if(iteration == 1){
            return 1;
        }else{
            return (howMuchEdge(iteration - 1) * 2 + 1);
        }
    }

    // Отрисовка верхней части фрактала
    // \_/
    public void drawCurveTop(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x + i, y + i, color);
        }
        y += diagonal;
        x += diagonal;

        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x + i, y, color);
        }
        x += edge;

        for(int i  = 0; i < diagonal; i++){
            buffer_image.setRGB(x + i, y - i, color);
        }
        x += diagonal;
        y -= diagonal;

    }

    // Отрисовка левой части фрактала
    // \
    //  |
    // /
    public void drawCurveLeft(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x + i, y - i, color);
        }
        x += diagonal;
        y -= diagonal;

        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x, y - i, color);
        }
        y -= edge;

        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x - i, y - i, color);
        }
        x -= diagonal;
        y -= diagonal;

    }

    // Отрисовка правой части фрактала
    //  /
    // |
    //  \
    public void drawCurveRight(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x - i, y + i, color);
        }
        x -= diagonal;
        y += diagonal;

        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x, y + i, color);
        }
        y += edge;

        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x + i, y + i, color);
        }
        x += diagonal;
        y += diagonal;
    }

    // Отрисовка нижней части фрактала
    //   _
    // /   \
    public void drawCurveBottom(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x - i, y - i, color);
        }
        y -= diagonal;
        x -= diagonal;

        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x - i, y, color);
        }
        x -= edge;

        for(int i  = 0; i < diagonal; i++){
            buffer_image.setRGB(x - i, y + i, color);
        }
        x -= diagonal;
        y += diagonal;
    }

    // Отрисовка правой верхней косой прямой фрактала
    public void drawLineRightTop(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x + i, y + i, color);
        }
        x += diagonal;
        y += diagonal;
    }

    // Отрисовка левой верхней косой прямой фрактала
    public void drawLineLeftTop(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x + i, y - i, color);
        }
        x += diagonal;
        y -= diagonal;
    }

    // Отрисовка правой нижней косой прямой фрактала
    public void drawLineRightBottom(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x - i, y + i, color);
        }
        x -= diagonal;
        y += diagonal;
    }

    // Отрисовка левой нижней косой прямой фрактала
    public void drawLineLeftBottom(){
        for(int i = 0; i < diagonal; i++){
            buffer_image.setRGB(x - i, y - i, color);
        }
        x -= diagonal;
        y -= diagonal;
    }

    // Отрисовка верхней прямой фрактала
    public void drawLineTop(){
        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x + i, y, color);
        }
        x += edge;
    }

    // Отрисовка правой прямой фрактала
    public void drawLineRight(){
        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x, y + i, color);
        }
        y += edge;
    }

    // Отрисовка нижней прямой фрактала
    public void drawLineBottom(){
        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x - i, y, color);
        }
        x -= edge;
    }

    // Отрисовка левой прямой фрактала
    public void drawLineLeft(){
        for(int i = 0; i < edge; i++){
            buffer_image.setRGB(x, y - i, color);
        }
        y -= edge;
    }
}
