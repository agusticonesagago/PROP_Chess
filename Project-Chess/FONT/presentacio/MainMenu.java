package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MainMenu extends JFrame{
    private JButton ProblemButton;
    private JButton RankingButton;
    private JButton PartidaButton;
    private JButton BackButton;
    private JLabel Titol;
    private JPanel MenuPrincipal;
    private JLabel Sessio;
    private JButton PerfilsButton;
    private CtrlDomini ctrlDom;

    public MainMenu (CtrlDomini ctrld) {
        super("Chess PROP");
        ProblemButton.setFocusable(false);
        RankingButton.setFocusable(false);
        PartidaButton.setFocusable(false);
        BackButton.setFocusable(false);

        ctrlDom = ctrld;
        Sessio.setText("Sessio iniciada amb: " +ctrlDom.getUser_name());
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
                dispose();
                frame.setVisible(true);
            }
        });
        ProblemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuProblema frame = new MenuProblema(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
        PartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPartida frame = new MenuPartida(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
        RankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuRanking frame = new MenuRanking(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
        PerfilsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarPerfils frame = null;
                try {
                    frame = new ConsultarPerfils(ctrlDom);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
    }
}
