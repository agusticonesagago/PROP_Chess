package presentacio;

import domini.CtrlDomini;

import javax.swing.*;

public class MainPresentacio {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CtrlDomini crtlDom = null;
                crtlDom = new CtrlDomini();
                JFrame frame = new PrimeraView(crtlDom);
                frame.setVisible(true);
            }
        });
    }

}
