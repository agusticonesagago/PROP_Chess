package domini;

import javafx.util.Pair;


public class Jugador {
    protected Integer ID;
    protected Integer Winrate;


    public Jugador (Integer id) {
        ID = id;
        Winrate = 0;
    }

    public void moureFitxa() {
        //llegir les variales de teclat
        Pair<Integer, Integer> posini = getPosini();
        Pair<Integer, Integer> posfi = getPosfi();
    }

    protected Pair getPosini() {
        return null;
    }

    protected Pair getPosfi() {
        return null;
    }

    /* GETTERS */
    public Integer getID() {
        return ID;
    }

    public Integer getWinrate() {
        return Winrate;
    }

    /* SETTERS */
    public void setID(Integer id) {
        ID = id;
    }

    public void setWintate(Integer wr) {
        Winrate = wr;
    }
}