package presentacio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRanking extends JFrame{
    private JList ListaRanking;
    private JList LlistaOpcions;
    private JButton EnrereButton;
    private JPanel MenuRanking;

    public MenuRanking() {
        super("Chess PROP");
        setContentPane(MenuRanking);
        setSize(400, 300);
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
