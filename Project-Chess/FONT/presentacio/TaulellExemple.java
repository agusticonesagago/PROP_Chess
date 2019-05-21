package presentacio;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TaulellExemple extends JFrame {
    private final JPanel gui = new JPanel(new BorderLayout(10,10));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel all;
    private JPanel chessBoard;
    private JPanel gameDetails;
    private final JLabel message = new JLabel(
            "Test Message");
    private static final String COLS = "ABCDEFGH";

    TaulellExemple(){
        initializeGui();
    }

    public final void initializeGui() {
        Border blackline = BorderFactory.createLineBorder(Color.black);
        gui.setBorder(blackline);
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        // TOOLBAR
        gui.add(tools,BorderLayout.PAGE_START);
        tools.add(new JButton("Back"));
        tools.addSeparator();
        tools.add(new JButton("Save"));
        tools.add(message);


        // ALL
        all = new JPanel(new GridLayout(0,2));
        all.setBorder(new LineBorder(Color.GREEN));
        gui.add(all, BorderLayout.EAST);
        // ChessBoard
        chessBoard = new JPanel(new GridLayout(0,9));
        chessBoard.setBorder(new LineBorder(Color.BLUE));
        all.add(chessBoard);

        // ChessBoard Squares
        Insets buttonMargin = new Insets(0,0,0,0);
        for(int ii=0; ii < chessBoardSquares.length; ii++){
            for(int jj=0; jj < chessBoardSquares[ii].length; ++jj){
                JButton b = new JButton();
                b.setMargin(buttonMargin);

                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64,64,BufferedImage.TYPE_INT_ARGB)
                );
                b.setIcon(icon);
                if((jj % 2 == 1 && ii % 2 == 1) ||(jj % 2 == 0 && ii % 2 == 0)){
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }

        chessBoard.add(new JLabel(""));
        for(int ii=0;ii<8;ii++){
            chessBoard.add(new JLabel(COLS.substring(ii,ii+1),
                    SwingConstants.CENTER));
        }

        for(int ii=0; ii < 8; ii++){
            for (int jj=0; jj < 8; ++jj){
                switch(jj){
                    case 0:
                        chessBoard.add(new JLabel("" + (ii+1),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }


        // Game Details
        gameDetails = new JPanel(new GridLayout(0,9));
        gameDetails.setBorder(new LineBorder(Color.BLACK));
        all.add(gameDetails, BorderLayout.WEST);

        // BOTTOM TOOLBAR
        JToolBar btools = new JToolBar();
        btools.setFloatable(false);
        gui.add(btools,BorderLayout.PAGE_END);
        btools.add(new JTextField("INSERT FEN"));

    }

    public final JComponent getChessBoard () {
        return chessBoard;
    }

    public final JComponent getGui () {
        return gui;
    }

}
