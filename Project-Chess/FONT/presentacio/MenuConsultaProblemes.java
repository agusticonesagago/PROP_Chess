package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantProblema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class MenuConsultaProblemes extends JFrame{
    private JPanel MenuConsulta;
    private JTable tableProblemes;
    private JButton eliminaButton;
    private JButton modificaButton;
    private JButton EnrereButton;
    private JLabel Sessio;
    private String username;
    private CtrlDomini ctrlDom;
    private CtrlDominiMantProblema cdmp;

    public MenuConsultaProblemes(CtrlDomini ctrld) {
        super("Chess PROP");
        EnrereButton.setFocusable(false);
        eliminaButton.setFocusable(false);
        modificaButton.setFocusable(false);

        ctrlDom = ctrld;
        cdmp = ctrlDom.getCDMp();
        Sessio.setText("Sessio iniciada amb: " +ctrld.getUser_name());
        setContentPane(MenuConsulta);
        Dimension minDim = new Dimension(400, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Object [] columnes = {"FEN:", "Tema:", "Dificultat:"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnes);
        Vector<Vector<String>> probs = cdmp.consultaProblemes();
        tableProblemes.setModel(model);
        Object[] fila = new Object[3];
        for (int i = 0; i < probs.size(); i++) {
            for (int j = 0; j < probs.get(i).size(); j++) {
                fila[j] = probs.get(i).get(j);
            }
            model.addRow(fila);
        }

        EnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuProblema frame = new MenuProblema(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });

        modificaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableProblemes.getSelectedRow();
                if (i >= 0) {
                    MenuCreacioProblema frame = new MenuCreacioProblema(ctrlDom, model.getValueAt(i, 0).toString(),
                            model.getValueAt(i,1).toString(), model.getValueAt(i,2).toString(), true);
                    frame.setLocation(getLocation());
                    setVisible(false);
                    frame.setVisible(true);
                }
                else JOptionPane.showMessageDialog(MenuConsulta,"No has seleccionat cap problema");
            }
        });

        eliminaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableProblemes.getSelectedRow();
                if (i >= 0){
                    int cas = -1;
                    try {
                        cas = cdmp.baixaProblema(model.getValueAt(i, 0).toString());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    if (cas == 0) {
                        model.removeRow(i);
                    }
                    else {
                        JOptionPane.showMessageDialog(MenuConsulta,"El Problema no existeix");
                    }
                }
                else {
                    System.out.println("Error d'esborrat");
                }
            }
        });
    }
}
