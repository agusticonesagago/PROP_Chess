package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

public class Bishop extends Peça {
  public Bishop(boolean color, Pair<Integer, Integer> posactual, Taulell t) {
    super(color, posactual, t);
  }

  public Boolean espotmoure(Pair<Integer,Integer> posinicial, Pair<Integer,Integer> posfinal){
    int ic = posinicial.getKey();
    int jc = posinicial.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    int difi = ifi - ic; //Per saber cap a on s'ha mogut
    int difj = jfi - jc;
    boolean blanca = Taulell.getBoard()[ic][jc].getcolor();

    if( !caselladins(posfinal)) return false;

    if(difi<0 && difj<0){
      int i = 1;
      else{
          while((ic-i)>=0 && (jc-i)>=0 ){
            if(ic-i==ifi && jc-i==jfi){
              if(Taulell.PosOcupada(ic-i,jc-i)){
                if(Taulell.getBoard()[ic-i][jc-i].getcolor()!=blanca) return true;
                else return false;
              }
              else return true;
            }
            else{
              if(Taulell.PosOcupada(ic-i,jc-i)) return false;
            }
            ++i;
         }
       }
    }

    else if(difi<0 && difj>0){
      int i = 1;
      else{
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
    }
    else if(difi>0 && difj>0){
      int i = 1;
      else{
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
    }
    else if(difi>0 && difj<0){
      int i = 1;
      else{
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
    }
    else return false;
  }
}
