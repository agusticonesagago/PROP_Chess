package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;

  public class Knight extends Peça {
    int ic = posinicial.getKey();
    int jc = posinicial.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    boolean blanca = Taulell[ic][jc].getcolor();

    if(caselladins(posfinal) && ((ic-2==ifi && jc-1==jfi)||(ic-1==ifi && jc-2==jfi)||(ic+1==ifi && jc-2==jfi)||
    (ic+2==ifi && jc-1==jfi)||(ic+2==ifi && jc+1==jfi)||(ic+1==ifi && jc+2==jfi)||(ic-1==ifi && jc+2==jfi)||(ic-2==ifi && jc+1==jfi))){
      if((Taulell[ifi][jfi].existeix() && Taulell[ifi][jfi].getcolor()!=blanca)||not Taulell[ifi][jfi].existeix() )return true;
      else return false;
    }
    else return false;
  }
}
