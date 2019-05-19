package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProblema extends  JFrame{
    private JPanel ProblemMenu;
    private JLabel Titol;
    private JButton ModificarButton;
    private JButton CrearButton;
    private JButton ConsultarButton;
    private JButton EnrereButton;

    public MenuProblema() {
        super("Chess PROP");
        setContentPane(ProblemMenu);
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
    }
}
