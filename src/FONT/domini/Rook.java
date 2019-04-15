package domini;
import javafx.util.Pair;

import java.util.ArrayList;

public class Rook extends Peca {

    public Rook(boolean color, Pair<Integer, Integer> posactual, Taulell t) {
        super(color, posactual, t);
    }

    public Boolean espotmoure(Pair<Integer, Integer> posfinal) {
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        int ifi = posfinal.getKey();
        int jfi = posfinal.getValue();
        boolean obstaculo = false;
        int difi = ifi - ic; //Per saber cap a on s'ha mogut
        int difj = jfi - jc;
        int plus = 1;

        if (difi != 0 && difj == 0) {
            if (difi > 0) {
                while (!obstaculo && ((ic + plus) <= ifi)) {
                    if (Taulell.PosOcupada(ic+plus,jc) && (Taulell.getBoard()[ic+plus][jc ].getcolor() == color)) obstaculo = true;
                    if(((ic+plus)!=ifi)&& Taulell.PosOcupada(ic+plus,jc))obstaculo = true;
                    ++plus;
                }
            } else {
                while (!obstaculo && ((ic - plus) >= ifi)) {
                    if (Taulell.PosOcupada(ic-plus,jc) && (Taulell.getBoard()[ic-plus][jc ].getcolor() == color)) obstaculo = true;
                    if(((ic-plus)!=ifi)&& Taulell.PosOcupada(ic-plus,jc))obstaculo = true;
                    ++plus;
                }
            }
        } else if (difj != 0 && difi == 0) {
            if (difj > 0) {
                while (!obstaculo && ((jc + plus) <= jfi)) {
                    if (Taulell.PosOcupada(ic,jc+plus) && (Taulell.getBoard()[ic][jc + plus].getcolor() == color)) obstaculo = true;
                    if(((jc+plus)!=jfi)&& Taulell.PosOcupada(ic,jc+plus))obstaculo = true;
                    ++plus;
                }
            } else {
                while (!obstaculo && ((jc - plus) >= jfi)) {
                    if (Taulell.PosOcupada(ic,jc-plus) && (Taulell.getBoard()[ic][jc - plus].getcolor() == color)) obstaculo = true;
                    if(((jc-plus)!=jfi)&& Taulell.PosOcupada(ic,jc-plus))obstaculo = true;
                    ++plus;
                }
            }
        } else return false;
        return !obstaculo;
    }



    public ArrayList<Pair<Integer,Integer>> posicionsposible(){
        ArrayList<Pair<Integer,Integer>> posposibles= new ArrayList<>();
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        boolean obstaculo = false;

        int plus = 1;
        while (!obstaculo && ((ic + plus) < 8)) {
            if(espotmoure(new Pair<>(ic+plus,jc))) {
                posposibles.add(new Pair<>(ic + plus, jc));
                ++plus;
            }
            else obstaculo=true;
        }

        obstaculo=false;
        plus = 1;
        while (!obstaculo && ((ic - plus) >= 0)) {
            if(espotmoure(new Pair<>(ic-plus,jc))) {
                posposibles.add(new Pair<>(ic - plus, jc));
                ++plus;
            }
            else obstaculo=true;
        }

        obstaculo=false;
        plus = 1;
        while (!obstaculo && ((jc + plus) < 8)) {
            if(espotmoure(new Pair<>(ic,jc+plus))) {
                posposibles.add(new Pair<>(ic, jc+plus));
                ++plus;
            }
            else obstaculo=true;
        }

        obstaculo=false;
        plus = 1;
        while (!obstaculo && ((jc - plus) >=0)) {
            if(espotmoure(new Pair<>(ic,jc-plus))) {
                posposibles.add(new Pair<>(ic, jc-plus));
                ++plus;
            }
            else obstaculo=true;
        }

        return posposibles;
    }

}