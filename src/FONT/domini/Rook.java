package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

public class Rook extends Peça {

    public Rook(boolean color, Pair<Integer, Integer> posactual, Taulell t) {
        super(color, posactual, t);
    }

    public Boolean espotmoure( Pair<Integer, Integer> posinicial, Pair<Integer, Integer> posfinal) {
        int ic = posinicial.getKey();
        int jc = posinicial.getValue();
        int ifi = posfinal.getKey();
        int jfi = posfinal.getValue();
        boolean blanca = Taulell.getBoard()[ic][jc].getcolor();
        boolean obstaculo = false;
        int difi = ifi - ic; //Per saber cap a on s'ha mogut
        int difj = jfi - jc;
        int plus = 1;

        if (difi != 0 && difj == 0) {
            if (difi > 0) {
                while (!obstaculo && (ifi + plus) < 8) {
                    if (!(Taulell.PosOcupada(ifi+plus,jfi) && Taulell.getBoard()[ifi + plus][jfi].getcolor() != blanca) || !
                            Taulell.PosOcupada(ifi+plus, jfi)) obstaculo = true;
                    ++plus;
                }
            } else {
                while (!obstaculo && (ifi - plus) >= 0) {
                    if (!(Taulell.PosOcupada(ifi-plus,jfi) && Taulell.getBoard()[ifi - plus][jfi].getcolor() != blanca) || !
                            Taulell.PosOcupada(ifi-plus,jfi)) obstaculo = true;
                    ++plus;
                }
            }
        } else if (difj != 0 && difi == 0) {
            if (difj > 0) {
                while (!obstaculo && (jfi - plus) < 8) {
                    if (!(Taulell.PosOcupada(ifi,jfi+plus) && Taulell.getBoard()[ifi][jfi + plus].getcolor() != blanca) || !
                            Taulell.PosOcupada(ifi,jfi+plus)) obstaculo = true;
                    ++plus;
                }
            } else {
                while (!obstaculo && (jfi - plus) >= 0) {
                    if (!(Taulell.PosOcupada(ifi,jfi-plus) && Taulell.getBoard()[ifi][jfi - plus].getcolor() != blanca) || !
                            Taulell.PosOcupada(ifi,jfi-plus)) obstaculo = true;
                    ++plus;
                }
            }
        } else return false;
        return !obstaculo;
    }

}