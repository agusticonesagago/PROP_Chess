package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantProblema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class MenuCreacioProblema extends JFrame{
    private JButton CreaButton;
    private JTextField textFieldFEN;
    private JTextField textFieldTema;
    private JTextField textFieldDificultat;
    private JPanel MenuCreacio;
    private JButton EnrereButton;
    private JLabel Sessio;
    private String username;
    private CtrlDomini ctrlDom;
    private CtrlDominiMantProblema cdrp;

    public MenuCreacioProblema (CtrlDomini ctrld) {
        super("Chess PROP");
        ctrlDom = ctrld;
        cdrp = ctrlDom.getCDMp();
        Sessio.setText("Sessio iniciada amb: " +ctrld.getUser_name());
        setContentPane(MenuCreacio);
        Dimension minDim = new Dimension(400, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        CreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldFEN.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MenuCreacio, "No has introduit cap FEN");
                }
                else if (textFieldTema.getText().isEmpty() ||
                        (!textFieldTema.getText().startsWith("Blanques") && !acabaEnNumero() ) ||
                        (!textFieldTema.getText().startsWith("Negres") && !acabaEnNumero())) {
                    JOptionPane.showMessageDialog(MenuCreacio, "No has introduit el Tema correctament," +
                            "el tema ha de començar pel color del jugador que guanya (la primera lletra en majuscula)," +
                            "i ha d'acabar en un numero entre el 1 i el 5");
                }
                else if (textFieldDificultat.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MenuCreacio, "No has introduit la Dificultat correctament," +
                            "les dificultats valides son: Facil, Normal i Dificil");
                }
                else {
                    Vector<String> dades= new Vector<>();
                    dades.add(0, textFieldFEN.getText());
                    dades.add(1, textFieldTema.getText());
                    dades.add(2, textFieldDificultat.getText());
                    int problema = -1;
                    try {
                        problema = cdrp.altaProblema(dades.get(0), dades);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    switch (problema) {
                        case 1: JOptionPane.showMessageDialog(MenuCreacio, "El problema que vols crear ja existeix"); break;
                        case 2: JOptionPane.showMessageDialog(MenuCreacio, "L'identificador no coincideix amb les dades passades"); break;
                        case 3: JOptionPane.showMessageDialog(MenuCreacio, "El problema no es pot resoldre"); break;
                        default:
                            JOptionPane.showMessageDialog(MenuCreacio, "El problema s'ha introduit correctament");
                            MenuProblema frame = new MenuProblema(ctrlDom);
                            frame.setLocation(getLocation());
                            setVisible(false);
                            frame.setVisible(true);
                            break;

                    }
                }
            }

            private boolean acabaEnNumero() {
               return ((Character.getNumericValue(textFieldTema.getText().charAt(textFieldTema.getText().length() - 1)) > 0)
               && (Character.getNumericValue(textFieldTema.getText().charAt(textFieldTema.getText().length() - 1)) < 6) );
            }
        });
        EnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuProblema frame = new MenuProblema(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
    }
}
