package presentacio;

import javax.swing.*;

public class MainPresentacio {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PrimeraView();
                frame.setVisible(true);
            }
        });
    }

}
