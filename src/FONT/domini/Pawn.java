package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.util.ArrayList;

public class Pawn extends Peça {

    public Pawn(boolean color, Pair<Integer, Integer> posactual) {
        super(color, posactual);
    }

    // todo -> PECA.EXISTEIX () NOO!!



  public Boolean espotmoure(Pair<Integer,Integer> posinicial, Pair<Integer,Integer> posfinal){
    int ic = posinicial.getKey();
    int jc = posinicial.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    boolean blanca = (Peça) (Taulell[ic][jc]).getcolor();

    //no se sap on les blanques i negres comencen

    if(caselladins(posfinal)){
      if((! blanca && i == 1) || (blanca && i == 6)) { //mirant si els peons estan a la posicio d'obertura i volen tirar endavant
        if(blanca){
          if( ifi==(ic-2) && jfi==jc ) {
            if((!Taulell.PosOcupada(ic-1,jc) && (!Taulell.PosOcupada(ic-2,jc)))){
              return true;
            }
          }
        }
        else{
          if( ifi==(ic+2) && jfi==jc ) {
            if((!Taulell.PosOcupada(ic+1,jc) && (!Taulell.PosOcupada(ic+2,jc)))){
              return true;
            }
          }
        }
      }
      if(blanca){
        if(ic-1==ifi && jc==jfi){ //cas de tirar cap endavant
          if(! Taulell[ifi][jfi].existeix()) return true; //buit
          else return false;
        }
        else if((ic-1==ifi && jc-1==jfi) || (ic-1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
           if(Taulell[ifi][jfi].existeix() && Taulell[ifi][jfi].getcolor()!=blanca) return true;
           else return false;
        }
      }
      else{
        if(ic+1==ifi && jc==jfi){ //cas de tirar cap endavant
          if(! Taulell[ifi][jfi].existeix()) return true; //buit
          else return false;
        }
        else if((ic+1==ifi && jc-1==jfi) || (ic+1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
           if(Taulell[ifi][jfi].existeix() &&
                   Taulell[ifi][jfi].getcolor()!=blanca)return true;
           else return false;
        }
      }
    }
    return false;
  }

}
