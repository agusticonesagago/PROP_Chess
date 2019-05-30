package presentacio;

import domini.CtrlDomini;
import domini.Problema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SelectProblem extends JFrame {

    private CtrlDomini cDom;

    private JLabel title;
    private JTable ProblemTable;
    private JButton next;
    private JButton back;

    public SelectProblem(CtrlDomini cDom) {
        this.cDom  = cDom;
        initView();
    }

    private void initView() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        title = new JLabel();
        title.setText("Select a Problem: ");
        title.setPreferredSize(new Dimension(400,100));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(title, gridBagConstraints);
        this.add(title);

        ProblemTable = new JTable();
        Object [] columnes = {"FEN:", "Tema:", "Dificultat:"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnes);
        Vector<Vector<String>> probs = cDom.getCDMp().consultaProblemes();
        ProblemTable.setModel(model);
        ProblemTable.setPreferredSize(new Dimension(400, 200));
        Object[] fila = new Object[3];
        for (int i = 0; i < probs.size(); i++) {
            for (int j = 0; j < probs.get(i).size(); j++) {
                fila[j] = probs.get(i).get(j);
            }
            model.addRow(fila);
        }
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight= 2;
        gridBagLayout.setConstraints(ProblemTable, gridBagConstraints);
        this.add(ProblemTable);

        next = new JButton();
        next.setText("NEXT");
        next.setPreferredSize(new Dimension(100,25));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> vs = probs.get(ProblemTable.getSelectedRow());
                cDom.setProblema(new Problema(vs.get(1),vs.get(0),vs.get(2),null));
                SelectPlayers frame = new SelectPlayers(cDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(next, gridBagConstraints);
        this.add(next);

        back = new JButton();
        back.setText("BACK");
        back.setPreferredSize(new Dimension(100,25));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPartida frame = new MenuPartida(cDom);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);
            }
        });
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(back, gridBagConstraints);
        this.add(back);

        this.setResizable(true);
        this.pack();
        this.setLocation(getLocation());
        this.setMinimumSize(new Dimension(500,300));
        this.setVisible(true);


    }
}
