package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantRanking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MenuRanking extends JFrame{
    private JButton EnrereButton;
    private JPanel MenuRanking;
    private JTable tableRanking;
    private JLabel Sessio;
    private String username;
    private CtrlDomini ctrlDom;
    private CtrlDominiMantRanking cdmr;

    public MenuRanking(CtrlDomini ctrld) {
        super("Chess PROP");
        EnrereButton.setFocusable(false);

        ctrlDom = ctrld;
        cdmr = ctrld.getCDMr();
        Sessio.setText("Sessio iniciada amb: " +ctrld.getUser_name());

        setContentPane(MenuRanking);
        Dimension minDim = new Dimension(600, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        DefaultListModel listmodel = new DefaultListModel();
        Vector<Vector<String>> files= cdmr.consultaRankings();


        Object [] columnes = {"Nom:", "Problema:", "Temps:"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnes);
        Vector<Vector<String>> probs = cdmr.consultaRankings();
        tableRanking.setModel(model);
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
                frame.setVisible(true);

            }
        });
    }
}
