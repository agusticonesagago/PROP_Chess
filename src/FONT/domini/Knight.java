package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.util.ArrayList;

public class Knight extends Peca {

    public Knight(boolean color, Pair<Integer, Integer> posactual, Taulell t) {
        super(color, posactual, t);
    }

    public Boolean espotmoure(Pair<Integer, Integer> posfinal) {
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        int ifi = posfinal.getKey();
        int jfi = posfinal.getValue();

        if (caselladins(posfinal) && ((ic - 2 == ifi && jc - 1 == jfi) || (ic - 1 == ifi && jc - 2 == jfi) || (ic + 1 == ifi && jc - 2 == jfi) ||
                (ic + 2 == ifi && jc - 1 == jfi) || (ic + 2 == ifi && jc + 1 == jfi) || (ic + 1 == ifi && jc + 2 == jfi) || (ic - 1 == ifi && jc + 2 == jfi) || (ic - 2 == ifi && jc + 1 == jfi))) {
            if ((Taulell.PosOcupada(ifi,jfi) && Taulell.getBoard()[ifi][jfi].getcolor() != color) ||
                    !Taulell.PosOcupada(ifi,jfi)) return true;
            else return false;
        }
        else return false;
    }


    public ArrayList<Pair<Integer,Integer>> posicionsposible(){
        ArrayList<Pair<Integer,Integer>> posposibles= new ArrayList<>();
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        if(espotmoure(new Pair<>(ic-2,jc-1))){
            posposibles.add(new Pair<>(ic-2,jc-1));
        }
        else if(espotmoure(new Pair<>(ic-1,jc-2))){
            posposibles.add(new Pair<>(ic-1,jc-2));
        }
        else if(espotmoure(new Pair<>(ic+1,jc-2))){
            posposibles.add(new Pair<>(ic+1,jc-2));
        }
        else if(espotmoure(new Pair<>(ic+2,jc-1))){
            posposibles.add(new Pair<>(ic+2,jc-1));
        }
        else if(espotmoure(new Pair<>(ic+2,jc+1))){
            posposibles.add(new Pair<>(ic+2,jc+1));
        }
        else if(espotmoure(new Pair<>(ic+1,jc+2))){
            posposibles.add(new Pair<>(ic+1,jc+2));
        }
        else if(espotmoure(new Pair<>(ic-1,jc+2))){
            posposibles.add(new Pair<>(ic-1,jc+2));
        }
        else if(espotmoure(new Pair<>(ic-2,jc+1))){
            posposibles.add(new Pair<>(ic-2,jc+1));
        }

        return posposibles;
    }
}