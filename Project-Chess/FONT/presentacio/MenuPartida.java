package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPartida extends JFrame{
    private JPanel MenuPartida;
    private JButton CarregarButton;
    private JButton JugarButton;
    private JButton DeathMatchButton;
    private CtrlDomini domini;
    private JButton EnrereButton;
    private JLabel Sessio;
    private JButton tutorialsButton;
    private String username;
    private CtrlDomini ctrlDom;

    public MenuPartida(CtrlDomini ctrld) {
        super("Chess PROP");
        DeathMatchButton.setFocusable(false);
        CarregarButton.setFocusable(false);
        tutorialsButton.setFocusable(false);
        JugarButton.setFocusable(false);
        EnrereButton.setFocusable(false);

        ctrlDom = ctrld;
        Sessio.setText("Sessio iniciada amb: " +ctrld.getUser_name());
        setContentPane(MenuPartida);
        Dimension minDim = new Dimension(400, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        CarregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JugarPartida frame = new JugarPartida(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });

        DeathMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuDeathMatch frame = new MenuDeathMatch(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });

        EnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu frame = new MainMenu(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
        JugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectProblem sp = new SelectProblem(ctrlDom);
                sp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                sp.pack();
                setVisible(false);
                dispose();
            }
        });


        tutorialsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectTutorial st = new SelectTutorial(ctrlDom);
                st.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                st.pack();
                setVisible(false);
                dispose();
            }
        });
    }
}
