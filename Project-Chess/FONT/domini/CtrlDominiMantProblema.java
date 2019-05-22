package domini;
// TODO - Update with usage of  CP.

import javafx.util.Pair;
import persistencia.CtrlPersistenciaProblemes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class CtrlDominiMantProblema {
    private TreeMap<String, Problema> Problemes;
    private CtrlPersistenciaProblemes ctrlD;

    public CtrlDominiMantProblema() throws FileNotFoundException {
        // TODO inicialitzar el treeMap amb les dades de Json
        ctrlD =  new CtrlPersistenciaProblemes();
        List<Problema> problemesGuardats = ctrlD.getProblemes();
        Problemes = new TreeMap<String, Problema>();
        if (!problemesGuardats.isEmpty()){
            for(int i = 0; i < problemesGuardats.size(); i++) {
                Problemes.put(problemesGuardats.get(i).getFEN(),problemesGuardats.get(i));
            }
        }

    }

    public Vector<Vector<String>> consultaProblemes() {
        Vector<Vector<String>> dades = new Vector<>();
        Set setkeys = Problemes.keySet();
        Iterator iterkeys = setkeys.iterator();
        while (iterkeys.hasNext()) {
            String fenp = (String) iterkeys.next();
            Problema prob = Problemes.get(fenp);
            Vector <String> pr = new Vector<>();

            pr.add(0,prob.getFEN());
            pr.add(1,prob.getTema());
            pr.add(2,prob.getDificultat());
            dades.add(pr);
        }
        return dades;
    }

    private boolean existeixProblema (String fenp) {
        return Problemes.containsKey(fenp);
    }

    public int altaProblema (String fenp, Vector<String> dades) throws IOException {
        if (existeixProblema(fenp))
            return 1;                       //1 = Error, el problema ja existeix
        if (fenp != (dades.get(0)))
            return 2;                       //2 = Error, el primer camp no coincideix amb el fen
        else { // Alta del jugador
            Problema newp = new Problema();
            String temap = dades.get(1);
            String difp = dades.get(2);
            newp.setFEN(fenp);
            newp.setTema(temap);
            newp.setDificultat(difp);
            if (teSolucio(newp)) {
                Problemes.put(fenp,newp);
                ctrlD.afegirProblema(newp);
            }
            else return 3; //3 = Error, el fen no te solucio o no compleix les normes
        }
        return 0;
    }

    public int baixaProblema (String fenp) throws IOException {
        if (!existeixProblema(fenp))
            return 1; //1 = Error, el problema no existeix
        else {
            Problema a = Problemes.get(fenp);
            Problemes.remove(fenp);
            ctrlD.eliminarProblema(a);
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
        System.out.println(fen);
        for (int row_pointer = 0; row_pointer < fen.length(); row_pointer++){
            Character f = fen.charAt(row_pointer);
            if (f.equals(' ')) break;
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
            if (cb > 2)System.out.println(cb);

            return false;
        }
        else {
            Pair<Integer, Boolean> tornMat= prob.getTornMat();
            Partida sim = new Partida(prob, new Simple(1), new Simple(2));
            Integer tornsRestants = (tornMat.getKey());
            boolean quiMou = prob.getTornMat().getValue();
            while (tornsRestants > 0) {
                sim.jugarTorn(tornsRestants);
                if (quiMou == tornMat.getValue()) tornsRestants--;
                quiMou = !quiMou;
            }
            if (sim.getGuanyador() && tornMat.getValue()) return true;
            else if (!sim.getGuanyador() && !tornMat.getValue()) return true;
            else return false;
        }
    }
}