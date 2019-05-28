package domini;


import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;

public class Peca{


    protected boolean color; // true(blanc) i false(negre)
    protected Pair<Integer,Integer> posactual;
    private Image img;


    public Peca(boolean color, Pair<Integer,Integer> posactual) {
      this.color = color;
      this.posactual = new Pair<>(posactual.getKey(), posactual.getValue());
      this.img = null;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getImage() {
        return img;
    }

    protected Boolean caselladins(Pair<Integer,Integer> pos){
      int i = pos.getKey();
      int j = pos.getValue();
      if(i<0 || i>=8 || j<0 || j>=8 ) return false;
      else return true;
    } /////////////////////////////////////////////////Potser hauria de ser del taulell

    public Boolean espotmoure(Pair<Integer,Integer> posfinal){ //potser nomes fa falta posfinal
        System.out.println("NO MAGAFA EL ESPECIE");
        return false;
    }


    public boolean getcolor () {
      return color;
    }

    public Pair<Integer,Integer> getposicioactual () {
      return posactual;
    }

    /* SETTERS */

    public void mourepeca(Pair<Integer,Integer> posfinal) {
      this.posactual = posfinal;
    }

    public ArrayList<Pair<Integer, Integer>> posicionsposible() {
        return null;
    }
}
