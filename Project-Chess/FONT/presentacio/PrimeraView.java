package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class PrimeraView extends JFrame {
    private JButton GoOn;
    private JPanel FirstView;
    private JTextField NomAIntroduir;
    private JLabel NomJugador;
    private JLabel Titol;
    private JButton examinarButton;
    private JFormattedTextField arxiu;
    private String username;
    private CtrlDomini ctrlDom;
    private String newline;
    private static final Logger logger = Logger.getLogger("MyLog");

    public PrimeraView(CtrlDomini ctrld) {
        super ("Chess PROP");
        ctrlDom = ctrld;
        setContentPane(FirstView);
        Dimension minDim = new Dimension(300, 300);
        setMinimumSize(minDim);
        Dimension centerize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((centerize.getWidth()-getWidth())/2);
        int y = (int) ((centerize.getHeight()-getHeight())/2);
        setLocation(x, y);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        GoOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Color antic = GoOn.getBackground();
                //Color clr1= new Color(250,227,227);
                //GoOn.setBackground(clr1);
                //GoOn.setBackground(antic);
                if (NomAIntroduir.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(FirstView, "No has introduit cap nom");
                }
                else{
                    username = NomAIntroduir.getText();
                    MainMenu frame = new MainMenu(username, ctrlDom);
                    frame.setLocation(getLocation());
                    setVisible(false);
                    frame.setVisible(true);
                }
            }
        });

        examinarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(examinarButton);

                if(returnVal==JFileChooser.APPROVE_OPTION){
                    File file = fc.getSelectedFile();
                    arxiu.setText("Opening: " + file.getName());
                }
                else arxiu.setText("Open command cancelled by user" );
            }
        });
    }
}

