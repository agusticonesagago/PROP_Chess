package domini;

import javafx.util.Pair;

import java.util.ArrayList;

public class Pawn extends Peca {

    public Pawn(boolean color, Pair<Integer, Integer> posactual) {
        super(color, posactual);
    }

    public Boolean espotmoure(Pair<Integer,Integer> posfinal){
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        int ifi = posfinal.getKey();
        int jfi = posfinal.getValue();

        //no se sap on les blanques i negres comencen

        if(caselladins(posfinal)){
            if((!color && ic == 1) || (color && ic == 6)) { //mirant si els peons estan a la posicio d'obertura i volen tirar endavant
                if(color){
                    if( ifi==(ic-2) && jfi==jc ) {
                       return true;
                    }
                }
                else{
                    if( ifi==(ic+2) && jfi==jc ) {
                        return true;
                    }
                }
            }
            if(color){
                if(ic-1==ifi && jc==jfi){ //cas de tirar cap endavant
                    return true;
                }
                else if((ic-1==ifi && jc-1==jfi) || (ic-1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
                    return true;
                }
            }
            else{
                if(ic+1==ifi && jc==jfi){ //cas de tirar cap endavant
                    return true;
                }
                else if((ic+1==ifi && jc-1==jfi) || (ic+1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
                    return true;
                }
            }
        }
        return false;
    }



    public ArrayList<Pair<Integer,Integer>> posicionsposible(){
        ArrayList<Pair<Integer,Integer>> posposibles= new ArrayList<>();
        int ic = posactual.getKey();
        int jc = posactual.getValue();

        if (color) {
            if (espotmoure(new Pair<>(ic - 1, jc - 1))) {
                posposibles.add(new Pair<>(ic - 1, jc - 1));
            }
            if (espotmoure(new Pair<>(ic - 2, jc))) {
                posposibles.add(new Pair<>(ic - 2, jc));
            }
            if (espotmoure(new Pair<>(ic - 1, jc))) {
                posposibles.add(new Pair<>(ic - 1, jc));
            }
            if (espotmoure(new Pair<>(ic - 1, jc + 1))) {
                posposibles.add(new Pair<>(ic - 1, jc + 1));
            }
        } else {
            if (espotmoure(new Pair<>(ic + 1, jc - 1))) {
                posposibles.add(new Pair<>(ic + 1, jc - 1));
            }
            if (espotmoure(new Pair<>(ic + 1, jc))) {
                posposibles.add(new Pair<>(ic + 1, jc));
            }
            if (espotmoure(new Pair<>(ic + 1, jc + 1))) {
                posposibles.add(new Pair<>(ic + 1, jc + 1));
            }
            if (espotmoure(new Pair<>(ic + 2, jc))) {
                posposibles.add(new Pair<>(ic + 2, jc));
            }
        }

        return posposibles;
    }

}