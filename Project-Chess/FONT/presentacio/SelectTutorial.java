package presentacio;

import domini.CtrlDomini;
import domini.Tutorial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SelectTutorial extends JFrame {

    private CtrlDomini cDom;

    private JLabel title;
    private JTable TutorialTable;
    private JButton next;
    private JButton back;

    public SelectTutorial(CtrlDomini cDom) {
        this.cDom  = cDom;
        initView();
    }

    private void initView() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        title = new JLabel();
        title.setText("Select a Tutorial: ");
        title.setPreferredSize(new Dimension(400,100));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(title, gridBagConstraints);
        this.add(title);

        TutorialTable = new JTable();
        Object [] columnes = {"Camp:", "Tema:", "FEN:"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnes);
        Vector<Vector<String>> tutos = cDom.getCDMp().consultarTutorials();
        TutorialTable.setModel(model);
        TutorialTable.setPreferredSize(new Dimension(400, 200));
        Object[] fila = new Object[3];
        for (int i = 0; i < tutos.size(); i++) {
            for (int j = 0; j < tutos.get(i).size(); j++) {
                fila[j] = tutos.get(i).get(j);
            }
            model.addRow(fila);
        }
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight= 2;
        gridBagLayout.setConstraints(TutorialTable, gridBagConstraints);
        this.add(TutorialTable);

        next = new JButton();
        next.setText("NEXT");
        next.setPreferredSize(new Dimension(100,25));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> vs = tutos.get(TutorialTable.getSelectedRow());
                System.out.println("EL TUTORIAL ES: "+ vs.get(2));
                Tutorial t = cDom.getCDMp().findTutorial(vs.get(2));
                cDom.setTutorial(t);
                cDom.setProblema(cDom.getTutorial());
                cDom.conf_partida_p("Huma", "Maquina1");
                JugarTutorial frame = new JugarTutorial(cDom);
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
