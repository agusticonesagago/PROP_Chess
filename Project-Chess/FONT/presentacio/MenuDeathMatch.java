package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantProblema;
import javafx.util.Pair;

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
    private int rowf=0;
    private Vector<Vector<String>> FENs= new Vector<Vector<String>> ();
    private Float tempsMaquina1;
    private Float tempsMaquina2;
    private int numVictMaquina1;
    private int numVictMaquina2;

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
        fila[0] = "FEN:";
        fila[1] = "Tema:";
        fila[2] = "Dificultat:";

        model.addRow(fila);
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

                String FENseleccionat = model.getValueAt(i, 0).toString();

                modelsele.add(rowf,FENseleccionat);


                Vector<String> dades = new Vector<String> ();
                dades.add(0,model.getValueAt(i, 0).toString());
                dades.add(1,model.getValueAt(i, 1).toString());
                dades.add(2,model.getValueAt(i, 2).toString());
                System.out.println(rowf);
                System.out.println("error abans");
                FENs.add(rowf,dades);
                System.out.println("error despres");
                ++rowf;
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pair<Boolean,Float> resultat;
                Vector<Vector<String>> llistat = new Vector<Vector<String>> ();

                for(int i =0; i <FENs.size();++i) {
                    ctrlDom.configurarPartida(FENs.get(i), "Maquina1","Maquina2");
                    resultat = ctrlDom.jugarPartida("Maquina1","Maquina2");

                    Vector<String> row = new Vector<String>();
                    String victoria ="No";
                    if(resultat.getKey()){
                        victoria ="Si";
                    }
                    //tempsMaquina1 += resultat.getValue();
                    row.add(0,FENs.get(i).toString());
                    row.add(1,resultat.getValue().toString());
                    row.add(2,victoria);

                    ctrlDom.configurarPartida(FENs.get(i), "Maquina2","Maquina1");
                    resultat = ctrlDom.jugarPartida("Maquina1","Maquina2");

                    victoria ="No";
                    if(resultat.getKey()){
                        victoria ="Si";
                    }
                    //tempsMaquina2 += resultat.getValue();
                    row.add(3,resultat.getValue().toString());
                    row.add(4,victoria);
                    llistat.add(i,row);
                }

                ResultatsDeathMatch frame = new ResultatsDeathMatch(ctrlDom,llistat);
                frame.setLocation(getLocation());
                setVisible(false);
                dispose();
                frame.setVisible(true);

            }
        });
    }

}
