package presentacio;

import domini.CtrlDomini;

import javax.swing.*;
import java.io.IOException;

public class MainPresentacio {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CtrlDomini crtlDom = null;
                try {
                    crtlDom = new CtrlDomini();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JFrame frame = new PrimeraView(crtlDom);
                frame.setVisible(true);
            }
        });
    }

}
