package presentacio;

import domini.CtrlDomini;

import java.util.Observer;

public class JugarTutorial extends JugarPartida implements Observer {

    public JugarTutorial(CtrlDomini cDom) {
        super(cDom);
        super.HistorialMovs.printMsg(cDom.getTutorial().getBody());
        //super.startTimer();
    }
}
