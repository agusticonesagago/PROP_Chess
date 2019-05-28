package presentacio;

import domini.CtrlDomini;
import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class HistorialPanel extends JPanel implements Observer {


    private CtrlDomini cDom;
    private JScrollPane ScollPane;
    private JTextArea HistArea;
    private String Content;

    @Override
    public void update(Observable o, Object arg) {

    }

    public HistorialPanel (CtrlDomini cDom) {
        this.cDom = cDom;
        initializeView();
    }

    public void printMove(Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> move) {
        System.out.println("HA SORTIT");

        String msg = "";
        // TODO treure domini.
        msg += cDom.getPartida().getTaulell().getBoard()[move.getValue().getKey()][move.getValue().getValue()].getClass().getName();
        if (cDom.getPartida().getQuiJuga()) {
            msg += " NEGRE s'ha mogut de ";
        } else {
            msg += " BLANC s'ha mogut de ";
        }
        Pair<Integer,Integer> from = move.getKey();
        Pair<Integer,Integer> to   = move.getValue();
        msg += "["+ from.getKey() +","+from.getValue()+"] a ["+to.getKey()+","+to.getValue()+"]\n";
        Content += msg;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HistArea.setText(Content);
            }
        });
    }

    public void printMsg(String msg) {
        msg += '\n';
        Content += msg;
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HistArea.setText(Content);
            }
        });
    }

    private void initializeView() {
        Content = new String("Start Game!\n");
        HistArea = new JTextArea(Content);
        HistArea.setBackground(Color.WHITE);
        ScollPane = new JScrollPane(HistArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ScollPane.setBorder(BorderFactory.createTitledBorder("Historial"));
        ScollPane.setViewportView(HistArea);
        ScollPane.setPreferredSize(new Dimension(400,400));
        this.add(ScollPane);
    }


}
