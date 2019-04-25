package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import domini.Taulell;
import javafx.util.Pair;

import java.util.ArrayList;

public class Bishop extends Peca {
  public Bishop(boolean color, Pair<Integer, Integer> posactual, domini.Taulell t) {
    super(color, posactual, t);
  }

  public Boolean espotmoure(Pair<Integer, Integer> posfinal) {

    int ic = posactual.getKey();
    int jc = posactual.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    int difi = ifi - ic; //Per saber cap a on s'ha mogut
    int difj = jfi - jc;
    boolean blanca = Taulell.getBoard()[ic][jc].getcolor();

    if( !caselladins(posfinal)) return false;

    if(difi<0 && difj<0){
      int i = 1;
      while((ic-i)>=0 && (jc-i)>=0 ) {
        if (ic - i == ifi && jc - i == jfi) {
          if (Taulell.PosOcupada(ic - i, jc - i)) {
            if (Taulell.getBoard()[ic - i][jc - i].getcolor() != blanca) return true;
            else return false;
          } else return true;
        } else {
          if (Taulell.PosOcupada(ic - i, jc - i)) return false;
        }
        ++i;
      }
    }

    else if(difi<0 && difj>0){
      int i = 1;
      while((ic-i)>=0 && (jc+i)<8){
        if(ic-i==ifi && jc+i==jfi){
          if(Taulell.PosOcupada(ic-i,jc+i)){
            if(Taulell.getBoard()[ic-i][jc+i].getcolor()!=blanca) return true;
            else return false;
          }
          else return true;
        }
        else{
          if(Taulell.PosOcupada(ic-i,jc+i)) return false;
        }
        ++i;
     }
    }
    else if(difi>0 && difj>0){
      int i = 1;
          while((ic+i)<8 && (jc+i)<8){
            if(ic+i==ifi && jc+i==jfi){
              if(Taulell.PosOcupada(ic+i,jc+i)){
                if(Taulell.getBoard()[ic+i][jc+i].getcolor()!=blanca) return true;
                else return false;
              }
              else return true;
            }
            else{
              if(Taulell.PosOcupada(ic+i,jc+i)) return false;
            }
            ++i;
         }
    }

    else if(difi>0 && difj<0){
      int i = 1;
      while((ic+i)<8 && (jc-i)>=0){
            if(ic+i==ifi && jc-i==jfi){
              if(Taulell.PosOcupada(ic+i,jc-i)){
                if(Taulell.getBoard()[ic+i][jc-i].getcolor()!=blanca) return true;
                else return false;
              }
              else return true;
            }
            else{
              if(Taulell.PosOcupada(ic+i,jc-i)) return false;
            }
            ++i;

    }
    }
    else return false;

    return false;
  }


    public ArrayList<Pair<Integer,Integer>> posicionsposible(){
        java.util.ArrayList<Pair<Integer,Integer>> posposibles= new ArrayList<>();
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        boolean obstaculo = false;
        int plus = 1;

        while (!obstaculo && ((jc - plus) >=0) && ((ic-plus)>=0)) {
            if(espotmoure(new Pair<>(ic-plus,jc-plus))) {
                posposibles.add(new Pair<>(ic-plus, jc-plus));
                ++plus;
            }
            else obstaculo=true;
        }

        obstaculo=false;
        plus = 1;
        while (!obstaculo && ((jc + plus) <8) && ((ic-plus)>=0)) {
            if(espotmoure(new Pair<>(ic-plus,jc+plus))) {
                posposibles.add(new Pair<>(ic-plus, jc+plus));
                ++plus;
            }
            else obstaculo=true;
        }

        obstaculo=false;
        plus = 1;
        while (!obstaculo && ((jc + plus) <8) && ((ic+plus)<8)) {
            if(espotmoure(new Pair<>(ic+plus,jc+plus))) {
                posposibles.add(new Pair<>(ic+plus, jc+plus));
                ++plus;
            }
            else obstaculo=true;
        }

        obstaculo=false;
        plus = 1;
        while (!obstaculo && ((jc - plus) >=0) && ((ic+plus)<8)) {
            if(espotmoure(new Pair<>(ic+plus,jc-plus))) {
                posposibles.add(new Pair<>(ic+plus, jc-plus));
                ++plus;
            }
            else obstaculo=true;
        }

        return posposibles;
    }
}


//TODO posiblespositions