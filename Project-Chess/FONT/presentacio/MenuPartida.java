package presentacio;

import domini.CtrlDomini;
import domini.Partida;
import domini.Problema;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class MenuPartida extends JFrame{
    private JPanel MenuPartida;
    private JButton CarregarButton;
    private JButton JugarButton;
    private JButton DeathMatchButton;
    private CtrlDomini domini;
    private JButton EnrereButton;
    private JLabel Sessio;
    private String username;
    private CtrlDomini ctrlDom;

    public MenuPartida(CtrlDomini ctrld) {
        super("Chess PROP");
        ctrlDom = ctrld;
        Sessio.setText("Sessio iniciada amb: " +ctrld.getUser_name());
        setContentPane(MenuPartida);
        Dimension minDim = new Dimension(400, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        EnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu frame = new MainMenu(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
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
            }
        });
    }
}
