package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPartida extends JFrame {
    public CtrlDomini cDom;

    // LEFT
    private PieceRowPanel whitePiecesPanel; // Create Class tbh
    private chessboardPanel chessboard;
    private PieceRowPanel blackPiecesPanel;
    // RIGHT
    private JPanel InfoPanel;
    private JPanel bttnPanel;



    private JTextField FEN_field;
    private JTextField Tema_field;
    private JTextField Diff_field;
    private JLabel FEN_title;
    private JLabel Tema_title;
    private JLabel Diff_title;

    private JButton CreateBttn;
    private JButton BackBttn;
    private JButton actualitzar;

    public CrearPartida (CtrlDomini cDom) {
        super("Crea un nou Problema");
        this.cDom = cDom;

        this.chessboard = new chessboardPanel(cDom);
        this.chessboard.setCrearPartida(this);
        this.setPreferredSize(new Dimension(1200, 800));
        initGui();
    }

    private void initGui() {
        initializePanels();
        this.setResizable(true);
        this.pack();
        this.setLocation(0,0);
        this.setMinimumSize(new Dimension(1200,640));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializePanels() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 4;
        gridBagLayout.setConstraints(chessboard, gridBagConstraints);
        this.add(chessboard);


        InfoPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(InfoPanel, BoxLayout.Y_AXIS); // top to bottom
        InfoPanel.setLayout(boxLayout);

        FEN_title = new JLabel();
        FEN_title.setText("FEN:");
        FEN_title.setPreferredSize(new Dimension(350,25));
        InfoPanel.add(FEN_title);
        FEN_field = new JTextField();
        FEN_field.setPreferredSize(new Dimension(350,25));
        InfoPanel.add(FEN_field);

        Tema_title = new JLabel();
        Tema_title.setText("Tema:");
        Tema_title.setPreferredSize(new Dimension(350, 25));
        InfoPanel.add(Tema_title);
        Tema_field = new JTextField();
        Tema_field.setPreferredSize(new Dimension(350, 25));
        InfoPanel.add(Tema_field);

        Diff_title = new JLabel();
        Diff_title.setText("Difficultat:");
        Diff_title.setPreferredSize(new Dimension(350,25));
        InfoPanel.add(Diff_title);
        Diff_field = new JTextField();
        Diff_field.setPreferredSize(new Dimension(350,25));
        InfoPanel.add(Diff_field);
        InfoPanel.setBorder(BorderFactory.createTitledBorder("INFO"));


        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(InfoPanel, gridBagConstraints);
        this.add(InfoPanel);



        whitePiecesPanel = new PieceRowPanel(true,chessboard);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(whitePiecesPanel, gridBagConstraints);
        this.add(whitePiecesPanel);

        blackPiecesPanel = new PieceRowPanel(false,chessboard);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(blackPiecesPanel, gridBagConstraints);
        this.add(blackPiecesPanel);



        bttnPanel = new JPanel();
        //BoxLayout boxLayoutH = new BoxLayout(bttnPanel, BoxLayout.X_AXIS); // top to bottom
        //bttnPanel.setLayout(boxLayoutH);

        actualitzar = new JButton();
        actualitzar.setText("Refresca");
        actualitzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessboard.setFromFENtoBoard(FEN_field.getText());
            }
        });
        bttnPanel.add(actualitzar);

        BackBttn = new JButton();
        BackBttn.setText("Enrere");
        bttnPanel.add(BackBttn);
        CreateBttn = new JButton();
        CreateBttn.setText("Crear");
        bttnPanel.add(CreateBttn);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(bttnPanel, gridBagConstraints);
        this.add(bttnPanel);

    }


}
