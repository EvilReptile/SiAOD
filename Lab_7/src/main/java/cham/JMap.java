package cham;

import javax.swing.*;
import java.awt.*;

/**
 * Класс отображения ячейки сетки для отображения работы алгоритма поиска пути
 */
public class JMap extends JComponent {

    private static final Dimension CELL_SIZE = new Dimension(12, 12);

    private boolean block = false;

    public JMap(){
        setPreferredSize(CELL_SIZE);
        setBackground(Color.WHITE);
    }

    // Эта ячейка является путем
    public void setPath(){
        setBackground(Color.CYAN);
    }

    // Эта ячейка была проверена алгоритмом
    public void setVisited(){
        setBackground(Color.YELLOW);
    }

    // Эта ячейка является стартом
    public void setStart(){
        setBackground(Color.GREEN);
    }

    // Эта ячейка является финишем
    public void setEnd(){
        setBackground(Color.RED);
    }

    // Эта ячейка является преградой
    public void setBlock(){
        if(block)
            setBackground(Color.WHITE);
        else
            setBackground(Color.BLACK);

        block = !block;
    }

    // Очищение ячейки
    public void clean(){
        setBackground(Color.WHITE);
    }

    // Проверка на наличие препятствия
    public boolean isBlock(){
        if(getBackground().equals(Color.BLACK))
            return true;
        else
            return false;
    }

    // Отрисовка ячейки
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
