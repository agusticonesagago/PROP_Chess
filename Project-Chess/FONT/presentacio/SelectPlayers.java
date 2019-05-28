package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SelectPlayers extends JFrame {

    private CtrlDomini cDom;
    private JPanel errorMsg;
    private JLabel blackTitle;
    private JLabel whiteTitle;

    private JTable blackChoose;
    private JTable whiteChoose;

    private JButton PlayB;
    private JButton Back;

    public SelectPlayers (CtrlDomini domini) {
        super("Chess PROP");
        cDom = domini;
        errorMsg = new JPanel();
        initializeView();
    }

    private void initializeView() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        this.setLayout(gridBagLayout);

        blackTitle = new JLabel();
        blackTitle.setText("Black Player");
        blackTitle.setPreferredSize(new Dimension(100,40));
        blackTitle.setBorder(new LineBorder(Color.BLACK));
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(blackTitle, gridBagConstraints);
        this.add(blackTitle);

        blackChoose = new JTable();
        Object [] columnes = {"Player"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnes);
        Vector<String> m_player = new Vector<>();
        m_player.add("Huma");
        m_player.add("Maquina1");
        m_player.add("Maquina2");
        blackChoose.setModel(model);
        Object[] fila = new Object [1];
        for (int i = 0; i < m_player.size(); i++) {
            fila[0] = m_player.get(i);
            model.addRow(fila);
        }
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 2;
        gridBagLayout.setConstraints(blackChoose, gridBagConstraints);
        this.add(blackChoose);


        whiteTitle = new JLabel();
        whiteTitle.setText("White Player");
        whiteTitle.setPreferredSize(new Dimension(100,40));
        whiteTitle.setBorder(new LineBorder(Color.BLACK));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(whiteTitle, gridBagConstraints);
        this.add(whiteTitle);


        whiteChoose = new JTable();
        whiteChoose.setModel(model);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 2;
        gridBagLayout.setConstraints(whiteChoose, gridBagConstraints);
        this.add(whiteChoose);


        PlayB = new JButton();
        PlayB.setText("Play!");
        PlayB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p1 = blackChoose.getSelectedRow();
                int p2 = whiteChoose.getSelectedRow();
                if (p1 == -1  ||p2 == -1){
                    if (p1 == -1 ) JOptionPane.showMessageDialog(errorMsg, "Escull Qui Serà les Blanques");
                    else if (p1 == -1 && p2 == -1) JOptionPane.showMessageDialog(errorMsg, "Escull Qui Serà les Negres");
                    else JOptionPane.showMessageDialog(errorMsg, "Escull Jugador Loko");
                } else {
                    cDom.conf_partida_p(m_player.get(p2), m_player.get(p1));
                    JugarPartida frame = new JugarPartida(cDom);
                    frame.setLocation(getLocation());
                    setVisible(false);
                    frame.setVisible(true);
                }
            }
        });
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(PlayB, gridBagConstraints);
        this.add(PlayB);

        Back = new JButton();
        Back.setText("Back");
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectProblem frame = new SelectProblem(cDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight= 1;
        gridBagLayout.setConstraints(Back, gridBagConstraints);
        this.add(Back);

        this.setResizable(true);
        this.pack();
        this.setLocation(getLocation());
        this.setMinimumSize(new Dimension(400,400));
        this.setVisible(true);
    }
}
