package domini;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class CtrlDominiMantRanking {
    private TreeMap<String, Ranking> Rankings;
    private CtrlDades ctrlD;

    public CtrlDominiMantRanking() {
        //inicialitzar el treeMap amb les dades de Json
        Rankings = new TreeMap<String, Ranking>();
        CtrlDades ctrlD = new CtrlDades();
    }

    public Vector<String> consultaRankings() {
        Vector<String> dades = new Vector<String>();
        Set setkeys = Rankings.keySet();
        Iterator iterkeys = setkeys.iterator();
        while (iterkeys.hasNext()) {
            String nomj = (String) iterkeys.next();
            Ranking rank = Rankings.get(nomj);
            String s = "";
            s += rank.getJugador(); s += " ";
            s += rank.getTemps(); s += " ";
            s += rank.getProblema();
            dades.add(s);
        }
        return dades;
    }

    private boolean existeixRankings (String nomj) {
        return Rankings.containsKey(nomj);
    }

    public int altaRanking (String nomj, Vector<String> dades) {
        if (existeixRankings(nomj))
            return 1;
        if (nomj != (dades.get(0)))
            return 2;
        else { // Alta del jugador
            Ranking newr = new Ranking();
            if (!newr.setJugador(nomj)) return -1;
            String nomp = dades.get(1);
            if (!newr.setProblema(nomp)) return -1;
            Integer temps = new Integer(dades.get(2));
            if (!newr.setTemps(temps)) return -1;
            Rankings.put(nomj,newr);
            ctrlD.afegeixRanking(nomj, nomp, temps);
        }
        return 0;
    }

    public int baixaRankings (String nomj) {
        if (!existeixRankings(nomj))
            return 1;
        else {
            Rankings.remove(nomj);
            ctrlD.eliminaRanking(nomj);
        }
        return 0;
    }
}