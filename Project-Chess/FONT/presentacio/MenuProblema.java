package presentacio;

import domini.CtrlDomini;
import domini.Problema;

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
        CrearButton.setFocusable(false);
        EnrereButton.setFocusable(false);
        ConsultarButton.setFocusable(false);

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
                dispose();
                frame.setVisible(true);
            }
        });
        CrearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Problema p = new Problema();
                p.setFEN("8/8/8/8/8/8/8/8 w - - 0 1");
                ctrlDom.setProblema(p);
                ctrlDom.conf_partida_p("Huma","Huma");
                CrearPartida frame = new CrearPartida(ctrlDom);
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
        ConsultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuConsultaProblemes frame = new MenuConsultaProblemes(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
    }
}
