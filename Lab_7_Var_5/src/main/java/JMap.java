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

    public void setPath(){
        setBackground(Color.CYAN);
    }

    public void setVisited(){
        setBackground(Color.YELLOW);
    }

    public void setStart(){
        setBackground(Color.GREEN);
    }

    public void setEnd(){
        setBackground(Color.RED);
    }

    public void setBlock(){
        if(block)
            setBackground(Color.WHITE);
        else
            setBackground(Color.BLACK);

        block = !block;
    }

    public void clean(){
        setBackground(Color.WHITE);
    }

    public boolean isBlock(){
        if(getBackground().equals(Color.BLACK))
            return true;
        else
            return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
