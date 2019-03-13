package domini;


import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

public class Peça{


    private boolean color; // true(blanc) i false(negre)
    private pair<int,int> posactual;

    public Peça(boolean color, pair<int,int> posactual) {
      this.color = color;
      this.posactual = posactual;
    }

    public bool caselladins(pair<int,int> pos){
      int i = pos.getKey();
      int j = pos.getValue();
      if(i<0 || i>8 || j<0 || j>8 ) return false;
      else return true;
    } /////////////////////////////////////////////////Potser hauria de ser del taulell

    public bool espotmoure(pair<int,int> posinicial, pair<int,int> posfinal){ //potser nomes fa falta posfinal

    }

    public ajudamoviment(Peça escollida){ //no sé com implementar-la

    }

    /* GETTERS */
    public boolean getcolor () {
      return color;
    }

    public pair<int,int> getposicioactual () {
      return posactual;
    }

    /* SETTERS */

    public mourepeça(pair<int,int> posfinal) {
      this.posactual = posfinal;
    }
}
