package presentacio;

import domini.CtrlDomini;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;
import java.util.Observable;
import java.util.Observer;

public class timePanel extends JPanel implements Observer {

    private CtrlDomini cDom;
    private JugarPartida mainFrame;
    private Time totalTime;

    private JPanel totalPanel;
    private JPanel topPanel;
    private JPanel botPanel;
    private JLabel fenText;

    private boolean mode;
    private int TornInt;
    private JLabel timerText;
    private JButton pauserbtn;
    private JLabel quiJugaText;
    private JLabel TornText;

    public timePanel(CtrlDomini cDom, JugarPartida mainFrame) {
        super(new BorderLayout());
        this.cDom = cDom;
        this.mainFrame = mainFrame;
        totalTime = Time.valueOf("00:00:00");
        mode = false;
        initialize();
    }

    public String getTornText() {
        return TornText.getText();
    }

    public void TimerClock() {

        totalTime.setTime(totalTime.getTime() + 1000);
        timerText.setText(totalTime.toString());

    }

    public String getTime() {
        return timerText.getText();
    }

    public void switchButton () {
        mode = !mode;
        if (mode){ // Cas Ara El Temporizador funciona
            Image img = null;
            try {
                img = ImageIO.read(getClass().getResource("/img/pause-bars.png"));
                img = img.getScaledInstance(40,40, Image.SCALE_SMOOTH);
                pauserbtn.setIcon(new ImageIcon(img));
            } catch (IOException e) {
                e.printStackTrace();
            }
            mainFrame.startTimer();
        } else {
            Image img = null;
            try {
                img = ImageIO.read(getClass().getResource("/img/play-button.png"));
                img = img.getScaledInstance(40,40, Image.SCALE_SMOOTH);
                pauserbtn.setIcon(new ImageIcon(img));
            } catch (IOException e) {
                e.printStackTrace();
            }
            mainFrame.pauseTimer();
        }
    }

    private void initialize () {

        timerText = new JLabel();
        timerText.setText(totalTime.toString());


        timerText.setFont(timerText.getFont().deriveFont(30f));
        timerText.setPreferredSize(new Dimension(300, 50));


        pauserbtn = new JButton();
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource("/img/play-button.png"));
            img = img.getScaledInstance(40,40, Image.SCALE_SMOOTH);
            pauserbtn.setIcon(new ImageIcon(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pauserbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchButton();
            }
        });
        pauserbtn.setFocusPainted(false);
        pauserbtn.setFont(pauserbtn.getFont().deriveFont(30f));
        pauserbtn.setPreferredSize(new Dimension(50,50));


        quiJugaText = new JLabel();
        if (cDom.getPartida().getQuiJuga()){
            quiJugaText.setText("Torn de les Blanques");
        } else {
            quiJugaText.setText("Torn de les Negres");
        }
        quiJugaText.setFont(quiJugaText.getFont().deriveFont(20f));
        quiJugaText.setPreferredSize(new Dimension(300, 50));

        TornText = new JLabel();
        TornInt = cDom.getProblema().getTornMat().getKey();
        TornText.setText("  "+TornInt);
        TornText.setFont(TornText.getFont().deriveFont(30f));
        TornText.setPreferredSize(new Dimension(50,50));


        totalPanel = new JPanel();
        totalPanel.setBorder(new LineBorder(Color.DARK_GRAY));
        topPanel = new JPanel();
        botPanel = new JPanel();

        totalPanel.add(topPanel, BorderLayout.NORTH);
        totalPanel.add(botPanel, BorderLayout.SOUTH);

        topPanel.add(timerText, BorderLayout.LINE_START);
        topPanel.add(pauserbtn, BorderLayout.LINE_END);
        botPanel.add(quiJugaText, BorderLayout.LINE_START);
        botPanel.add(TornText, BorderLayout.LINE_END);

        this.add(totalPanel);
        this.setPreferredSize(new Dimension(400,150));
    }


    @Override
    public void update(Observable o, Object arg) {

    }

    public void updateTurn() {
        if (cDom.getPartida().getQuiJuga()){
            quiJugaText.setText("Torn de les Blanques");
        } else {
            quiJugaText.setText("Torn de les Negres");
        }

        if (cDom.getProblema().getTornMat().getValue() != cDom.getPartida().getQuiJuga()){
            TornInt--;
            TornText.setText("  "+TornInt);

        }
    }

    public int getTornInt() {
       return TornInt;
    }

    public Float getFloatTime() {
        String time = getTime(); // 00:00:00
        Float tf = 0f;

        String h = time.substring(0, 2);
        int hr = Integer.valueOf(h);
        String m = time.substring(3, 5);
        int mn = Integer.valueOf(m);
        String s = time.substring(6, 8);
        int sc = Integer.valueOf(s);
        tf += (hr + mn + sc);
        return tf;
    }
}
