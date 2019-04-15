package domini;

import javafx.util.Pair;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class CtrlDominiMantProblema {
    private TreeMap<String, Problema> Problemes;
    private CtrlDades ctrlD;

    public CtrlDominiMantProblema() {
        //inicialitzar el treeMap amb les dades de Json
        Problemes = new TreeMap<String, Problema>();
        CtrlDades ctrlD = new CtrlDades();
    }

    public Vector<String> consultaProblemes() {
        Vector<String> dades = new Vector<String>();
        Set setkeys = Problemes.keySet();
        Iterator iterkeys = setkeys.iterator();
        while (iterkeys.hasNext()) {
            String fenp = (String) iterkeys.next();
            Problema prob = Problemes.get(fenp);
            String s = "";
            s += prob.getFEN(); s += " ";
            s += prob.getTema(); s += " ";
            s += prob.getDificultat();
            dades.add(s);
        }
        return dades;
    }

    private boolean existeixProblema (String fenp) {
        return Problemes.containsKey(fenp);
    }

    public int altaProblema (String fenp, Vector<String> dades) {
        if (existeixProblema(fenp))
            return 1;                       //1 = Error, el problema ja existeix
        if (fenp != (dades.get(0)))
            return 2;                       //2 = Error, el primer camp no coincideix amb el fen
        else { // Alta del jugador
            Problema newp = new Problema();
            if (!newp.setFEN(fenp)) return -1;      //-1 = Error, dades no s'han pohut assignar
            String temap = dades.get(1);
            if (!newp.setTema(temap)) return -1;    //-1 = Error, dades no s'han pohut assignar
            String difp = dades.get(2);
            if (!newp.setDificultat(difp)) return -1; //-1 = Error, dades no s'han pohut assignar
            if (teSolucio(newp)) {
                Problemes.put(fenp,newp);
                ctrlD.afegeixProblema(fenp, temap, difp);
            }
            else return 3; //3 = Error, el fen no te solucio o no compleix les normes
        }
        return 0;
    }

    public int baixaProblema (String fenp) {
        if (!existeixProblema(fenp))
            return 1; //1 = Error, el problema no existeix
        else {
            Problemes.remove(fenp);
            ctrlD.eliminaProblema(fenp);
        }
        return 0;
    }

    private boolean teSolucio(Problema prob) {
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
        if ( (cK != 1) || (cQ > 2) || (cR > 2) || (cN > 2) || (cB > 2 ) || (cP > 8) ||
                (ck != 1) || (cq > 2) || (cr > 2) || (cn > 2) || (cb > 2) || (cp > 8) ) {
            return false;
        }
        else {
            Partida sim = new Partida(prob, new Simple(1), new Simple(2));
            Pair<Integer, Boolean> tornMat= prob.getTornMat();
            Integer tornsRestants = tornMat.getKey();
            while (tornsRestants > 0) {
                sim.jugarTorn(tornsRestants);
                tornsRestants--;
            }
            if (sim.getGuanyador() && tornMat.getValue()) return true;
            else return false;
        }
    }
}
