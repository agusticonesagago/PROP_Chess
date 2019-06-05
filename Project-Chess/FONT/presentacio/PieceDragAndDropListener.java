package presentacio;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PieceDragAndDropListener implements MouseListener, MouseMotionListener {

    private chessboardPanel chessboard;

    private int originRow;
    private int originCol;

    public PieceDragAndDropListener(chessboardPanel cB) {
        chessboard = cB;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        originRow = calculateFile(e);
        originCol = calculateRank(e);
        if (chessboard.hasMainFrame() && chessboard.canPlay()) {
            if (chessboard.checkClick(originCol, originRow)) { // Comprova si es tracta de moviment o de demanar moviments d'una peca
                // Mirar moviments D'una Peca
                if (chessboard.checkMyPiece(originCol, originRow)) { // Mira si la peca es meva
                    chessboard.ajudaMov(originCol, originRow);
                }
            } else {
                // Fer Moviment si aquest es vàlid
                if (chessboard.checkMove(originCol, originRow).isEmpty()) {
                    chessboard.makeMove(originCol, originRow);
                } else {
                    chessboard.badMoveUpdate(chessboard.checkMove(originCol, originRow));
                }
            }
        }
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

    private int calculateFile(MouseEvent e) {
        return e.getPoint().x / 80;
    }

    private int calculateRank(MouseEvent e) {
        return e.getPoint().y / 80;
    }

}
