package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame{
    private JButton ProblemButton;
    private JButton RankingButton;
    private JButton PartidaButton;
    private JButton BackButton;
    private JLabel Titol;
    private JPanel MenuPrincipal;

    public MainMenu () {
        super("Chess PROP");
        setContentPane(MenuPrincipal);
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrimeraView frame = new PrimeraView();
                setVisible(false);
                frame.setVisible(true);
            }
        });
        ProblemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuProblema frame = new MenuProblema();
                setVisible(false);
                frame.setVisible(true);
            }
        });
        PartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPartida frame = new MenuPartida();
                setVisible(false);
                frame.setVisible(true);
            }
        });
        RankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuRanking frame = new MenuRanking();
                setVisible(false);
                frame.setVisible(true);
            }
        });
    }
}
