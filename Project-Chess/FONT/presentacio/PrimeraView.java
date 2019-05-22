package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeraView extends JFrame {
    private JButton GoOn;
    private JPanel FirstView;
    private JTextField NomAIntroduir;
    private JLabel NomJugador;
    private JLabel Titol;
    private String username;
    private CtrlDomini ctrlDom;

    public PrimeraView(CtrlDomini ctrld) {
        super ("Chess PROP");
        ctrlDom = ctrld;
        setContentPane(FirstView);
        Dimension minDim = new Dimension(300, 300);
        setMinimumSize(minDim);
        Dimension centerize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((centerize.getWidth()-getWidth())/2);
        int y = (int) ((centerize.getHeight()-getHeight())/2);
        setLocation(x, y);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        GoOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (NomAIntroduir.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(FirstView, "No has introduit cap nom");
                }
                else{
                    username = NomAIntroduir.getText();
                    MainMenu frame = new MainMenu(username, ctrlDom);
                    frame.setLocation(getLocation());
                    setVisible(false);
                    frame.setVisible(true);
                }
            }
        });
    }

}

