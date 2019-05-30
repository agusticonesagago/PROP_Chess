package domini;

import javafx.util.Pair;

import java.util.ArrayList;

import static java.lang.Integer.min;

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
                System.out.println("Moviment: "+ i +" -> "+ Moviments.get(i)+ " " + aux); // moviments definitius
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



    public int evaluataullelM2(Taulell taulell, boolean jugantCom, boolean QuiMou,  int alpha, int beta, int torns, int pare,boolean noaprofundir) {
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
                } else if(noaprofundir){ // STANDARD CASE
                    if(calculTaulell(taulell)!=0) {
                        int porcentaje = pare/calculTaulell(taulell);
                        //if((porcentaje<=0.9) || (porcentaje>=1.1)) {
                        if ((porcentaje<=0.5) || (porcentaje>=2)) {
                            return evaluataullelM2(taulell, !jugantCom, QuiMou, alpha, beta, 1, pare,noaprofundir);
                        }
                        else {
                            return calculTaulell(taulell);
                        }
                    }
                    else{
                        if(pare==0) return calculTaulell(taulell);
                        else {
                            if (pare>=30) evaluataullelM2(taulell, !jugantCom, QuiMou, alpha, beta, 1, pare,noaprofundir);
                            else return calculTaulell(taulell);
                        }

                    }
                }else return calculTaulell(taulell);
            }
        }
        int taulellsuperior = 0; //inicialitzar
        ArrayList< Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> > mvs = taulell.getMoves(jugantCom);
        // Cas que volem maximitzar la puntuació -> jugador a maximitzar (qui aplica el algorisme)

        if(torns==1) taulellsuperior = calculTaulell(taulell);
        if (jugantCom) {
            // Ara agafem busquem aquell moviment que port a la maxima puntuació
            //System.out.println("entra blanques");
            int nAlpha = alpha;
            //System.out.println(torns);

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
                if(torns==1) taulellsuperior = calculTaulell(aux);
                aux.ferMoviment(posini, posfi);
                int ev;
                if (QuiMou) ev = evaluataullelM2(aux, false, QuiMou, nAlpha, beta, torns - 1,taulellsuperior,noaprofundir);
                else ev = evaluataullelM2(aux, false, QuiMou, nAlpha, beta, torns,taulellsuperior,noaprofundir);


                if (ev > nAlpha) nAlpha = ev;
                if (beta < nAlpha) break;
            }
            return nAlpha;
        }
        // Cas que volem minimitzar la puntuació -> jugador a minimitar (contrincant)
        else {
            //System.out.println("entra negres");
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
                if(torns==1) taulellsuperior = calculTaulell(aux);
                aux.ferMoviment(posini, posfi);
                int ev;
                if (!QuiMou) ev = evaluataullelM2(aux,true, QuiMou, alpha, nBeta, torns-1,taulellsuperior,noaprofundir);
                else ev = evaluataullelM2(aux, true, QuiMou, alpha, nBeta, torns,pare,noaprofundir);
                if (ev < nBeta) nBeta = ev;
                if (nBeta < alpha) break;
            }
            return nBeta;
        }
    }


    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moviment_esperadelreposo3prof(Partida ptd,boolean jugantCom, int minim){
        Taulell t = ptd.getTaulell();
        ArrayList<Taulell> posiblesTaulells = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> Moviments = new ArrayList<>();
        boolean noaprofundir = true;
        if(minim<=3) noaprofundir = false;
        minim = min(minim,3);
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
        int pare;
        if (Moviments.size() > 0) {
            evalMax = evaluataullelM2(posiblesTaulells.get(0), !jugantCom, jugantCom,-1000000, 1000000, minim-1,calculTaulell(posiblesTaulells.get(0)),noaprofundir);
            millorMoviment = Moviments.get(0);
            for (int i = 1; i < posiblesTaulells.size(); ++i) {
                //System.out.println("Hem mirat ja i");
                int aux = evaluataullelM2(posiblesTaulells.get(i), !jugantCom, jugantCom, -1000000, 1000000, minim-1,calculTaulell(posiblesTaulells.get(i)),noaprofundir);
                System.out.println("Moviment: "+ i +" -> "+ aux); // moviments definitius
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

    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moviment_esperadelreposo2prof(Partida ptd,boolean jugantCom, int minim){
        Taulell t = ptd.getTaulell();
        ArrayList<Taulell> posiblesTaulells = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> Moviments = new ArrayList<>();
        boolean noaprofundir = true;
        if(minim<=2) noaprofundir = false;
        minim = min(minim,2);
        // FIND Posibles moviments

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (t.PosOcupada(i, j) && t.getBoard()[i][j].getcolor() == jugantCom) { // if pos ocupada i es una peca meva
                    ArrayList<Pair<Integer, Integer>> movs =  t.getBoard()[i][j].posicionsposible();

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
        int pare;
        if (Moviments.size() > 0) {
            evalMax = evaluataullelM2(posiblesTaulells.get(0), !jugantCom, jugantCom,-1000000, 1000000, minim-1,calculTaulell(posiblesTaulells.get(0)),noaprofundir);
            millorMoviment = Moviments.get(0);
            for (int i = 1; i < posiblesTaulells.size(); ++i) {
                //System.out.println("Hem mirat ja i");
                int aux = evaluataullelM2(posiblesTaulells.get(i), !jugantCom, jugantCom, -1000000, 1000000, minim-1,calculTaulell(posiblesTaulells.get(i)),noaprofundir);
                System.out.println("Moviment: "+ i +" -> "+ aux); // moviments definitius
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

    public Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> moviment_ordenat_esperadelreposo(Partida ptd,boolean jugantCom, int minim){
        Taulell t = ptd.getTaulell();
        ArrayList<Taulell> posiblesTaulells = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> Moviments = new ArrayList<>();
        boolean noaprofundir = true;
        if(minim<=3) noaprofundir = false;
        minim = min(minim,3);
        // FIND Posibles moviments
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> MovimentsQueen = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> MovimentsKing = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> MovimentsPawn = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> MovimentsRook = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> MovimentsKnight = new ArrayList<>();
        ArrayList<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> MovimentsBishop = new ArrayList<>();
        ArrayList<Taulell> posiblesTaulellsQueen = new ArrayList<>();
        ArrayList<Taulell> posiblesTaulellsKing = new ArrayList<>();
        ArrayList<Taulell> posiblesTaulellsPawn = new ArrayList<>();
        ArrayList<Taulell> posiblesTaulellsRook = new ArrayList<>();
        ArrayList<Taulell> posiblesTaulellsKnight = new ArrayList<>();
        ArrayList<Taulell> posiblesTaulellsBishop = new ArrayList<>();

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (t.PosOcupada(i, j) && t.getBoard()[i][j].getcolor() == jugantCom) { // if pos ocupada i es una peca meva
                    if(t.getBoard()[i][j].getClass().getName()=="domini.Queen"){
                        ArrayList<Pair<Integer, Integer>> movs =  t.getBoard()[i][j].posicionsposible();

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
                    else if(t.getBoard()[i][j].getClass().getName()=="domini.Rook"){
                        ArrayList<Pair<Integer, Integer>> movs =  t.getBoard()[i][j].posicionsposible();

                        for (int z = 0; z < movs.size(); ++z) {
                            Taulell x = new Taulell(t);
                            x.ferMoviment(new Pair<>(i, j), movs.get(z));
                            King k = (King) x.findKing(jugantCom);
                            if (x.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom)) {
                                MovimentsRook.add(new Pair<>(new Pair<>(i,j), movs.get(z)));
                                posiblesTaulellsRook.add(x);
                            }
                        }
                    }
                    else if(t.getBoard()[i][j].getClass().getName()=="domini.King"){
                        ArrayList<Pair<Integer, Integer>> movs =  t.getBoard()[i][j].posicionsposible();

                        for (int z = 0; z < movs.size(); ++z) {
                            Taulell x = new Taulell(t);
                            x.ferMoviment(new Pair<>(i, j), movs.get(z));
                            King k = (King) x.findKing(jugantCom);
                            if (x.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom)) {
                                MovimentsKing.add(new Pair<>(new Pair<>(i,j), movs.get(z)));
                                posiblesTaulellsKing.add(x);
                            }
                        }
                    }
                    else if(t.getBoard()[i][j].getClass().getName()=="domini.Knight"){
                        ArrayList<Pair<Integer, Integer>> movs =  t.getBoard()[i][j].posicionsposible();

                        for (int z = 0; z < movs.size(); ++z) {
                            Taulell x = new Taulell(t);
                            x.ferMoviment(new Pair<>(i, j), movs.get(z));
                            King k = (King) x.findKing(jugantCom);
                            if (x.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom)) {
                                MovimentsKnight.add(new Pair<>(new Pair<>(i,j), movs.get(z)));
                                posiblesTaulellsKnight.add(x);
                            }
                        }
                    }
                    else if(t.getBoard()[i][j].getClass().getName()=="domini.Bishop"){
                        ArrayList<Pair<Integer, Integer>> movs =  t.getBoard()[i][j].posicionsposible();

                        for (int z = 0; z < movs.size(); ++z) {
                            Taulell x = new Taulell(t);
                            x.ferMoviment(new Pair<>(i, j), movs.get(z));
                            King k = (King) x.findKing(jugantCom);
                            if (x.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom)) {
                                MovimentsBishop.add(new Pair<>(new Pair<>(i,j), movs.get(z)));
                                posiblesTaulellsBishop.add(x);
                            }
                        }
                    }
                    else if(t.getBoard()[i][j].getClass().getName()=="domini.Pawn"){
                        ArrayList<Pair<Integer, Integer>> movs =  t.getBoard()[i][j].posicionsposible();

                        for (int z = 0; z < movs.size(); ++z) {
                            Taulell x = new Taulell(t);
                            x.ferMoviment(new Pair<>(i, j), movs.get(z));
                            King k = (King) x.findKing(jugantCom);
                            if (x.rei_segur(k.getposicioactual().getKey(), k.getposicioactual().getValue(), jugantCom)) {
                                MovimentsPawn.add(new Pair<>(new Pair<>(i,j), movs.get(z)));
                                posiblesTaulellsPawn.add(x);
                            }
                        }
                    }

                }
            }
        }


        for(int i=0; i<MovimentsRook.size();++i) {
            Moviments.add(MovimentsRook.get(i));
        }
        for(int i=0; i<posiblesTaulellsRook.size();++i) {
            posiblesTaulells.add(posiblesTaulellsRook.get(i));
        }

        for(int i=0; i<MovimentsKnight.size();++i) {
            Moviments.add(MovimentsKnight.get(i));
        }
        for(int i=0; i<posiblesTaulellsKnight.size();++i) {
            posiblesTaulells.add(posiblesTaulellsKnight.get(i));
        }

        for(int i=0; i<MovimentsBishop.size();++i) {
            Moviments.add(MovimentsBishop.get(i));
        }
        for(int i=0; i<posiblesTaulellsBishop.size();++i) {
            posiblesTaulells.add(posiblesTaulellsBishop.get(i));
        }

        for(int i=0; i<MovimentsPawn.size();++i) {
            Moviments.add(MovimentsPawn.get(i));
        }
        for(int i=0; i<posiblesTaulellsPawn.size();++i) {
            posiblesTaulells.add(posiblesTaulellsPawn.get(i));
        }

        for(int i=0; i<MovimentsKing.size();++i) {
            Moviments.add(MovimentsKing.get(i));
        }
        for(int i=0; i<posiblesTaulellsKing.size();++i) {
            posiblesTaulells.add(posiblesTaulellsKing.get(i));
        }

        Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> millorMoviment = null;

        int evalMax;
        int pare;
        if (Moviments.size() > 0) {
            evalMax = evaluataullelM2(posiblesTaulells.get(0), !jugantCom, jugantCom,-1000000, 1000000, minim-1,calculTaulell(posiblesTaulells.get(0)),noaprofundir);
            millorMoviment = Moviments.get(0);
            for (int i = 1; i < posiblesTaulells.size(); ++i) {
                //System.out.println("Hem mirat ja i");
                int aux = evaluataullelM2(posiblesTaulells.get(i), !jugantCom, jugantCom, -1000000, 1000000, minim-1,calculTaulell(posiblesTaulells.get(i)),noaprofundir);
                System.out.println("Moviment: "+ i +" -> "+ aux); // moviments definitius
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
}




