package domini;

import javafx.util.Pair;
import java.util.Scanner;


public class Huma extends Jugador {

    public Huma (Integer id) {
        super(id);
    }

    public void consultarTutorial() {}

    public void escollirTutorial() {}

    public Boolean registrar() {
        return false;
    }

    protected Pair getPosini() {
        //llegir de teclat
        String teclat = "";
        Scanner escaner = new Scanner (System.in);
        teclat = escaner.nextLine ();
        int posicioX= Integer.parseInt(teclat);
        teclat = escaner.nextLine ();
        int posicioY = Integer.parseInt(teclat);
        //System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
        return new Pair<Integer, Integer>(posicioX, posicioY);
        //return null;
    }

    protected Pair getPosfi() {
        //llegir de teclat
        /*
        int i, j;
        return new Pair<Integer,Integer>(i, j);
        */
        return null;
    }
}