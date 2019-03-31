package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

public class King extends Peca {
  public King(boolean color, Pair<Integer, Integer> posactual, Taulell t) {
    super(color, posactual, t);
  }

  public Boolean espotmoure(Pair<Integer,Integer> posfinal){
    int ic = posactual.getKey();
    int jc = posactual.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    boolean blanca = Taulell.getBoard()[ic][jc].getcolor();



    if(caselladins(posfinal) &&
            ((ic-1==ifi && jc-1==jfi)||(ic-1==ifi && jc==jfi)||(ic-1==ifi && jc-1==jfi)||
                    (ic==ifi && jc-1==jfi)||(ic==ifi && jc+1==jfi)|| (ic+1==ifi && jc-1==jfi)||
                    (ic+1==ifi && jc==jfi)|| (ic+1==ifi && jc+1==jfi))){
      if((Taulell.PosOcupada(ifi,jfi) && Taulell.getBoard()[ifi][jfi].getcolor()!=blanca)||
              !Taulell.PosOcupada(ifi,jfi))return true;
      else return false;
    }
    else return false;
  }
}
