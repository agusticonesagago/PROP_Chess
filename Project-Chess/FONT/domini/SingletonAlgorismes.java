package domini;

import javafx.util.Pair;


import java.util.ArrayList;

public class SingletonAlgorismes {
    private static SingletonAlgorismes ourInstance = new SingletonAlgorismes();

    public static SingletonAlgorismes getInstance() {
        return ourInstance;
    }

    private SingletonAlgorismes() {
    }

    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moviment_minmax(Partida ptd, boolean jugantCom, int torns) {
        Taulell t = ptd.getTaulell();
        ArrayList<Taulell> posiblesTaulells = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> Moviments = new ArrayList<>();
        // FIND Posibles moviments
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (t.PosOcupada(i, j) && t.getBoard()[i][j].getcolor() == jugantCom) { // if pos ocupada i es una peca meva

                    ArrayList<Pair<Integer, Integer>> movs =  t.validarMoviments(t.getBoard()[i][j].posicionsposible(),
                            t.getBoard()[i][j].getClass().getName(), t.getBoard()[i][j]);
                    for (int z = 0; z < movs.size(); ++z) {
                        Taulell x = new Taulell(t);
                        x.ferMoviment(new Pair<>(i, j), movs.get(z));
                        King k = (King) x.findKing(jugantCom);
                        if (x.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom)) {
                            Moviments.add(new Pair<>(new Pair<>(i,j), movs.get(z)));
                            posiblesTaulells.add(x);
                        }
                    }
                }
            }
        }

        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> millorMoviment = null;
        int evalMax;
        if (Moviments.size() > 0) {
            evalMax = evaluataullel(posiblesTaulells.get(0), !jugantCom, jugantCom,-1000000, 1000000, torns-1);
            millorMoviment = Moviments.get(0);
            for (int i = 1; i < posiblesTaulells.size(); ++i) {
                int aux = evaluataullel(posiblesTaulells.get(i), !jugantCom, jugantCom, -1000000, 1000000, torns-1);
                if (jugantCom) {
                    if (aux > evalMax) {
                        evalMax = aux;
                        millorMoviment = Moviments.get(i);
                        if (evalMax == 1000) break;

                    }
                } else {
                    if (aux < evalMax) {
                        evalMax = aux;
                        millorMoviment = Moviments.get(i);
                        if (evalMax == -1000) break;
                    }
                }
            }
        }
        return millorMoviment;
    }


    public int evaluataullel(Taulell taulell, boolean jugantCom, boolean QuiMou, int alpha, int beta,  int torns) {

        if (torns == 0) {
            /* Cas Basic, en aquest cas evaluem el taullel segons l'assignació de valors esmentada en el document respectiu
            a la descripció de l'algorisme
             */
            if (taulell.findKing(jugantCom) == null){
                if (jugantCom) return -1000;
                else return 1000;
            }

            King k = (King) taulell.findKing(jugantCom);
            if (k != null) {
                boolean escacmat = taulell.escac_mat(jugantCom);
                if (taulell.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom) && escacmat) { // CAS EMPAT
                    if (jugantCom) return 1000;
                    else return -1000;
                } else if (escacmat) { // VICTORIA
                    if (jugantCom) return -1000;
                    else return 1000;
                } else { // STANDARD CASE
                   return calculTaulell(taulell);
                }
            }
        }


        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > mvs = taulell.getMoves(jugantCom);
        // Cas que volem maximitzar la puntuació -> jugador a maximitzar (qui aplica el algorisme)
        if (jugantCom) {
            // Ara agafem busquem aquell moviment que port a la maxima puntuació
            int nAlpha = alpha;

            King k = (King) taulell.findKing(true);
            if (k == null ) {
                return -1000;
            }
            if (mvs.size() == 0 && taulell.rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(), true)) {
                return 1000;
            }

            Taulell aux;
            for (int i = 0; i < mvs.size(); ++i) {
                Pair<Integer, Integer> posini = mvs.get(i).getKey();
                Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                aux = new Taulell(taulell);
                aux.ferMoviment(posini, posfi);
                int ev;
                if (QuiMou) ev = evaluataullel(aux, false, QuiMou, nAlpha, beta, torns - 1);
                else ev = evaluataullel(aux, false, QuiMou, nAlpha, beta, torns);

                if (ev > nAlpha) nAlpha = ev;
                if (beta < nAlpha) break;
            }
            return nAlpha;
        }
        // Cas que volem minimitzar la puntuació -> jugador a minimitar (contrincant)
        else {

            int nBeta = beta;
            King k = (King) taulell.findKing(false);
            if (k == null) {
                return 1000;
            }

            if (mvs.size() == 0 && taulell.rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(), false)) {
                return -1000;
            }

            Taulell aux;
            for (int i = 0; i < mvs.size(); ++i) {
                Pair<Integer, Integer> posini = mvs.get(i).getKey();
                Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                aux = new Taulell(taulell);
                aux.ferMoviment(posini, posfi);
                int ev;
                if (!QuiMou) ev = evaluataullel(aux,true, QuiMou, alpha, nBeta, torns-1);
                else ev = evaluataullel(aux, true, QuiMou, alpha, nBeta, torns);
                if (ev < nBeta) nBeta = ev;
                if (nBeta < alpha) break;
            }
            return nBeta;
        }
    }





    public int calculTaulell(Taulell taulell) {
        int total = 0;
        for(int i=0; i < 8; ++i) {
            for(int j=0; j < 8; ++j) {
                if (taulell.PosOcupada(i,j)) {
                    Peca p = taulell.getBoard()[i][j];
                    if (p.getcolor()) {
                        if (p.getClass().getName().equals("domini.Pawn"))        total += 10;
                        else if (p.getClass().getName().equals("domini.Knight")) total += 30;
                        else if (p.getClass().getName().equals("domini.Bishop")) total += 30;
                        else if (p.getClass().getName().equals("domini.Rook"))   total += 50;
                        else if (p.getClass().getName().equals("domini.Queen"))  total += 100;
                        else if (p.getClass().getName().equals("domini.King"))   total += 1000;
                    } else {
                        if (p.getClass().getName().equals("domini.Pawn"))        total -= 10;
                        else if (p.getClass().getName().equals("domini.Knight")) total -= 30;
                        else if (p.getClass().getName().equals("domini.Bishop")) total -= 30;
                        else if (p.getClass().getName().equals("domini.Rook"))   total -= 50;
                        else if (p.getClass().getName().equals("domini.Queen"))  total -= 100;
                        else if (p.getClass().getName().equals("domini.King"))   total -= 1000;
                    }
                }
            }
        }
        return total;
    }

}




