package presentacio;

import domini.CtrlDomini;
import domini.Partida;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class chessboardPanel extends JPanel implements Observer {


    private CtrlDomini cDom;
    private JugarPartida mainFrame;
    private Partida p;
    private JPanel[][] sqaurePanels;
    private JPanel boardPanel;
    private JLayeredPane boardLayeredPane;
    private ArrayList<Pair<Integer, Integer>> autoHelp;
    private Pair<Integer,Integer> origin;


    public chessboardPanel(CtrlDomini cDom, JugarPartida mainFrame){
        super(new BorderLayout());
        this.cDom = cDom;
        this.p = cDom.getPartida();
        this.autoHelp = null;
        this.mainFrame = mainFrame;
        this.origin = null;
        initializeBoardLayeredPane();
        initializeSquares();
        initializePieces();
    }

    private void initializeBoardLayeredPane() {
        boardPanel = new JPanel(new GridLayout(8,8));
        boardPanel.setBounds(0,0,640, 640);
        boardLayeredPane = new JLayeredPane();
        boardLayeredPane.setPreferredSize(new Dimension(640,640));
        boardLayeredPane.add(boardPanel, JLayeredPane.DEFAULT_LAYER);
        PieceDragAndDropListener pDandDList = new PieceDragAndDropListener(this);
        boardLayeredPane.addMouseListener(pDandDList);
        boardLayeredPane.addMouseMotionListener(pDandDList);
        this.add(boardLayeredPane, BorderLayout.CENTER);
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO EXECUTE MOVE ---
    }

    private void initializeSquares() {
        sqaurePanels = new JPanel[8][8];
        for(int i=0; i<8; ++i) {
            for(int j=0; j<8; ++j){
                initializeSingleSquarePanel(i,j);
            }
        }
    }

    private void initializeSingleSquarePanel(int i, int j) {
        sqaurePanels[i][j] = new JPanel(new GridLayout(1,1));
        sqaurePanels[i][j].setPreferredSize(new Dimension(80,80 ));
        sqaurePanels[i][j].setSize(new Dimension(80,80));
        if((j % 2 == 1 && i % 2 == 1) ||(j % 2 == 0 && i % 2 == 0)){
            sqaurePanels[i][j].setBackground(Color.WHITE);
        } else {
            sqaurePanels[i][j].setBackground(Color.DARK_GRAY);
        }
        boardPanel.add(sqaurePanels[i][j]);
    }

    private void initializePieces() {
        for(int i=0; i < 8; ++i) {
            for (int j=0; j<8; ++j) {
                if (p.getTaulell().getBoard()[i][j] != null){
                    sqaurePanels[i][j].add(getPieceImage(p.getTaulell().getBoard()[i][j].getcolor(),
                            p.getTaulell().getBoard()[i][j].getClass().getName()));
                }
            }
        }
    }

    private void paintSquareToHelp(int i,int j) {
        sqaurePanels[i][j].setBackground(Color.PINK);
    }

    public JLabel getPieceImage(boolean color, String type) {
        String filename = "";
        filename += color ? "w":"b";
        switch (type) {
            case "domini.Rook":
                filename+="r";
                break;
            case "domini.Knight":
                filename+="n";
                break;
            case "domini.Queen":
                filename+="q";
                break;
            case "domini.Bishop":
                filename+="b";
                break;
            case "domini.King":
                filename+="k";
                break;
            case "domini.Pawn":
                filename+="p";
                break;
        }
        String path = "/img/" + filename + ".png";
        Image pieceImage = new ImageIcon(getClass().getResource(path)).getImage();
        pieceImage = pieceImage.getScaledInstance(80,80, Image.SCALE_SMOOTH);
        JLabel pieceImageLabel = new JLabel(new ImageIcon(pieceImage));
        return pieceImageLabel;
    }


    public void cleanAutoHelp() {
        if (autoHelp != null) {
            for (int i=0; i < autoHelp.size(); ++i) {
                int x = autoHelp.get(i).getKey();
                int y = autoHelp.get(i).getValue();
                if((y % 2 == 1 && x % 2 == 1) ||(y % 2 == 0 && x % 2 == 0)){
                    sqaurePanels[x][y].setBackground(Color.WHITE);
                } else {
                    sqaurePanels[x][y].setBackground(Color.DARK_GRAY);
                }
            }
        }
        autoHelp = null;
    }

    public void ajudaMov(int i, int j) {

        cleanAutoHelp();
        System.out.println(origin);
        Pair<Integer,Integer> aux = new Pair<>(i,j);
        if (origin == null || !origin.equals(aux)) {

            this.origin = new Pair<>(i, j);
            ArrayList<Pair<Integer,Integer>> help = this.cDom.getAjudaMovs(i,j);
            if (help != null) {
                this.autoHelp = help;
                for (int a = 0; a < autoHelp.size(); ++a) {
                    paintSquareToHelp(autoHelp.get(a).getKey(), autoHelp.get(a).getValue());
                }
            }

        } else if (origin.equals(aux)){
            origin = null;
        }
    }

    public boolean checkMyPiece(int originCol, int originRow) {
        if (cDom.getPartida().getTaulell().getBoard()[originCol][originRow] == null) return true;
        return cDom.getPartida().getTaulell().getBoard()[originCol][originRow].getcolor() == cDom.getPartida().getQuiJuga();
    }

    public Pair<Integer,Integer> getOrigin() {
        return origin;
    }

    public String checkMove(int originCol, int originRow) {
        return cDom.getPartida().getState(new Pair<>(origin, new Pair<>(originCol,originRow)));
    }

    public boolean checkClick(int originCol, int originRow) {
        //System.out.println(Color.PINK);
        if (sqaurePanels[originCol][originRow].getBackground() == Color.PINK) {
            return false;
        } else {
            return true;
        }
    }


    public void updateBoard(Pair<Integer,Integer> from, Pair<Integer,Integer> to) {
        JPanel origin = sqaurePanels[from.getKey()][from.getValue()];
        JPanel destiny = sqaurePanels[to.getKey()][to.getValue()];
        destiny.removeAll();
        destiny.add(origin.getComponent(0));
        destiny.repaint();
        origin.removeAll();
        origin.repaint();
        cleanAutoHelp();
        Pair<Pair<Integer, Integer>, Pair<Integer,Integer>> move = new Pair<>(from,to);
        mainFrame.newMoveMade(move);
    }

    public void makeMove(int i, int j) {
        updateBoard(origin, new Pair<>(i,j));
    }

    public void badMoveUpdate(String checkMove) {
        mainFrame.badMoveMsg(checkMove);
    }
}
