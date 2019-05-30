package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;

public class ConsultarPerfils extends JFrame{
    private JTable usersTable;
    private JPanel panel;
    private JLabel Sessio;
    private JButton EnrereButton;
    private CtrlDomini ctrlDom;

    public ConsultarPerfils(CtrlDomini ctrld) throws FileNotFoundException {
        super("Chess PROP");
        ctrlDom = ctrld;
        Sessio.setText("Sessio iniciada amb: " +ctrlDom.getUser_name());
        setContentPane(panel);
        Dimension minDim = new Dimension(300, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        EnrereButton.setFocusable(false);

        Object [] columnes = {"Nom:", "Winrate:", "ProblemesJugats:"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnes);
        Vector<Vector<String>> probs = ctrlDom.getUsers();
        usersTable.setModel(model);
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
                MainMenu frame = new MainMenu(ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });

    }
}
