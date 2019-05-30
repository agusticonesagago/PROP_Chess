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

public class MenuDeathMatch extends JFrame{

    private JTable tableProblemes;
    private JButton nextButton;
    private JButton confirmarButton;
    private JList tableSeleccionats;
    private JButton enrereButton;
    private CtrlDomini ctrlDom;
    private CtrlDominiMantProblema cdmp;
    private JLabel Sessio;
    private JPanel MenuDeath;
    private int row=0;
    private Vector<Vector<String>> FENs;

    public MenuDeathMatch(CtrlDomini ctrld) {
        super("Chess PROP");
        enrereButton.setFocusable(false);
        nextButton.setFocusable(false);
        confirmarButton.setFocusable(false);

        ctrlDom = ctrld;
        cdmp = ctrlDom.getCDMp();
        Sessio.setText("Sessio iniciada amb: " + ctrld.getUser_name());
        setContentPane(MenuDeath);
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

        Object [] columnesSeleccionats = {"FEN:"};
        DefaultTableModel modelSeleccionats = new DefaultTableModel();
        modelSeleccionats.setColumnIdentifiers(columnesSeleccionats);
        //Vector<String> fenSeleccionats = cdmp.consultaProblemes();
        DefaultListModel modelsele = new DefaultListModel();
        tableSeleccionats.setModel(modelsele);


        enrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MenuPartida frame = new MenuPartida(ctrlDom);
                    frame.setLocation(getLocation());
                    setVisible(false);
                    dispose();
                    frame.setVisible(true);
            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableProblemes.getSelectedRow();
                //FENs.add();
                String FENseleccionat = model.getValueAt(i, 0).toString();

                modelsele.add(row,FENseleccionat);
                ++row;
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Vector<String> FENs =
                //ctrld.configurarPartida(modelsele,"Maquina1","Maquina2");
            }
        });
    }

}
