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
        if (QuiJuga) {          // Torn Blanques
            boolean LegalMoves = false;
            while (!LegalMoves) {
                LegalMoves = true;
                Pair<Pair<Integer,Integer>, Pair<Integer, Integer> > mov = Blanques.moureFitxa(this, true, tRestants);
                String state;

                // MIRA SI NO MOU PECA DE LALTRE EQUIP
                if (Board.getBoard()[mov.getKey().getKey()][mov.getKey().getValue()].getcolor() != QuiJuga){
                    state = "No ets el propietari d'aquesta peca.";
                } else {
                    King k = (King) Board.findKing(QuiJuga);
                    // MIRA SI EL MOVIMENT FA QUE EL REI ESTIGUI NO SEGUR
                    if (!Board.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), QuiJuga)) {
                        state = "El rei no esta segur en la posició : [" + k.getposicioactual().getKey() + "," + k.getposicioactual().getValue()
                                + "]";
                    } else {
                        state = Board.ferMoviment(mov.getKey(), mov.getValue()); // Si es valid s'actualitza taulell
                    }
                }

                if (!state.isEmpty()){
                    System.out.println(state);
                    LegalMoves = false;
                }
                if (LegalMoves) System.out.println("El moviment Fet és: "+mov);
            }
            ++Torn;

            if (Board.escac_mat(!QuiHaDeGuanyar) && Torn.equals(QuantTorn)) {
                Guanyador = QuiHaDeGuanyar;
            } else if (Torn.equals(QuantTorn)) {
                Guanyador = !QuiHaDeGuanyar;
            }

            System.currentTimeMillis();

            QuiJuga = !QuiJuga;// else -> Update QuiJuga
        }
        else {                  // torn negres
            boolean LegalMoves = false;
            while (!LegalMoves) {
                LegalMoves = true;
                Pair< Pair<Integer, Integer>, Pair<Integer, Integer> > mov = Negres.moureFitxa(this, false,tRestants);
                String state;

                // MIRA SI NO MOU PECA DE LALTRE EQUIP
                if (Board.getBoard()[mov.getKey().getKey()][mov.getKey().getValue()].getcolor() != QuiJuga){
                    state = "No ets el propietari d'aquesta peca.";
                } else {
                    King k = (King) Board.findKing(QuiJuga);
                    // MIRA SI EL MOVIMENT FA QUE EL REI ESTIGUI NO SEGUR
                    if (!Board.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), QuiJuga)) {
                        state = "El rei no esta segur en la posició : [" + k.getposicioactual().getKey() + "," + k.getposicioactual().getValue()
                                + "]";
                    } else {
                        state = Board.ferMoviment(mov.getKey(), mov.getValue()); // Si es valid s'actualitza taulell
                    }
                }

                else state = Board.ferMoviment(mov.getKey(), mov.getValue());


                if (!state.isEmpty()) {
                    System.out.println(state);
                    LegalMoves = false;
                    if(state.equals("ERROR mov valor null")) LegalMoves = true;
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