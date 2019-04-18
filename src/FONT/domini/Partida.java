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
        this.QuantTorn = (this.QuantTorn *2)-1;
    }

    public void jugarTorn(int tRestants) {
        String state;
        if (QuiJuga) {          // Torn Blanques
            boolean LegalMoves = false;
            while (!LegalMoves) {
                LegalMoves = true;
                Pair<Pair<Integer,Integer>, Pair<Integer, Integer> > mov = Blanques.moureFitxa(this, true, tRestants);
                if (mov != null) {
                    state = getState(mov);

                    if (!state.isEmpty()) {
                        System.out.println(state);
                        LegalMoves = false;
                        if (state.equals("ERROR mov valor null")) LegalMoves = true;
                    }
                    if (LegalMoves) System.out.println("El moviment Fet és: " + mov);
                } else {
                    System.out.println("Empat - No es pot fer cap moviment");
                    Guanyador = !QuiHaDeGuanyar;
                }
            }
            ++Torn;

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
                if (mov != null) {
                    state = getState(mov);

                    if (!state.isEmpty()) {
                        System.out.println(state);
                        LegalMoves = false;
                        if (state.equals("ERROR mov valor null")) LegalMoves = true;
                    }
                    if (LegalMoves) System.out.println("El moviment Fet és: " + mov);
                } else {
                    System.out.println("Empat - No es pot fer cap moviment");
                    Guanyador = !QuiHaDeGuanyar;
                }
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

    private String getState(Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> mov) {
        String state;
        if (Board.getBoard()[mov.getKey().getKey()][mov.getKey().getValue()] == null ) return "No Existeix la Peca";

        if (Board.getBoard()[mov.getKey().getKey()][mov.getKey().getValue()].getcolor() != QuiJuga){
            state = "No ets el propietari d'aquesta peca.";
        } else {
            // Comprovem que no matem al rei al moure
            Taulell aux = new Taulell(Board);
            state = aux.ferMoviment(mov.getKey(), mov.getValue());
            King k = (King) aux.findKing(QuiJuga);
            if (state.isEmpty() && !aux.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), QuiJuga)) {
                state = "Rei no segur";
            } else {
                state = Board.ferMoviment(mov.getKey(), mov.getValue()); // Si es valid s'actualitza taulell
            }
        }
        return state;
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