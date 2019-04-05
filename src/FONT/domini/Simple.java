package domini;

import com.sun.deploy.util.SyncAccess;
import javafx.util.Pair;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.ArrayList;



public class Simple extends Maquina{
    public Simple(Integer id) {
        super(id);
    }



    // TODO Versio -> Blanc o negre min max.


    // Min max functions
    // TODO Pot ser canviar la mecanica de moure fitxa?
    @Override
    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moureFitxa(Partida ptd, boolean jugantCom, int torns) {
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
                        posiblesTaulells.add(x);
                        Moviments.add(new Pair<>(new Pair<>(i, j), movs.get(z)));
                    }
                }
            }
        }


        /* Evaluem el potencial de cada posible taulell segons el benefici que aquest ens aporta, i ens quedem nomes
        *  amb aquell que ens aporta més.*/


        Pair<Pair<Integer,Integer>, Pair<Integer,Integer>> millorMoviment = null;
        int trns = (torns);

        int evalMax;
        if (jugantCom) evalMax = -1000000;
        else evalMax = 1000000;



        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > mvs_enemic = new ArrayList<>();
        King k = (King) t.findKing(jugantCom);
        if (!rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), t, jugantCom)){
            Taulell aux_t, aux_te;
            for (int i=0; i < Moviments.size(); ++i){
                aux_t = new Taulell(t);
                aux_t.ferMoviment(Moviments.get(i).getKey(), Moviments.get(i).getValue());
                mvs_enemic.clear();
                getMoves(aux_t,!jugantCom, mvs_enemic);
                boolean salvat = true;
                for(int j=0; j < mvs_enemic.size(); ++j){
                    aux_te = new Taulell(aux_t);
                    aux_te.ferMoviment(mvs_enemic.get(j).getKey(), mvs_enemic.get(j).getValue());
                    if (aux_te.findKing(jugantCom) == null) salvat = false;
                }
                if (salvat) {
                    int a_eval = evaluataullel(posiblesTaulells.get(i), !jugantCom, -1000000,1000000,trns);

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

            evalMax = evaluataullel(posiblesTaulells.get(0), !jugantCom,-1000000,1000000, trns);
            millorMoviment = Moviments.get(0);

            System.out.println(Moviments.get(0)+"---- "+evalMax+" ----");
            for (int i=1; i < posiblesTaulells.size(); ++i) {
                int aux = evaluataullel(posiblesTaulells.get(i), !jugantCom,-1000000,1000000, trns);
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
                System.out.println(Moviments.get(i)+"----- "+aux+" ----"+i);
            }
        }

        System.out.println("La millor jugada és: ["+millorMoviment.getKey().getKey()+","+millorMoviment.getKey().getValue()+"] -> ["+millorMoviment.getValue().getKey()+","+millorMoviment.getValue().getValue()+"]" +
                "amb una puntuació de :"+evalMax);


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

            if (taulell.findKing(!jugantCom)!= null && escac_mat(taulell, jugantCom)) {
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
        getMoves(taulell, jugantCom, mvs);
        // Cas que volem maximitzar la puntuació -> jugador a maximitzar (qui aplica el algorisme)
        if (jugantCom == true) {
            // Ara agafem busquem aquell moviment que port a la maxima puntuació
                int nAlpha = alpha;
                boolean escac_mat = true;

                King k = (King) taulell.findKing(jugantCom);
                if (k == null) {
                    return -1000;
                }
                if (rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(), taulell, true)) {

                    for (int i = 0; i < mvs.size(); ++i) {
                        Pair<Integer, Integer> posini = mvs.get(i).getKey();
                        Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                        Taulell aux = new Taulell(taulell);
                        aux.ferMoviment(posini, posfi);
                        int ev = evaluataullel(aux, !jugantCom, nAlpha, beta, torns - 1);

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
                        int ev = evaluataullel(aux, !jugantCom, nAlpha, beta, torns-1);
                        k = (King) aux.findKing(jugantCom);
                        if (!rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(), aux, true) || k == null) {
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
            boolean escact_mat = true;

            King k = (King) taulell.findKing(jugantCom);
            if (k == null) {
                return 1000;
            }
            if (rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(), taulell, true)) {
                Taulell aux;
                for (int i = 0; i < mvs.size(); ++i) {
                    Pair<Integer, Integer> posini = mvs.get(i).getKey();
                    Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                    aux = new Taulell(taulell);
                    aux.ferMoviment(posini, posfi);
                    int ev = evaluataullel(aux, true, alpha, nBeta, torns - 1);


                    //System.out.println(mvs.get(i) + "---> " + ev);

                    if (ev != -1000) escact_mat = false;
                    if (ev < nBeta) nBeta = ev;
                    if (nBeta < alpha) break;
                }
                return nBeta;
            } else {
                System.out.println("IM HERE");
                for (int i = 0; i < mvs.size(); ++i) {
                    Pair<Integer, Integer> posini = mvs.get(i).getKey();
                    Pair<Integer, Integer> posfi = mvs.get(i).getValue();

                    Taulell aux= new Taulell(taulell);
                    aux.ferMoviment(posini, posfi);
                    int ev = evaluataullel(aux, !jugantCom, alpha, nBeta, torns-1);
                    k = (King) aux.findKing(jugantCom);
                    if (!rei_segur(k.getposicioactual().getKey(),k.getposicioactual().getValue(), aux, false)) {
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


    private void getMoves(Taulell taulell, boolean jugantCom, ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> mvs) {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (taulell.PosOcupada(i, j) && taulell.getBoard()[i][j].getcolor() == jugantCom) {
                    Peca p = taulell.getBoard()[i][j];
                    for (int z = 0; z < 8; ++z) {
                        for (int w = 0; w < 8; ++w) {
                            if (p.espotmoure(new Pair<>(z, w))) { // if mov valid -> add a mvs
                                mvs.add(new Pair<>(new Pair<>(i, j), new Pair<>(z, w)));
                            }
                        }
                    }
                }
            }
        }
    }



    private boolean  rei_segur(int i, int j, Taulell t, boolean jugantCom) {
        if (jugantCom) {
            boolean moviment_segur = true;
            for (int b = 0; b < t.getPeces_Negres().size(); ++b) {
                if (t.getPeces_Negres().get(b).espotmoure(new Pair<>(i, j))) {
                    moviment_segur = false;
                }
            }
            return moviment_segur;
        } else {
            boolean moviment_segur = true;
            for (int b = 0; b < t.getPeces_Blanques().size(); ++b) {

                if (t.getPeces_Blanques().get(b).espotmoure(new Pair<>(i, j))) {
                    moviment_segur = false;
                }
            }
            return moviment_segur;
        }
    }

        public boolean escac_mat(Taulell taulell, boolean jugantCom) {
        // TODO revisar com va aixó

            ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> mvs_meu = new ArrayList<>();
            ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> mvs_enemic = new ArrayList<>();
            getMoves(taulell, jugantCom, mvs_meu);
            boolean escacmat = true;
            for (int i = 0; i < mvs_meu.size(); ++i) {
                Taulell x = new Taulell(taulell);
                x.ferMoviment(mvs_meu.get(i).getKey(), mvs_meu.get(i).getValue());
                mvs_enemic.clear();
                getMoves(x, !jugantCom, mvs_enemic);

                boolean salvat = true;
                for (int j = 0; j < mvs_enemic.size(); ++j) {
                    Taulell aux = new Taulell(x);
                    aux.ferMoviment(mvs_enemic.get(j).getKey(), mvs_enemic.get(j).getValue());
                    if (aux.findKing(jugantCom) == null) {
                        salvat = false;
                    }
                }
                if (salvat){
                    escacmat = false;
                }
            }

            return escacmat;
     }





    // Establim estandars de costos. Inicialment:
    /*
    Peo -> 10
    Caball -> 30
    Alfil  -> 30
    Torre  -> 50
    Reina  -> 100
    Rei    -> 1000

    Tenim en compte que les blanques sumen (es a dir busquen el maxim benefici +) i les negres busquen el minim benefici (es a dir
    el numero mes petit -)
    */


    private int calculTaulell(Taulell taulell) {
        int total = 0;
        for(int i=0; i < 8; ++i) {
            for(int j=0; j < 8; ++j) {
                if (taulell.PosOcupada(i,j)) {
                    Peca p = taulell.getBoard()[i][j];
                    if (p.getcolor()) { // White
                        if (p.getClass().getName() =="domini.Pawn")         total += 10;
                        else if (p.getClass().getName() == "domini.Knight") total += 30;
                        else if (p.getClass().getName() == "domini.Bishop") total += 30;
                        else if (p.getClass().getName() == "domini.Rook")   total += 50;
                        else if (p.getClass().getName() == "domini.Queen")  total += 100;
                        else if (p.getClass().getName() == "domini.King")   total += 1000;
                    } else {
                        if (p.getClass().getName() =="domini.Pawn")         total -= 10;
                        else if (p.getClass().getName() == "domini.Knight") total -= 30;
                        else if (p.getClass().getName() == "domini.Bishop") total -= 30;
                        else if (p.getClass().getName() == "domini.Rook")   total -= 50;
                        else if (p.getClass().getName() == "domini.Queen")  total -= 100;
                        else if (p.getClass().getName() == "domini.King")   total -= 1000;
                    }
                }
            }
        }
        return total;
    }
}

