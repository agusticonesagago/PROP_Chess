package presentacio;

import domini.CtrlDomini;
import domini.Huma;
import domini.Partida;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class JugarPartida extends JFrame implements Observer {

   // Atributes From domini
    public CtrlDomini cDom;
    private Partida p;

    private Timer TotalTimer;

    private chessboardPanel chessboard;
    private timePanel temporizador;
    private JLabel fenText;
    public HistorialPanel HistorialMovs;
    private JButton exit;

    public JugarPartida(CtrlDomini cDom) {
        super(cDom.getProblema().getTema());
        this.cDom = cDom;
        this.p = cDom.getPartida();
        this.chessboard = new chessboardPanel(cDom, this);
        this.temporizador = new timePanel(cDom, this);
        this.HistorialMovs = new HistorialPanel(cDom);

        TotalTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("HOLA");
                temporizador.TimerClock();
            }
        });
        loadGui();
    }

    public void pauseTimer () {
        TotalTimer.stop();
    }

    public void startTimer () {
        TotalTimer.start();
    }


    @Override
    public void update(Observable o, Object arg) {

    }

    private void loadGui() {
        initializePanels();
        this.setResizable(true);
        this.pack();
        this.setLocation(0,0);
        this.setMinimumSize(new Dimension(1000,700));
        this.setVisible(true);
        //TotalTimer.start();
        toMove();
    }

    private void toMove() {
        if (cDom.getPartida().getQuiJuga() && temporizador.getTornInt()!=0) { // Juguen blanques
            if (cDom.getPartida().getBlanques() instanceof Huma) {
            } else {
                System.out.println("SOC MAQUINA I: " +temporizador.getTornInt());
                Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> res;
                res = cDom.getPartida().getBlanques().moureFitxa(cDom.getPartida(),true,temporizador.getTornInt());
                chessboard.updateBoard(res.getKey(), res.getValue());
                newMoveMade(res);
            }
        } else {
            if (cDom.getPartida().getNegres() instanceof Huma) {
            } else {
                System.out.println("SOC MAQUINA I: " +temporizador.getTornInt());
                Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> res;
                res = cDom.getPartida().getNegres().moureFitxa(cDom.getPartida(),false,temporizador.getTornInt());
                chessboard.updateBoard(res.getKey(), res.getValue());
                newMoveMade(res);
            }
        }
    }

    private void initializePanels() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagLayout.setConstraints(chessboard, gridBagConstraints);
        this.add(chessboard);

        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(temporizador, gridBagConstraints);
        this.add(temporizador);

        fenText = new JLabel();
        fenText.setText(cDom.getPartida().getFEN());
        fenText.setBorder(BorderFactory.createTitledBorder("FEN"));
        fenText.setPreferredSize(new Dimension(400,50));
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(fenText, gridBagConstraints);
        this.add(fenText);


        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(HistorialMovs, gridBagConstraints);
        this.add(HistorialMovs);

        exit = new JButton();
        exit.setText("SORTIR");
        exit.setFocusPainted(false);
        Component aux = this;
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opts = {"Save", "Exit without Saving"};
                int res = JOptionPane.showOptionDialog(aux,"Vols guardar la partida abans de marxar?",
                        "Exiting", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE
                         , null, opts, opts[0]);
                if (res == 1){
                    MainMenu frame = new MainMenu(cDom);
                    setVisible(false);
                    frame.setVisible(true);
                } else {
                    try {
                        cDom.guardarPartida();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    MainMenu frame = new MainMenu(cDom);
                    setVisible(false);
                    frame.setVisible(true);
                }
            }
        });
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(exit, gridBagConstraints);
        this.add(exit);

    }

    public void newMoveMade(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> move) {
        // S'invoca quan es Fa un moviment (s'actualitza el ChessBoardPanel)
        cDom.getPartida().ferMoviment(move);
        HistorialMovs.printMove(move); // Actualitzar Historial
        temporizador.updateTurn();
        fenText.setText(cDom.getPartida().getFEN());
        toMove();

        if (this.temporizador.getTornText().equals("  0")) {
            System.out.println(cDom.getPartida().getGuanyador());
            if (cDom.getPartida().getGuanyador()){
                // TODO MODIF VICTORY MSG
                JOptionPane.showMessageDialog(this,"Guanyen les blanques !!!!");
                HistorialMovs.printMsg("VICTORIA BLANQUES");
            } else{
                JOptionPane.showMessageDialog(this,"Guanyen les Negres   !!!!");
                HistorialMovs.printMsg("VICTORIA NEGRA");
            }
        }



    }

    public void badMoveMsg(String checkMove) {
        HistorialMovs.printMsg(checkMove);
    }
}
