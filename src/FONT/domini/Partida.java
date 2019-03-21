package domini;



// TODO -> FROM BOARD TO FEN


public class Partida {
    private Boolean Guanyador;
    private Integer Torn;
    private Boolean QuiJuga;
    private Taulell Board;
    private Problema Problem;
    private Jugador Blanques;
    private Jugador Negres;

    public Partida(Problema P ,Jugador blanques, Jugador negres) {
        this.Problem = P;
        this.Blanques = blanques;
        this.Negres = negres;

        // Decomposició de FEN
        String FEN = P.getFEN();
        if (!FEN.isEmpty()) {
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
    }

    public void jugarTorn() {
        if (QuiJuga) {       // Torn Blanques
            System.out.println("TORN BLANQUES");
            // Blanques moure fitxa
            // Board actualitzar
            // ++Torn ja que son les blanques
            // Check if end of Game
            QuiJuga = !QuiJuga;// else -> Update QuiJuga
        }
        else {
            System.out.println("TORN NEGRES");
            // Negres moure fitxa
            // Board actualitzar
            // Cheeck if end of Game
            QuiJuga = !QuiJuga; // else -> Update QuiJuga

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