package domini;


import com.sun.org.apache.xpath.internal.operations.Bool;

public class Partida {
    private Boolean Guanyador;
    private Integer Torn;
    private Boolean QuiJuga;
    //  private Taullel Board;
    //  private Problema Problem;
    //  private Jugador Blanques;
    //  private Jugador Negres;
 
    public Partida() {
        String FEN = "1N1b4/6nr/R5n1/2Ppk2r/K2p2qR/8/2N1PQ2/B6B w - - 0 1";

        int  endOfBoard = FEN.indexOf(" ");
        String Taulell_FEN = FEN.substring(0, endOfBoard);


        char PlayerTurn = FEN.charAt(endOfBoard+1);
        if (PlayerTurn == 'w') QuiJuga = true;
        else QuiJuga = false;

        // Pot ser que ho fem servir mes tard
        int halfmove = Character.getNumericValue(FEN.charAt(endOfBoard+7));

        Torn = Character.getNumericValue(FEN.charAt(endOfBoard+9));

        /* No winner yet */
        Guanyador = null;
    }


    /* GETTERS */
    public Integer getTorn () {
        return Torn;
    }

    public Boolean getQuiJuga () {
        return QuiJuga;
    }

    public Boolean getGuanyador () {
        return Guanyador;
    }


    /* SETTERS */
    public void setTorn(Integer t) {
        Torn = t;
    }

    public void setQuiJuga(Boolean qj) {
        QuiJuga = qj;
    }

    public void setGuanyador (Boolean guanya) {
        Guanyador = guanya;
    }
}