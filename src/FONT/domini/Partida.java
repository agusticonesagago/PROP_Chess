package domini;


public class Partida {
    private Boolean Guanyador;
    private Integer Torn;
    private Boolean QuiJuga;
    private Taulell Board;
    private Problema Problem;
    //  private Jugador Blanques;
    //  private Jugador Negres;

    public Partida(Problema P /*Jugador b, Jugador n*/) {
        this.Problem = P;
        //    this.Blanques = b;
        //    this.Negres = n;

        // Decomposició de FEN
        String FEN = P.getFEN();

        int endOfBoard = FEN.indexOf(" ");
        String Taulell_FEN = FEN.substring(0, endOfBoard);
        Board = new Taulell(Taulell_FEN);
        char PlayerTurn = FEN.charAt(endOfBoard + 1);
        if (PlayerTurn == 'w') QuiJuga = true;
        else QuiJuga = false;
        Guanyador = null;
        // int halfmove = Character.getNumericValue(FEN.charAt(endOfBoard + 7));
        Torn = Character.getNumericValue(FEN.charAt(endOfBoard + 9));
    }

    public void jugarTorn() {
        if (QuiJuga) {       // Torn Blanques

        }
        else {

        }
    }

    public boolean getGuanyador() {
        return Guanyador;
    }

    public Integer getTorn() {
        return Torn;
    }

    public boolean getQuiJuga() {
        return QuiJuga;
    }

    public Taulell getTaulell() {
        return Board;
    }

    public Problema getProblema() {
        return Problem;
    }

}