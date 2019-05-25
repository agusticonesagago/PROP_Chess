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
    private JButton EnrereButton;
    private JLabel Sessio;
    private String username;
    private CtrlDomini ctrlDom;

    public MenuPartida(String us, CtrlDomini ctrld) {
        super("Chess PROP");
        DeathMatchButton.setFocusable(false);
        CarregarButton.setFocusable(false);
        JugarButton.setFocusable(false);
        EnrereButton.setFocusable(false);

        username = us;
        ctrlDom = ctrld;
        Sessio.setText("Sessio iniciada amb: " +username);
        setContentPane(MenuPartida);
        Dimension minDim = new Dimension(400, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        EnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu frame = new MainMenu(username, ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
        JugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaulellExemple te = new TaulellExemple();
                JFrame f = new JFrame("Jugar Partida");
                f.add(te.getGui());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocation(0,0);

                f.pack();
                f.setMinimumSize(f.getSize());
                setVisible(false);
                f.setVisible(true);
            }
        });
    }
}
