package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuProblema extends JFrame{
    private JPanel ProblemMenu;
    private JLabel Titol;
    private JButton CrearButton;
    private JButton ConsultarButton;
    private JButton EnrereButton;
    private JLabel Sessio;
    private String username;
    private CtrlDomini ctrlDom;

    public MenuProblema(CtrlDomini ctrld) {
        super("Chess PROP");
        ctrlDom = ctrld;
        setContentPane(ProblemMenu);
        Sessio.setText("Sessio iniciada amb: " +ctrld.getUser_name());
        Dimension minDim = new Dimension(250, 250);
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
        CrearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuCreacioProblema frame = new MenuCreacioProblema(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
        ConsultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuConsultaProblemes frame = new MenuConsultaProblemes(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
    }
}
