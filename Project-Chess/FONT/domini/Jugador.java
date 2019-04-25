package domini;

import javafx.util.Pair;


public abstract class Jugador {
    protected Integer ID;
    protected Integer Winrate;


    public Jugador (Integer id) {
        ID = id;
        Winrate = 0;
    }

    public abstract Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns);




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