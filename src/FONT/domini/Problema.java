package domini;


public class Problema {
    protected String Tema;
    protected String Dificultat;
    protected String FEN;
    //protected CtrlDades CtrlD

    public Problema (String t, String dif, String fen) {
        Tema = t;
        Dificultat = dif;
        FEN = fen;
        //deixar constancia a la base de dades
    }

    public Problema cercaProblema(String fen) {
        //return CtrlD.getProblema(fen);
    }

    public void eliminarProblema(String fen) {
        //CtrlD.destroyProblema(fen);
    }

    public void modificarProblema (String fen, String t, String dif) {
        //CtrlD.modify(fen)
        FEN = fen;
        Dificultat = dif;
        Tema = t;

        //
    }

    public boolean teSolucio(fen) {
        int cK, cQ, cR, cN, cB, cP, ck, cq, cr, cn, cb, cp;
        cK = 0;
        cQ = 0;
        cR = 0;
        cN = 0;
        cB = 0;
        cP = 0;
        ck = 0;
        cq = 0;
        cr = 0;
        cn = 0;
        cb = 0;
        cp = 0;

        for (int row_pointer = 0; row_pointer < fen.lenght(); row_pointer++){
            Character f = fen.charAt(row_pointer);
            /* MAYUS -> white ? */
            if (f.equals('K')) { // REI
                ++cK;
            } else if (f.equals('Q')) { // REINA
                ++cQ;
            } else if (f.equals('R')) { // TORRE
                ++cR;
            } else if (f.equals('N')) { // CABALL
                ++cN;
            } else if (f.equals('B')) { // ALFIL
                ++cB;
            } else if (f.equals('P')) { // PEO
                ++cP;
            }
            /* minus -> black ?*/
            else if (f.equals('k')) { //rei
                ++ck;
            } else if (f.equals('q')) { //reina
                ++cq;
            } else if (f.equals('r')) { //torre
                ++cr;
            } else if (f.equals('n')) { // caball
                ++cn;
            } else if (f.equals('b')) { // alfil
                ++cb;
            } else if (f.equals('p')) { // peo
                ++cp;
            }
        }
        if ( (cK >= 2) || (cQ >= 2) || (cR >= 2) || (cN >= 2) || (cB >= 2 ) || (cP >= 2) || 
             (ck >= 2) || (cq >= 2) || (cr >= 2) || (cn >= 2) || (cb >= 2) || (cp >= 2) ) {
            return false;
        }
        else {
            return true;
        }
    }

    /* GETTERS */
    public String getTema() {
        return Tema;
    }

    public String getDificultat() {
        return Dificultat;
    }

    public String getFEN() {
        return FEN;
    }


    /* SETTERS */
    public void setTema(String t) {
        Tema = t;
    }

    public void setDificultat(String dif) {
        Dificultat = dif;
    }

    public void setFEN(String fen) {
        FEN = fen;
    }

}