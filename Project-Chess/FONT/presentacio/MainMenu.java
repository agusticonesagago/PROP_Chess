package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton ProblemButton;
    private JButton RankingButton;
    private JButton PartidaButton;
    private JButton BackButton;
    private JLabel Titol;
    private JPanel MenuPrincipal;
    private String username;
    private CtrlDomini ctrlDom;

    public MainMenu (String us, CtrlDomini ctrld) {
        super("Chess PROP");
        username = us;
        ctrlDom = ctrld;
        setContentPane(MenuPrincipal);
        Dimension minDim = new Dimension(300, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimeraView frame = new PrimeraView(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
        ProblemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuProblema frame = new MenuProblema(username, ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
        PartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPartida frame = new MenuPartida(username, ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
        RankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuRanking frame = new MenuRanking(username, ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
    }
}
