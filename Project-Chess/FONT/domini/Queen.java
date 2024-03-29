package domini;


import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.util.Pair;

import java.util.ArrayList;

public class Queen extends Peca {
  public Queen(boolean color, Pair<Integer, Integer> posactual) {
    super(color, posactual);
  }




  public Boolean espotmoure(Pair<Integer, Integer> posfinal) {
    int ic = posactual.getKey();
    int jc = posactual.getValue();
    int ifi = posfinal.getKey();
    int jfi = posfinal.getValue();
    int dif_i = ifi - ic;
    int dif_j = jfi - jc;

    if (!caselladins(posfinal)) return false;
    if (Math.abs(dif_i) == Math.abs(dif_j)) return true; // Cas diagonals
    if (dif_i == 0 && dif_j != 0) return true;
    else if (dif_i != 0 && dif_j == 0) return true;
    else return false;
  }



  public ArrayList<Pair<Integer,Integer>> posicionsposible(){
    ArrayList<Pair<Integer,Integer>> posposibles= new ArrayList<>();
    int ic = posactual.getKey();
    int jc = posactual.getValue();

    boolean endOfBoard = false;
    int plus = 1;

    while (!endOfBoard && ((ic + plus) < 8)) {
      if(espotmoure(new Pair<>(ic+plus,jc))) {
        posposibles.add(new Pair<>(ic + plus, jc));
        ++plus;
      }
      else endOfBoard=true;
    }

    endOfBoard=false;
    plus = 1;
    while (!endOfBoard && ((ic - plus) >= 0)) {
      if(espotmoure(new Pair<>(ic-plus,jc))) {
        posposibles.add(new Pair<>(ic - plus, jc));
        ++plus;
      }
      else endOfBoard=true;
    }

    endOfBoard=false;
    plus = 1;
    while (!endOfBoard && ((jc + plus) < 8)) {
      if(espotmoure(new Pair<>(ic,jc+plus))) {
        posposibles.add(new Pair<>(ic, jc+plus));
        ++plus;
      }
      else endOfBoard=true;
    }

    endOfBoard=false;
    plus = 1;
    while (!endOfBoard && ((jc - plus) >=0)) {
      if(espotmoure(new Pair<>(ic,jc-plus))) {
        posposibles.add(new Pair<>(ic, jc-plus));
        ++plus;
      }
      else endOfBoard=true;
    }

    endOfBoard=false;
    plus = 1;
    while (!endOfBoard && ((jc - plus) >=0) && ((ic-plus)>=0)) {
      if(espotmoure(new Pair<>(ic-plus,jc-plus))) {
        posposibles.add(new Pair<>(ic-plus, jc-plus));
        ++plus;
      }
      else endOfBoard=true;
    }

    endOfBoard=false;
    plus = 1;
    while (!endOfBoard && ((jc + plus) <8) && ((ic-plus)>=0)) {
      if(espotmoure(new Pair<>(ic-plus,jc+plus))) {
        posposibles.add(new Pair<>(ic-plus, jc+plus));
        ++plus;
      }
      else endOfBoard=true;
    }

    endOfBoard=false;
    plus = 1;
    while (!endOfBoard && ((jc + plus) <8) && ((ic+plus)<8)) {
      if(espotmoure(new Pair<>(ic+plus,jc+plus))) {
        posposibles.add(new Pair<>(ic+plus, jc+plus));
        ++plus;
      }
      else endOfBoard=true;
    }

    endOfBoard=false;
    plus = 1;
    while (!endOfBoard && ((jc - plus) >=0) && ((ic+plus)<8)) {
      if(espotmoure(new Pair<>(ic+plus,jc-plus))) {
        posposibles.add(new Pair<>(ic+plus, jc-plus));
        ++plus;
      }
      else endOfBoard=true;
    }

    return posposibles;
  }
}


/*
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
      while((ic+i)<8 && (jc-i)>=0 ){
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

    else if(difi==0 && difj<0){
      int i = 1;
      while((jc-i)>=0 ){
        if(ic==ifi && jc-i==jfi){
          if(Taulell.PosOcupada(ic,jc-i)){
            if(Taulell.getBoard()[ic][jc-i].getcolor()!=blanca) return true;
            else return false;
          }
          else return true;
        }
        else{
          if(Taulell.PosOcupada(ic,jc-i)) return false;
        }
        ++i;
      }
    }

    else if(difi==0 && difj>0){
      int i = 1;
      while((jc+i)<8){
        if(ic==ifi && jc+i==jfi){
          if(Taulell.PosOcupada(ic,jc+i)){
            if(Taulell.getBoard()[ic][jc+i].getcolor()!=blanca) return true;
            else return false;
          }
          else return true;
        }
        else{
          if(Taulell.PosOcupada(ic,jc+i)) return false;
        }
        ++i;
      }
    }

    else if(difi<0 && difj==0){
      int i = 1;
      while((ic-i)>=0){
        if(ic-i==ifi && jc==jfi){
          if(Taulell.PosOcupada(ic-i,jc)){
            if(Taulell.getBoard()[ic-i][jc].getcolor()!=blanca) return true;
            else return false;
          }
          else return true;
        }
        else{
          if(Taulell.PosOcupada(ic-i,jc)) return false;
        }
        ++i;
      }
    }

    else if(difi>0 && difj==0){
      int i = 1;
      while((ic+i)<8){
        if(ic+i==ifi && jc==jfi){
          if(Taulell.PosOcupada(ic+i,jc)){
            if(Taulell.getBoard()[ic+i][jc].getcolor()!=blanca) return true;
            else return false;
          }
          else return true;
        }
        else{
          if(Taulell.PosOcupada(ic+i,jc)) return false;
        }
        ++i;
      }
    }
    else return false;

    return false;
  }
*/