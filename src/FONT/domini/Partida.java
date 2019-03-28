package domini;



// TODO -> FROM BOARD TO FEN


import javafx.util.Pair;
import sun.font.GlyphLayout;

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
            Torn = Character.getNumericValue(FEN.charAt(endOfBoard + 9));
        }
    }

    // TODO FALTA TESTING
    public void jugarTorn() {
        if (QuiJuga) {          // Torn Blanques
            boolean LegalMoves = false;
            while (!LegalMoves) {
                LegalMoves = true;
                Pair<Pair<Integer,Integer>, Pair<Integer, Integer> > mov = Blanques.moureFitxa(this, true, Torn);
                String state = Board.ferMoviment(mov.getKey(), mov.getValue()); // Si es valid s'actualitza taulell
                if (!state.isEmpty()){
                    System.out.println(state);
                    LegalMoves = false;
                }
            }
            if (Board.checkMate()) {
                // todo falta determinar si guanya o perd.
                System.out.println("WINNER");
            }
            QuiJuga = !QuiJuga;// else -> Update QuiJuga
        }
        else {                  // torn negres
            boolean LegalMoves = false;
            while (!LegalMoves) {
                LegalMoves = true;
                Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > mov = Negres.moureFitxa(this, false, Torn);
                String state;
                if (mov == null) state = "ERROR mov valor null";
                else state = Board.ferMoviment(mov.getKey(), mov.getValue());
                if (!state.isEmpty()) {
                    System.out.println(state);
                    LegalMoves = false;
                    if(state == "ERROR mov valor null") LegalMoves = true;
                }
            }
            ++Torn;
            if (Board.checkMate()) {
                System.out.println("WINNER");
            }
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