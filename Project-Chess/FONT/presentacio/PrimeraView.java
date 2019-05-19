package presentacio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeraView extends JFrame{
    private JButton GoOn;
    private JPanel FirstView;
    private JTextField NomAIntroduir;
    private JLabel NomJugador;
    private JLabel Titol;
    private String username;

    public PrimeraView() {
        super ("Chess PROP");
        setContentPane(FirstView);
        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GoOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (NomAIntroduir.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(FirstView, "No has introduit cap nom");
                }
                else{
                    username = NomAIntroduir.getText();
                    MainMenu frame = new MainMenu();
                    setVisible(false);
                    frame.setVisible(true);
                }
            }
        });
    }
}
