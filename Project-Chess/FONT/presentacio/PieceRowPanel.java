package presentacio;

import javax.swing.*;
import java.awt.*;

public class PieceRowPanel extends JPanel {
    private JPanel rowPanel;
    private JPanel[] rowPanels;
    private JLayeredPane rowLayeredPane;
    private chessboardPanel chessboard;

    private boolean color;

    public PieceRowPanel (boolean color, chessboardPanel c) {
        super(new BorderLayout());
        this.chessboard = c;
        this.color = color;
        initializeRowLayeredPane();
        initializeSquares();
        initializePieces();
    }

    private void initializePieces() {
        for(int i=0; i<6; ++i) {
            rowPanels[i].add(getPieceImg(i));
        }
    }

    private JLabel getPieceImg(int i) {
        String filename = "";
        switch (i){
            case 0: //
                if (color){
                    filename = "/img/wb.png";
                } else {
                    filename = "/img/bb.png";
                }
            break;
            case 1:
                if (color){
                    filename = "/img/wk.png";
                } else {
                    filename = "/img/bk.png";
                }
                break;
            case 2:
                if (color){
                    filename = "/img/wn.png";
                } else {
                    filename = "/img/bn.png";
                }
                break;
            case 3:
                if (color){
                    filename = "/img/wp.png";
                } else {
                    filename = "/img/bp.png";
                }
                break;
            case 4:
                if (color){
                    filename = "/img/wq.png";
                } else {
                    filename = "/img/bq.png";
                }
                break;
            case 5:
                if (color){
                    filename = "/img/wr.png";
                } else {
                    filename = "/img/br.png";
                }
                break;
        }
        Image pieceImage = new ImageIcon(getClass().getResource(filename)).getImage();
        pieceImage = pieceImage.getScaledInstance(80,80, Image.SCALE_SMOOTH);
        JLabel pieceImageLabel = new JLabel(new ImageIcon(pieceImage));
        return pieceImageLabel;
    }

    private void initializeRowLayeredPane() {
        rowPanel = new JPanel(new GridLayout(1,6));
        rowPanel.setBounds(0,0,480, 80);
        rowLayeredPane = new JLayeredPane();
        rowLayeredPane.setPreferredSize(new Dimension(480,80));
        rowLayeredPane.add(rowPanel, JLayeredPane.DEFAULT_LAYER);
        PieceSelector pDandDList = new PieceSelector(this);
        rowLayeredPane.addMouseListener(pDandDList);
        rowLayeredPane.addMouseMotionListener(pDandDList);
        this.add(rowLayeredPane, BorderLayout.CENTER);
    }

    private void initializeSquares() {
        rowPanels = new JPanel[6];
        for(int i=0; i<6; ++i) {
            rowPanels[i] = new JPanel(new GridLayout(1,1));
            rowPanels[i].setPreferredSize(new Dimension(80,80));
            rowPanels[i].setSize(new Dimension(80,80));
            if (i % 2 == 1){
                rowPanels[i].setBackground(Color.WHITE);
            } else {
                rowPanels[i].setBackground(Color.DARK_GRAY);
            }
            rowPanel.add(rowPanels[i]);
        }
    }


    public void setToPain(int pressed) {
        JLabel r = getPieceImg(pressed);
        chessboard.setPieceToPaint(r);
    }
}
