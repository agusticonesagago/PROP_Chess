package presentacio;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PieceSelector implements MouseListener, MouseMotionListener {
    private int pressed;
    private PieceRowPanel panel;

    public PieceSelector(PieceRowPanel from){
        this.panel = from;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        pressed = calculateFile(e);
        this.panel.setToPain(pressed);
    }

    private int calculateFile(MouseEvent e) {
        return e.getPoint().x/ 80; // MAYBE CAL
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
