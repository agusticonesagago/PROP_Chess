package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Rook extends Peça {
      int ic = posinicial.getKey();
      int jc = posinicial.getValue();
      int ifi = posfinal.getKey();
      int jfi = posfinal.getValue();
      boolean blanca = Taulell[ic][jc].getcolor();
      boolean obstaculo = false;
      int difi= ifi-ic; //Per saber cap a on s'ha mogut
      int difj= jfi-jc;
      int plus = 1;

      if(difi!=0 && difj==0){
        if(difi>0){
          while(not obstaculo && (ifi+plus)<8){
            if(not (Taulell[ifi+plus][jfi].existeix() && Taulell[ifi+plus][jfi].getcolor()!=blanca)||not Taulell[ifi+plus][jfi].existeix()) obstaculo = true;
            ++plus;
          }
        }
        else{
          while(not obstaculo && (ifi-plus)>=0){
            if(not (Taulell[ifi-plus][jfi].existeix() && Taulell[ifi-plus][jfi].getcolor()!=blanca)||not Taulell[ifi-plus][jfi].existeix()) obstaculo = true;
            ++plus;
          }
        }
      }
      else if(difj!=0 && difi==0 ){
        if(difj>0){
          while(not obstaculo && (jfi-plus)<8){
            if(not (Taulell[ifi][jfi+plus].existeix() && Taulell[ifi][jfi+plus].getcolor()!=blanca)||not Taulell[ifi][jfi+plus].existeix()) obstaculo = true;
            ++plus;
          }
        }
        else{
          while(not obstaculo && (jfi-plus)>=0){
            if(not (Taulell[ifi][jfi-plus].existeix() && Taulell[ifi][jfi-plus].getcolor()!=blanca)||not Taulell[ifi][jfi-plus].existeix()) obstaculo = true;
            ++plus;
          }
        }
      }
      else return false;
      return !obstaculo;
}
