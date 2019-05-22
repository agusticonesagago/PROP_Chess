package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantRanking;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MenuRanking extends JFrame{
    private JList LlistaRanking;
    private JButton EnrereButton;
    private JPanel MenuRanking;
    private String username;
    private CtrlDomini ctrlDom;
    private CtrlDominiMantRanking cdmr;

    public MenuRanking(String us, CtrlDomini ctrld) {
        super("Chess PROP");

        username = us;
        ctrlDom = ctrld;
        cdmr = ctrld.getCDMr();

        setContentPane(MenuRanking);
        Dimension minDim = new Dimension(600, 300);
        setMinimumSize(minDim);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        DefaultListModel listmodel = new DefaultListModel();
        Vector<String> files= cdmr.consultaRankings();


        for(int i = 0; i < files.size(); ++i){
            listmodel.addElement(files.get(i));
        }

        LlistaRanking.setModel(listmodel);


        EnrereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu frame = new MainMenu(username, ctrlDom);
                frame.setLocation(getLocation());
                setVisible(false);
                frame.setVisible(true);

            }
        });
    }
}
