package domini;

import javafx.util.Pair;


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
        /*
        int i, j;
        return new Pair<Integer, Integer>(i, j);
        */
        return null;
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