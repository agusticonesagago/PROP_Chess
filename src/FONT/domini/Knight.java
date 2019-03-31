package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

public class Knight extends Peca {

  public Knight(boolean color, Pair<Integer, Integer> posactual, Taulell t) {
    super(color, posactual, t);
  }

  public Boolean espotmoure(Pair<Integer, Integer> posfinal) {
        int ic = posactual.getKey();
        int jc = posactual.getValue();
        int ifi = posfinal.getKey();
        int jfi = posfinal.getValue();
        boolean blanca = Taulell.getBoard()[ic][jc].getcolor();

        if (caselladins(posfinal) && ((ic - 2 == ifi && jc - 1 == jfi) || (ic - 1 == ifi && jc - 2 == jfi) || (ic + 1 == ifi && jc - 2 == jfi) ||
                (ic + 2 == ifi && jc - 1 == jfi) || (ic + 2 == ifi && jc + 1 == jfi) || (ic + 1 == ifi && jc + 2 == jfi) || (ic - 1 == ifi && jc + 2 == jfi) || (ic - 2 == ifi && jc + 1 == jfi))) {
          if ((Taulell.PosOcupada(ifi,jfi) && Taulell.getBoard()[ifi][jfi].getcolor() != blanca) ||
                  !Taulell.PosOcupada(ifi,jfi)) return true;
          else return false;
        }
        else return false;
      }
    }
