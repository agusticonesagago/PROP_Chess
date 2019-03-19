package domini;

import javafx.util.Pair;


public class Jugador {
    protected Integer ID;
    protected Integer Winrate;


    public Jugador (Integer id) {
        ID = id;
        Winrate = 0;
    }

    public Void moureFitxa() {
        //llegir les variales de teclat
        Pair<Integer, Integer> posini = getPosini();
        Pair<Integer, Integer> posfi = getPosfi();
    }

    protected Pair getPosini() {}

    protected Pair getPosfi() {}

    /* GETTERS */
    public Integer getID() {
        return ID;
    }

    public Integer getWinrate() {
        return Winrate;
    }

    /* SETTERS */
    public Void setID(Integer id) {
        ID = id;
    }

    public Void setWintate(Integer wr) {
        Winrate = wr;
    }
}