package domini;


import java.util.ArrayList;


public class CtrlDomini {
    Problema problema;
    Jugador jugador1;
    Jugador jugador2;
    Partida partida;
    CtrlDades ctrlD;
    Ranking ranking;

    public CtrlDomini () {
        problema = new Problema();
        partida = null;
        ranking = null;
        jugador1 = null;
        jugador2 = null;
        ctrlD = new CtrlDades(0);
    }

    public void carregapartida(/*String Problema,*/ String jugador1, String jugador2) {
        this.jugador1 = new Huma(1, jugador1);
        if (jugador2 == "Maquina1") this.jugador2 = new Simple (2);
        //else if (jugador2 == "Maquina2") this.jugador2 = new Complicat (2);
        else this.jugador2 = new Huma (2, jugador2);
        partida = new Partida (problema,this.jugador1, this.jugador2 );
        //partida.jugarTorn(2);
    }

    /* Opreacions relacionades amb PROBLEMES*/
    public ArrayList<String> llistaProblemes() {
        return ctrlD.allProb();
    }

    public Boolean creaProblema(String fen, String tema, String dificultat, CtrlDades ctrlD) {
        if (teSolucio(fen)){
            problema = new Problema(fen, tema, dificultat, ctrlD);
            return true;
        }
        return false;
    }

    public void setProblema(String fen, String t, String dif) {
        problema.setFEN(fen);
        problema.setTema(t);
        problema.setDificultat(dif);
        ctrlD.modifica(fen, t, dif);
    }

    public void eliminarProblema() {
        problema.eliminar();
    }

    public String getProblema() {
        String separacio = " ";
        String f = problema.getFEN();
        String t = problema.getTema();
        String d = problema.getDificultat();
        String res = f.concat(separacio);
        res.concat(t);
        res.concat(separacio);
        res.concat(d);
        return  res;
    }

    private boolean teSolucio(String fen) {
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
           Partida Sim = new Partida(null, null, null);
           //return Sim.simulacorrecte(fen);
            return true;
        }
    }
}