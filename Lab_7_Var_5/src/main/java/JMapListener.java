import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JMapListener implements MouseListener {
    private boolean modifying;

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    public void mousePressed(MouseEvent e) {
        modifying = true;
        JMap map = (JMap) e.getSource();
        map.setBlock();
    }

    public void mouseReleased(MouseEvent e) {
        modifying = false;
    }

    public void mouseEntered(MouseEvent e) {
        if (modifying) {
            JMap map = (JMap) e.getSource();
            map.setBlock();
        }
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
