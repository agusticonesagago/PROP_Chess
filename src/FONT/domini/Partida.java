package domini;



import javafx.util.Pair;

import javax.swing.text.StyledEditorKit;

public class Partida {
    protected Boolean Guanyador;
    protected Integer Torn;
    protected Boolean QuiJuga;
    protected Taulell Board;
    protected Problema Problem;
    protected Jugador Blanques;
    protected Jugador Negres;
    protected Boolean QuiHaDeGuanyar;
    protected Integer QuantTorn;

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
            else if (PlayerTurn == 'b') QuiJuga = false;
            else QuiJuga = null;
            Guanyador = null;
            Torn = 0;
        }

        Pair gTM = P.getTornMat();
        this.QuiHaDeGuanyar = (Boolean) gTM.getValue();
        this.QuantTorn = (Integer) gTM.getKey();
    }

    public void jugarTorn(int tRestants) {
        if (QuiJuga) {          // Torn Blanques
            boolean LegalMoves = false;
            while (!LegalMoves) {
                LegalMoves = true;
                Pair<Pair<Integer,Integer>, Pair<Integer, Integer> > mov = Blanques.moureFitxa(this, true, tRestants);

                String state = Board.ferMoviment(mov.getKey(), mov.getValue()); // Si es valid s'actualitza taulell

                if (!state.isEmpty()){
                    System.out.println(state);
                    LegalMoves = false;
                }
                if (LegalMoves) System.out.println("El moviment Fet és: "+mov);
            }

            if (Board.escac_mat(!QuiHaDeGuanyar) && Torn.equals(QuantTorn)) {
                Guanyador = QuiHaDeGuanyar;
            } else if (Torn.equals(QuantTorn)) {
                Guanyador = !QuiHaDeGuanyar;
            }


            QuiJuga = !QuiJuga;// else -> Update QuiJuga
        }
        else {                  // torn negres
            boolean LegalMoves = false;
            while (!LegalMoves) {
                LegalMoves = true;
                Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > mov = Negres.moureFitxa(this, false,tRestants);
                String state;
                System.out.println("From "+Board.getBoard()[mov.getKey().getKey()][mov.getKey().getValue()].getClass());
                if (mov == null) state = "ERROR mov valor null";
                else state = Board.ferMoviment(mov.getKey(), mov.getValue());
                if (!state.isEmpty()) {
                    System.out.println(state);
                    LegalMoves = false;
                    if(state == "ERROR mov valor null") LegalMoves = true;
                }
                if (LegalMoves) System.out.println("El moviment Fet és: "+mov);

            }
            ++Torn;

            if (Board.escac_mat(!QuiHaDeGuanyar) && Torn.equals(QuantTorn)) {
                Guanyador = QuiHaDeGuanyar;
            } else if (Torn.equals(QuantTorn)) {
                Guanyador = !QuiHaDeGuanyar;
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

    public Jugador getBlanques () { return Blanques;}

    public  Jugador getNegres  () { return Negres;}

}