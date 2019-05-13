package domini;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rook extends Peca {

    public Rook(boolean color, Pair<Integer, Integer> posactual) {
        super(color, posactual);
    }


    public Boolean espotmoure(Pair<Integer, Integer> posfinal) {
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        int ifi = posfinal.getKey();
        int jfi = posfinal.getValue();
        int dif_i = ifi - ic;
        int dif_j = jfi - jc;

        if (!caselladins(posfinal)) return false;
        else {
            if (dif_i == 0 && dif_j != 0) return true; // Horitzontal
            else if (dif_i != 0 && dif_j == 0) return true; // Vertical
            else return false;
        }
    }

    public ArrayList<Pair<Integer, Integer>> posicionsposible() {
        ArrayList<Pair<Integer, Integer>> posposibles = new ArrayList<>();
        int ic = posactual.getKey();
        int jc = posactual.getValue();

        boolean endOfBoard = false;
        int plus = 1;
        while (!endOfBoard && ((ic + plus) < 8)) {
            if (espotmoure(new Pair<>(ic + plus, jc))) {
                posposibles.add(new Pair<>(ic + plus, jc));
                ++plus;
            } else {
                endOfBoard = true;
            }
        }

        endOfBoard=false;
        plus = 1;
        while (!endOfBoard && ((ic - plus) >= 0)) {
            if(espotmoure(new Pair<>(ic-plus,jc))) {
                posposibles.add(new Pair<>(ic - plus, jc));
                ++plus;
            }
            else endOfBoard=true;
        }

        endOfBoard=false;
        plus = 1;
        while (!endOfBoard && ((jc + plus) < 8)) {
            if(espotmoure(new Pair<>(ic,jc+plus))) {
                posposibles.add(new Pair<>(ic, jc+plus));
                ++plus;
            }
            else endOfBoard=true;
        }

        endOfBoard=false;
        plus = 1;
        while (!endOfBoard && ((jc - plus) >=0)) {
            if(espotmoure(new Pair<>(ic,jc-plus))) {
                posposibles.add(new Pair<>(ic, jc-plus));
                ++plus;
            }
            else endOfBoard=true;
        }
        return posposibles;
    }
}