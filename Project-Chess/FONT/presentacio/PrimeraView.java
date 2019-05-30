package presentacio;

import domini.CtrlDomini;
import domini.CtrlDominiMantProblema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

        String[] opciones ={"o"};

        GoOn.setFocusable(false);
        examinarButton.setFocusable(false);
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
                    JOptionPane.showMessageDialog(FirstView,"No has introduit cap nom");
                }
                else{
                    try {
                        ctrlDom.iniciasessio(NomAIntroduir.getText());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    MainMenu frame = new MainMenu(ctrlDom);
                    frame.setLocation(getLocation());
                    setVisible(false);
                    dispose();
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
                    try {
                        Scanner sc = new Scanner(file);
                        String header = sc.nextLine();
                        if (header.equals("Problemes:")) {
                            System.out.println("categoria ");
                            while(sc.hasNext()){
                                Vector<String> dades = new Vector<>();
                                String fen1 = sc.nextLine();
                                String tema1 = sc.nextLine();
                                String dificultat1 = sc.nextLine();
                                dades.add(0,fen1);
                                dades.add(1,tema1);
                                dades.add(2,dificultat1);
                                int error = ctrlDom.getCDMp().altaProblema(dades.get(0), dades);
                                if (error == 0) System.out.println("El problema s'ha introduit correctament" );
                                else if (error == 1) System.out.println("El problema que vols crear ja existeix ");
                                else if (error == 2) System.out.println("L'identificador no coincideix amb les dades passades ");
                                else if (error == 3) System.out.println("El problema no es pot resoldre ");
                            }
                        }
                        else if (header.equals("Ranking:")) {
                            while(sc.hasNext()){
                                Vector<String> dades = new Vector<>();
                                String nomj = sc.nextLine();
                                String nomp = sc.nextLine();
                                String temps = sc.nextLine();
                                dades.add(0,nomj);
                                dades.add(1,nomp);
                                dades.add(2,temps);
                                int error = ctrlDom.getCDMr().altaRanking(dades.get(0), dades);
                                if (error == 0) System.out.println("La fila del ranking s'ha introduit correctament" );
                                else if (error == 1) System.out.println("La fila del ranking que vols crear ja existeix " );
                                else if (error == 2) System.out.println("L'identificador no coincideix amb les dades passades " );
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                else arxiu.setText("Open command cancelled by user" );
            }
        });
    }
}

