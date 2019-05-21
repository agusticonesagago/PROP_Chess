package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPartida extends JFrame{
    private JPanel MenuPartida;
    private JButton CarregarButton;
    private JButton JugarButton;
    private JButton DeathMatchButton;
    private JButton EnrereButton;

    public MenuPartida() {
        super("Chess PROP");
        setContentPane(MenuPartida);
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        EnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu frame = new MainMenu();
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
