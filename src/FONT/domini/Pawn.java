package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Pawn extends Peça {


  public bool espotmoure(pair<int,int> posinicial, pair<int,int> posfinal){
    boolean adversario = false;
    int ic = posinicial.getKey();
    int jc = posinicial.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    boolean blanca = Taulell[ic][jc].getcolor();

    //no se sap on les blanques i negres comencen

    if(caselladins(posfinal)){
      if((not blanca && i == 1) || (blanca && i == 6)) { //mirant si els peons estan a la posicio d'obertura i volen tirar endavant
        if(blanca){
          if( ifi==(ic+2) && jfi==jc ) {
            if((Taulell[ic+1][jc].existeix() && Taulell[ic+1][jc].getcolor()!=blanca) && (Taulell[ic+2][jc].existeix() && Taulell[ic+2][jc].getcolor()!=blanca)){
              return true;
            }
          }
        }
        else{
          if( ifi==(ic-2) && jfi==jc ) {
            if((Taulell[ic-1][jc].existeix() && Taulell[ic-1][jc].getcolor()!=blanca) && (Taulell[ic-2][jc].existeix() && Taulell[ic-2][jc].getcolor()!=blanca)){
              return true;
            }
          }
        }
      }
      if(blanca){
        if(ic+1==ifi && jc==jfi){ //cas de tirar cap endavant
          if(not Taulell[ifi][jfi].existeix()) return true; //buit
          else return false;
        }
        else if((ic-1==ifi && jc-1==jfi) || (ic-1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
           if(Taulell[ifi][jfi].existeix() && Taulell[ifi][jfi].getcolor()!=blanca) return true;
           else return false;
        }
      }
      else{
        if(ic-1==ifi && jc==jfi){ //cas de tirar cap endavant
          if(not Taulell[ifi][jfi].existeix()) return true; //buit
          else return false;
        }
        else if((ic+1==ifi && jc-1==jfi) || (ic+1==ifi && jc+1==jfi)){ //cas de tirar en diagonal
           if(Taulell[ifi][jfi].existeix() && Taulell[ifi][jfi].getcolor()!=blanca) return true;
           else return false;
        }
      }
    }
    return false;
  }

}
