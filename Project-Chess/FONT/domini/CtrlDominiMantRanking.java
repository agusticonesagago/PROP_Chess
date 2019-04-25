package domini;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class CtrlDominiMantRanking {
    private TreeMap<String, Vector<Ranking>> Rankings;
    private CtrlDades ctrlD;

    public CtrlDominiMantRanking() {
        //inicialitzar el treeMap amb les dades de Json
        Rankings = new TreeMap<String, Vector<Ranking>>();
        ctrlD =  ctrlD.getInstance();
    }

    public Vector<String> consultaRankings() {
        Vector<String> dades = new Vector<String>();
        Set setkeys = Rankings.keySet();
        Iterator iterkeys = setkeys.iterator();
        while (iterkeys.hasNext()) {
            String nomj = (String) iterkeys.next();
            Vector<Ranking> rank = Rankings.get(nomj);
            for (int i = 0; i < rank.size(); ++i) {
                String s = "";
                s += rank.get(i).getJugador(); s += " ";
                s += rank.get(i).getTemps(); s += " ";
                s += rank.get(i).getProblema();
                dades.add(s);
            }
        }
        return dades;
    }

    //Possibles casos
    //int = 0: la clau no existeix (la persona encara no ha fet cap problema)
    //int = 1: la persona ja ha fet algun problema pero no aquest
    //int = 2: la persona ja ha fet aquest problema i te millor temps que el registrat
    //int = 3: la pesonar ja ha fet aquest problema i te pitjor temps que el registrat
    private int existeixRankings (String nomj, Vector<String> dades) {
        if(Rankings.containsKey(nomj)) {
            Ranking newr = new Ranking();
            String nomp = dades.get(1);
            Float temps = new Float(dades.get(2));
            newr.setJugador(nomj);
            newr.setProblema(nomp);
            newr.setTemps(temps);
            Vector <Ranking> ranks = Rankings.get(nomj);
            if ( miraSiHiEs(newr, ranks) != -1){
                if(Integer.parseInt(dades.get(2)) >= ranks.get(miraSiHiEs(newr, ranks)).getTemps()) {
                    return 3;
                }
                return 2;
            }
            else return 1;
        }
        else return 0;
    }

    public int altaRanking (String nomj, Vector<String> dades) {
        int cas = existeixRankings(nomj, dades);
        if (cas == 3)
            return 1;
        if (!nomj.equals(dades.get(0)))
            return 2;
        else {
            Ranking newr = new Ranking();
            String nomp = dades.get(1);
            Float temps = new Float(dades.get(2));
            newr.setJugador(nomj);
            newr.setProblema(nomp);
            newr.setTemps(temps);
            afegirRanking(newr, cas);
            ctrlD.afegeixRanking(nomj, nomp, temps);
        }
        return 0;
    }

    public int baixaRankings (String nomj, Vector<String> dades) {
        int cas = existeixRankings(nomj, dades);
        if (cas == 0 || cas == 1)
            return 1;
        else {
            Ranking newr = new Ranking();
            String nomp = dades.get(1);
            Float temps = new Float(dades.get(2));
            newr.setJugador(nomj);
            newr.setProblema(nomp);
            newr.setTemps(temps);
            esborraRanking(newr);
            ctrlD.eliminaRanking(nomj, nomp, temps);
        }
        return 0;
    }

    private int miraSiHiEs (Ranking ra, Vector<Ranking> ras) {
        int HiEs = -1;
        for (int i = 0; i < ras.size(); i++) {
            if(ra.equals(ras.get(i))) HiEs = i;
        }
        return HiEs;
    }

    private void afegirRanking (Ranking ra, int cas) {
        if (cas == 0) {
            Vector <Ranking> ras = new Vector<>();
            ras.add(ra);
            Rankings.put(ra.getJugador(),ras);
        }
        else if (cas == 1) {
            Vector <Ranking> ranks = Rankings.get(ra.getJugador());
            ranks.add(ra);
        }
        else if (cas == 2) {
            Vector <Ranking> ranks = Rankings.get(ra.getJugador());
            int on = miraSiHiEs(ra, ranks);
            ranks.get(on).setTemps(ra.getTemps());
        }
    }

    private void esborraRanking(Ranking ra) {
        Vector <Ranking> ranks = Rankings.get(ra.getJugador());
        int on = miraSiHiEs(ra, ranks);
        ranks.remove(on);
        if (ranks.size() == 0) Rankings.remove(ra.getJugador());
    }
}