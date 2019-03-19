package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.util.ArrayList;

public class Pawn extends Peça {

    public Pawn(boolean color, Pair<Integer, Integer> posactual, Taulell t) {
        super(color, posactual, t);
    }

    // todo -> PECA.EXISTEIX () NOO!!



  public Boolean espotmoure(Pair<Integer,Integer> posfinal){
    int ic = posactual.getKey();
    int jc = posactual.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    boolean blanca = color;

    //no se sap on les blanques i negres comencen

    if(caselladins(posfinal)){
      if((! blanca && ic == 1) || (blanca && ic == 6)) { //mirant si els peons estan a la posicio d'obertura i volen tirar endavant
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
          if(!Taulell.PosOcupada(ifi,jfi)) return true; //buit
          else return false;
        }
        else if((ic-1==ifi && jc-1==jfi) || (ic-1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
           if(Taulell.PosOcupada(ifi,jfi)&& Taulell.getBoard()[ifi][jfi].getcolor()!=blanca) return true;
           else return false;
        }
      }
      else{
        if(ic+1==ifi && jc==jfi){ //cas de tirar cap endavant
          if(!Taulell.PosOcupada(ifi,jfi)) return true; //buit
          else return false;
        }
        else if((ic+1==ifi && jc-1==jfi) || (ic+1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
           if(Taulell.PosOcupada(ifi,jfi) &&
                   Taulell.getBoard()[ifi][jfi].getcolor()!=blanca)return true;
           else return false;
        }
      }
    }
    return false;
  }

}
