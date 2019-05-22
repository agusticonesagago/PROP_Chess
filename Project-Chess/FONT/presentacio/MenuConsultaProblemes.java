package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantProblema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MenuConsultaProblemes extends JFrame{
    private JPanel MenuConsulta;
    private JTable tableProblemes;
    private JButton eliminaButton;
    private JButton modificaButton;
    private JButton EnrereButton;
    private String username;
    private CtrlDomini ctrlDom;
    private CtrlDominiMantProblema cdmp;

    public MenuConsultaProblemes(String us, CtrlDomini ctrld) {
        super("Chess PROP");
        username = us;
        ctrlDom = ctrld;
        cdmp = ctrlDom.getCDMp();
        setContentPane(MenuConsulta);
        Dimension minDim = new Dimension(300, 300);
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
                MenuProblema frame = new MenuProblema(username, ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });

        modificaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        eliminaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
