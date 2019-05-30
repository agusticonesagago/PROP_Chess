package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantProblema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ResultatsDeathMatch extends JFrame{
    private JButton enrereButton;
    private JTable ResultatsTable;
    private JLabel Sessio;
    private JPanel Resultats;
    private CtrlDomini ctrlDom;

    public ResultatsDeathMatch(CtrlDomini ctrld,Vector<Vector<String>> res) {

        super("Chess PROP");

        enrereButton.setFocusable(false);

        ctrlDom = ctrld;
        Sessio.setText("Sessio iniciada amb: " + ctrld.getUser_name());
        setContentPane(Resultats);
        Dimension minDim = new Dimension(400, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Object [] columnes = {"FEN:", "TEMPS M1", "VICTORIA M1","TEMPS M2","VICTORIA M2"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnes);
        ResultatsTable.setModel(model);
        Object[] fila = new Object[5];
        Float tempsM1= new Float(0);
        Float tempsM2=new Float(0);

        fila[0] = "FEN";
        fila[1] = "TEMPS M1";
        fila[2] = "VICTORIA M1";
        fila[3] = "TEMPS M2";
        fila[4] = "VICTORIA M2";

        model.addRow(fila);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                fila[j] = res.get(i).get(j);
                if(j==1){
                    tempsM1 += Float.parseFloat(res.get(i).get(j));
                }
                else if(j==3){
                    tempsM2 += Float.parseFloat(res.get(i).get(j));
                }
            }
            model.addRow(fila);
        }
        fila[0] = "Temps Mitjà M1:";
        fila[1] = tempsM1/(float)res.size();
        fila[2] = "Temps Mitjà M2:";
        fila[3] = tempsM2/(float)res.size();
        fila[4] = "";

        model.addRow(fila);

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
    }
}
