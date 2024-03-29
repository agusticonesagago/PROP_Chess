package domini;

import javafx.util.Pair;

import java.util.ArrayList;

public class Knight extends Peca {

    public Knight(boolean color, Pair<Integer, Integer> posactual) {
        super(color, posactual);
    }

    public Boolean espotmoure(Pair<Integer, Integer> posfinal) {
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        int ifi = posfinal.getKey();
        int jfi = posfinal.getValue();

        if (caselladins(posfinal) &&
                        ((ic - 2 == ifi && jc - 1 == jfi) ||
                        (ic - 1 == ifi && jc - 2 == jfi) ||
                        (ic + 1 == ifi && jc - 2 == jfi) ||
                        (ic + 2 == ifi && jc - 1 == jfi) ||
                        (ic + 2 == ifi && jc + 1 == jfi) ||
                        (ic + 1 == ifi && jc + 2 == jfi) ||
                        (ic - 1 == ifi && jc + 2 == jfi) ||
                        (ic - 2 == ifi && jc + 1 == jfi))) {
            return true;
        }
        else {
            return false;
        }
    }


    public ArrayList<Pair<Integer,Integer>> posicionsposible(){
        ArrayList<Pair<Integer,Integer>> posposibles= new ArrayList<>();
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        if(espotmoure(new Pair<>(ic-2,jc-1))){
            posposibles.add(new Pair<>(ic-2,jc-1));
        }
        if(espotmoure(new Pair<>(ic-1,jc-2))){
            posposibles.add(new Pair<>(ic-1,jc-2));
        }
        if(espotmoure(new Pair<>(ic+1,jc-2))){
            posposibles.add(new Pair<>(ic+1,jc-2));
        }
        if(espotmoure(new Pair<>(ic+2,jc-1))){
            posposibles.add(new Pair<>(ic+2,jc-1));
        }
        if(espotmoure(new Pair<>(ic+2,jc+1))){
            posposibles.add(new Pair<>(ic+2,jc+1));
        }
        if(espotmoure(new Pair<>(ic+1,jc+2))){
            posposibles.add(new Pair<>(ic+1,jc+2));
        }
        if(espotmoure(new Pair<>(ic-1,jc+2))){
            posposibles.add(new Pair<>(ic-1,jc+2));
        }
        if(espotmoure(new Pair<>(ic-2,jc+1))){
            posposibles.add(new Pair<>(ic-2,jc+1));
        }
        return posposibles;
    }
}