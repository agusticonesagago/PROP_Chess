package domini;

import javafx.util.Pair;


public class Jugador {
    protected Integer ID;
    protected Integer Winrate;


    public Jugador (Integer id) {
        ID = id;
        Winrate = 0;
    }

    // Operació abstracta
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Taulell t, boolean jugantCom) {
        return null;
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

    public void setWinrate(Integer wr) {
        Winrate = wr;
    }
}