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
        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > Moviments = new ArrayList<>();

        // FIND Posibles moviments
        for (int i=0; i < 8; ++i) {
            for (int j=0; j < 8; ++j) {
                if (t.PosOcupada(i,j) && t.getBoard()[i][j].getcolor() == jugantCom) { // if pos ocupada i es una peca meva
                    ArrayList<Pair<Integer,Integer>> movs = new ArrayList<>();
                    for (int z=0; z<8; ++z){
                        for (int w=0; w < 8; ++w){
                            if (t.getBoard()[i][j].espotmoure(new Pair<>(z,w))) {
                                movs.add(new Pair<>(z,w));
                            }
                        }
                    }

                    for (int z=0; z < movs.size(); ++z){
                        // TODO  nova forma de copiar
                        Taulell x = new Taulell(t);
                        x.ferMoviment(new Pair<>(i, j), movs.get(z));
                        if (x.rei_segur(movs.get(z).getKey(), movs.get(z).getValue(), jugantCom)) {
                            posiblesTaulells.add(x);
                            Moviments.add(new Pair<>(new Pair<>(i, j), movs.get(z)));
                        }
                    }
                }
            }
        }

        Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> millorMoviment = null;
        int evalMax;
        if (jugantCom) evalMax = -1000000;
        else evalMax = 1000000;


        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > mvs_enemic = new ArrayList<>();
        King k = (King) t.findKing(jugantCom);
        if (!t.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom)){
            Taulell aux_t, aux_te;
            for (int i=0; i < Moviments.size(); ++i){
                aux_t = new Taulell(t);
                aux_t.ferMoviment(Moviments.get(i).getKey(), Moviments.get(i).getValue());
                mvs_enemic.clear();
                mvs_enemic = aux_t.getMoves(!jugantCom);
                boolean salvat = true;
                for(int j=0; j < mvs_enemic.size(); ++j){
                    aux_te = new Taulell(aux_t);
                    aux_te.ferMoviment(mvs_enemic.get(j).getKey(), mvs_enemic.get(j).getValue());
                    if (aux_te.findKing(jugantCom) == null) salvat = false;
                }
                if (salvat) {
                    int a_eval = evaluataullel(posiblesTaulells.get(i), !jugantCom, -1000000,1000000,torns);

                    if (jugantCom) {
                        if (a_eval > evalMax) {
                            evalMax = a_eval;
                            millorMoviment = Moviments.get(i);
                        }
                    } else {
                        if (a_eval < evalMax) {
                            evalMax = a_eval;
                            millorMoviment = Moviments.get(i);
                        }
                    }
                }
            }
            return  millorMoviment;
        } else {
            evalMax = evaluataullel(posiblesTaulells.get(0), !jugantCom,-1000000,1000000, torns);
            millorMoviment = Moviments.get(0);
            for (int i=1; i < posiblesTaulells.size(); ++i) {
                int aux = evaluataullel(posiblesTaulells.get(i), !jugantCom,-1000000,1000000, torns);
                if (jugantCom) {
                    if (aux > evalMax) {
                        evalMax = aux;
                        millorMoviment = Moviments.get(i);
                    }
                } else {
                    if (aux < evalMax) {
                        evalMax = aux;
                        millorMoviment = Moviments.get(i);
                    }
                }
            }
        }

        return millorMoviment;
    }


    public int evaluataullel(Taulell taulell, boolean jugantCom,int alpha, int beta,  int torns) {

        if (torns == 0) {
            /* Cas Basic, en aquest cas evaluem el taullel segons l'assignació de valors esmentada en el document respectiu
            a la descripció de l'algorisme
             */
            if (taulell.findKing(jugantCom) == null){
                if (jugantCom) return -1000;
                else return 1000;
            }

            if (taulell.findKing(!jugantCom)!= null && taulell.escac_mat(jugantCom)) {
                if (jugantCom) {
                    return -1000;
                }
                else {
                    return +1000;
                }
            }
            return calculTaulell(taulell);
        }


        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > mvs = new ArrayList<>();
        // Agafem tot l'arbre de moviments respectius a aquest torn
        mvs = taulell.getMoves(jugantCom);
        // Cas que volem maximitzar la puntuació -> jugador a maximitzar (qui aplica el algorisme)
        if (jugantCom == true) {
            // Ara agafem busquem aquell moviment que port a la maxima puntuació
            int nAlpha = alpha;

            King k = (King) taulell.findKing(true);
            if (k == null) {
                return -1000;
            }
            if (taulell.rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(), true)) {
                for (int i = 0; i < mvs.size(); ++i) {
                    Pair<Integer, Integer> posini = mvs.get(i).getKey();
                    Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                    Taulell aux = new Taulell(taulell);
                    aux.ferMoviment(posini, posfi);
                    int ev = evaluataullel(aux, false, nAlpha, beta, torns - 1);

                    if (ev > nAlpha) nAlpha = ev;
                    if (beta < nAlpha) break;
                }
                return nAlpha;
            } else {

                for (int i = 0; i < mvs.size(); ++i) {
                    Pair<Integer, Integer> posini = mvs.get(i).getKey();
                    Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                    Taulell aux = new Taulell(taulell);
                    aux.ferMoviment(posini, posfi);
                    int ev = evaluataullel(aux, false, nAlpha, beta, torns-1);
                    k = (King) aux.findKing(jugantCom);
                    if (!aux.rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(),true) || k == null) {
                        ev = -1000;
                    }
                    if (ev > nAlpha) nAlpha = ev;
                }
                return nAlpha;
            }
        }
        // Cas que volem minimitzar la puntuació -> jugador a minimitar (contrincant)
        else {
            int nBeta = beta;

            King k = (King) taulell.findKing(false);
            if (k == null) {
                return 1000;
            }
            if (taulell.rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(),true)) {
                Taulell aux;
                for (int i = 0; i < mvs.size(); ++i) {
                    Pair<Integer, Integer> posini = mvs.get(i).getKey();
                    Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                    aux = new Taulell(taulell);
                    aux.ferMoviment(posini, posfi);
                    int ev = evaluataullel(aux, true, alpha, nBeta, torns - 1);

                    if (ev < nBeta) nBeta = ev;
                    if (nBeta < alpha) break;
                }

                return nBeta;
            } else {

                for (int i = 0; i < mvs.size(); ++i) {
                    Pair<Integer, Integer> posini = mvs.get(i).getKey();
                    Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                    Taulell aux= new Taulell(taulell);
                    aux.ferMoviment(posini, posfi);
                    int ev = evaluataullel(aux, !jugantCom, alpha, nBeta, torns-1);
                    k = (King) aux.findKing(false);
                    if (!aux.rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(),false)) {
                        ev = 1000;
                    } else {
                        ev = -1000;
                    }
                    if (ev < nBeta) nBeta = ev;
                }
                return nBeta;
            }

        }
    }





    private int calculTaulell(Taulell taulell) {
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
