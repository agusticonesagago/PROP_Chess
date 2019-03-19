package domini;


public class Jugador {
    protected Integer ID;
    protected Integer Winrate;


    public Jugador (Integer id) {
        ID = id;
        Winrate = 0;
    }

    public Void moureFitxa() {
        int inix;
        int iniy;
        int fix;
        int fiy;
        Pair<Integer, Integer> posini = new Pair<>(inix, iniy);
        Pair<Integer, Integer> posfi = new Pair<>(fix, fiy);
    }

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