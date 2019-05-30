package presentacio;

import domini.CtrlDomini;
import javafx.util.Pair;

import java.util.Observer;

public class JugarTutorial extends JugarPartida implements Observer {

    public JugarTutorial(CtrlDomini cDom) {
        super(cDom);
        super.HistorialMovs.printMsg(cDom.getTutorial().getBody());
    }

    @Override
    public void newMoveMade(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> move) {
        cDom.getPartida().ferMoviment(move);
        super.temporizador.updateTurn();
        super.HistorialMovs.printMove(move); // Actualitzar Historial
        super.fenText.setText(cDom.getPartida().getFEN());
    }
}
