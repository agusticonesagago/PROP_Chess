package presentacio;

import domini.CtrlDomini;
import domini.Huma;
import domini.Partida;
import domini.Ranking;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class JugarPartida extends JFrame implements Observer {

   // Atributes From domini
    public CtrlDomini cDom;
    public Partida p;
    public boolean paused;
    public Timer TotalTimer;

    public chessboardPanel chessboard;
    public timePanel temporizador;
    public JLabel fenText;
    public HistorialPanel HistorialMovs;
    public JButton exit;

    public JugarPartida(CtrlDomini cDom) {
        super(cDom.getProblema().getTema());
        this.cDom = cDom;
        this.p = cDom.getPartida();
        this.paused = true;
        this.chessboard = new chessboardPanel(cDom);
        this.chessboard.setJugarPartida(this);
        this.temporizador = new timePanel(cDom, this);
        if (cDom.getSavedTime() != null && cDom.getSavedTorn() != null){
            this.temporizador.setSaved(cDom.getSavedTime(), cDom.getSavedTorn());
        }
        this.HistorialMovs = new HistorialPanel(cDom);

        TotalTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temporizador.TimerClock();
            }
        });
        loadGui();
    }

    public void pauseTimer () {
        TotalTimer.stop();
        this.paused = true;
    }

    public void startTimer () {
        TotalTimer.start();
        this.paused = false;
        toMove();
    }


    @Override
    public void update(Observable o, Object arg) {

    }

    private void loadGui() {
        initializePanels();
        this.setResizable(true);
        this.pack();
        this.setLocation(0,0);
        this.setMinimumSize(new Dimension(1100,700));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.pauseTimer();
    }

    private void toMove() {
        if (temporizador.getTornInt() > 0) {
            if (cDom.getPartida().getQuiJuga()) { // Juguen blanques
                if (cDom.getPartida().getBlanques() instanceof Huma) {
                } else {
                    Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> res;
                    res = cDom.getPartida().getBlanques().moureFitxa(cDom.getPartida(),true,temporizador.getTornInt());
                    chessboard.setOrigin(res.getKey());
                    chessboard.checkMove(res.getValue().getKey(), res.getValue().getValue());
                    chessboard.updateBoard(res.getKey(), res.getValue());
                }
            } else {
                if (cDom.getPartida().getNegres() instanceof Huma) {
                } else {
                    Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> res;
                    res = cDom.getPartida().getNegres().moureFitxa(cDom.getPartida(),false,temporizador.getTornInt());
                    chessboard.setOrigin(res.getKey());
                    chessboard.checkMove(res.getValue().getKey(), res.getValue().getValue());
                    chessboard.updateBoard(res.getKey(), res.getValue());
                }
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
                if (!temporizador.getTornText().equals("  0")) {
                    String[] opts = {"Save", "Exit without Saving"};
                    int res = JOptionPane.showOptionDialog(aux, "Vols guardar la partida abans de marxar?",
                            "Exiting", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE
                            , null, opts, opts[0]);
                    if (res == 1) {
                        cDom.setPartida(null);
                        cDom.setSavedTime(null);
                        cDom.setSavedTorn(null);
                        MainMenu frame = new MainMenu(cDom);
                        setVisible(false);
                        dispose();
                        frame.setVisible(true);
                    } else {
                        cDom.setPartida(p);
                        cDom.setSavedTime(temporizador.getTime());
                        cDom.setSavedTorn(temporizador.getTornText());
                        MainMenu frame = new MainMenu(cDom);
                        setVisible(false);
                        dispose();
                        frame.setVisible(true);
                    }
                } else {
                    cDom.setPartida(null);
                    MainMenu frame = new MainMenu(cDom);
                    setVisible(false);
                    dispose();
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

        if (this.temporizador.getTornText().equals("  0")) {
            System.out.println(cDom.getPartida().getGuanyador());
            if (cDom.getPartida().getGuanyador()){
                // TODO MODIF VICTORY MSG
                String victory_msg = " Guanyen les Blanques!!! \n";
                victory_msg += "Temps: "+temporizador.getTime() +'\n';

                if (cDom.getPartida().getBlanques() instanceof Huma) {
                    Ranking r = new Ranking(temporizador.getFloatTime(),cDom.getProblema().getFEN(),cDom.getUser_name());
                    Vector<String> vs = new Vector<>();
                    vs.add(cDom.getUser_name());
                    vs.add(cDom.getProblema().getFEN());
                    vs.add(temporizador.getFloatTime().toString());
                    try {
                        cDom.getCDMr().altaRanking(cDom.getUser_name(),vs );//!
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                JOptionPane.showMessageDialog(this,victory_msg);
                HistorialMovs.printMsg("VICTORIA BLANQUES");
                this.pauseTimer();
            } else{

                String victory_msg = " Guanyen les Blanques!!! \n";
                victory_msg += "Temps: "+temporizador.getTime() +'\n';

                if (cDom.getPartida().getBlanques() instanceof Huma) {
                    Ranking r = new Ranking(temporizador.getFloatTime(),cDom.getProblema().getFEN(),cDom.getUser_name());
                    Vector<String> vs = new Vector<>();
                    vs.add(cDom.getUser_name());
                    vs.add(cDom.getProblema().getFEN());
                    vs.add(temporizador.getFloatTime().toString());
                    try {
                        cDom.getCDMr().altaRanking(cDom.getUser_name(),vs );//!
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(this,"Guanyen les Negres   !!!!");
                HistorialMovs.printMsg("VICTORIA NEGRA");
                this.pauseTimer();
            }
        }
        toMove();

    }

    public void badMoveMsg(String checkMove) {
        HistorialMovs.printMsg(checkMove);
    }

    public boolean getIfStart() {
        return !paused;
    }
}
