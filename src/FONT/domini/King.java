package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class King extends Peça {
  public bool espotmoure(pair<int,int> posinicial, pair<int,int> posfinal){
    int ic = posinicial.getKey();
    int jc = posinicial.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    boolean blanca = Taulell[ic][jc].getcolor();



    if(caselladins(posfinal) && ((ic-1==ifi && jc-1==jfi)||(ic-1==ifi && jc==jfi)||(ic-1==ifi && jc-1==jfi)||
    (ic==ifi && jc-1==jfi)||(ic==ifi && jc+1==jfi)||(ic+1==ifi && jc-1==jfi)||(ic+1==ifi && jc==jfi)||(ic+1==ifi && jc+1==jfi))){
      if((Taulell[ifi][jfi].existeix() && Taulell[ifi][jfi].getcolor()!=blanca)||not Taulell[ifi][jfi].existeix() )return true;
      else return false;
    }
    else return false;
  }
}
