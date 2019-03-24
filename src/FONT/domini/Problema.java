package domini;

import com.sun.org.apache.xpath.internal.operations.Bool;



public class Problema {
    protected String Tema;
    protected String Dificultat;
    protected String FEN;
    protected CtrlDades CtrlD;
    protected Partida Sim;

    public Problema (String t, String fen) {
        Tema = t;
        Dificultat = "facil";
        FEN = fen;
        if (teSolucio(this)) {
            CtrlD = new CtrlDades();
            CtrlD.add(fen, dif, t);//deixar constancia a la base de dades
        }
        //mostrar error;
    }

    public Problema cercaProblema(String fen) {
        if (CtrlD.find(fen)) {//return CtrlD.getProblema(fen);
            return CtrlD.giveme(fen);
        }
        else null;
    }

    public void eliminarProblema(String fen) {
        CtrlD.destroyProblema(fen);
    }

    public void modificarProblema (String fen, String t) {
        FEN = fen;
        Dificultat = dif;
        Tema = t;
        CtrlD.modifica(fen, t, dif);
    }

    public boolean teSolucio(Problema prob) {
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
        String fen = prob.getFEN();
        for (int row_pointer = 0; row_pointer < fen.length(); row_pointer++){
            Character f = fen.charAt(row_pointer);
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
        if ( (cK > 2) || (cQ > 2) || (cR > 2) || (cN > 2) || (cB > 2 ) || (cP > 8) || 
             (ck > 2) || (cq > 2) || (cr > 2) || (cn > 2) || (cb > 2) || (cp > 8) ) {
            return false;
        }
        else {
            Sim = new Partida(prob, null, null);
            if (Sim.simulacorrecte(fen)) {
                return true;
            }
            return false;
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